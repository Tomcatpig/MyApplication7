package com.example.xpaly.com.xpaly.fragment;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xpaly.R;
import com.example.xpaly.com.xpaly.activity.ArticleDetailsActivity;
import com.example.xpaly.com.xpaly.adapter.DiscoveryAdapter;
import com.example.xpaly.com.xpaly.adapter.HotMovieAdapter;
import com.example.xpaly.com.xpaly.application.MyApplication;
import com.example.xpaly.com.xpaly.pojo.HotMovieBean;
import com.example.xpaly.com.xpaly.pojo.RecommendMovieBean;
import com.example.xpaly.com.xpaly.utils.ToastShow;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DiscoveryFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DiscoveryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DiscoveryFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public DiscoveryFragment() {
        // Required empty public constructor
    }

    private String TAG = getClass().getName();
    private DiscoveryAdapter discoveryAdapter;
    private XRecyclerView xRecyclerView;
    private View rootView;
    private int offset = 0;
    private transient List<RecommendMovieBean.DataBean.ArrayBean> recommendMovieList = new ArrayList<>();

    // handler处理
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0x01) {

                String result = (String) msg.obj;
                RecommendMovieBean recommendMovieBean = new Gson().fromJson(result, RecommendMovieBean.class);

                if (offset == 0) {
                    recommendMovieList = recommendMovieBean.getData().getArray();
                    discoveryAdapter.setRecommendMovieList(recommendMovieList);
                    discoveryAdapter.notifyDataSetChanged();
                    xRecyclerView.refreshComplete();
                } else {
                    try {
                        recommendMovieList.addAll(recommendMovieBean.getData().getArray());
                        discoveryAdapter.setRecommendMovieList(recommendMovieList);
                    } catch (Exception e) {
                        Log.e("接收", e.getMessage());
                    }

                    discoveryAdapter.notifyDataSetChanged();
                    xRecyclerView.loadMoreComplete();


                }


                Log.e("接收", "ok");

            } else if (msg.what == 0x02) {
                ToastShow.shortToast(MyApplication.getContext(), "数据加载失败！");
                xRecyclerView.refreshComplete();
                xRecyclerView.loadMoreComplete();
            }
        }
    };


    /**
     * 初始化要使用的控件
     */
    private void initView() {
        TextView title = rootView.findViewById(R.id.actionbar_title_center);
        title.setText("发现");
        title.setVisibility(View.VISIBLE);
        xRecyclerView = rootView.findViewById(R.id.fragment_discovery_recyclerView);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
        xRecyclerView.setLayoutManager(layoutManager);
        xRecyclerView.setPullRefreshEnabled(true);
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                recommendMovieList.clear();
                offset = 0;
                getData(0);
            }

            @Override
            public void onLoadMore() {
                offset = offset + 10;
                getData(offset);
            }
        });

        discoveryAdapter = new DiscoveryAdapter(recommendMovieList, getActivity());
        //设置view的点击事件，跳转到详情页面
        discoveryAdapter.setOnItemClickListener(new DiscoveryAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                //测试没问题 注释
                //ToastShow.shortToast(getActivity(),"item"+position);
                Intent intent = new Intent(getActivity(), ArticleDetailsActivity.class);
                //设置要跳转的文章链接
                intent.putExtra("articleUrl",recommendMovieList.get(position).getCinecism().getBody_url());
                startActivity(intent);
            }
        });
        xRecyclerView.setAdapter(discoveryAdapter);
        //xRecyclerView.refresh();//没写完
    }

    /**
     * 网络请求 参数下一次数据的的位置 请求结果post到handler
     *
     * @param offset
     */
    private void getData(final int offset) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = "https://api-shoulei-ssl.xunlei.com/cinecism/api/v4/cinecism/list_cinecism_dynamic?cursor=" + offset + "&size=10";
                OkHttpClient okHttpClient = new OkHttpClient();
                final Request request = new Request.Builder()
                        .url(url)
                        .get()//默认就是GET请求，可以不写
                        .build();
                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e(TAG, "onFailure: ");
                        Log.e(TAG, e.getMessage());
                        Message message = handler.obtainMessage();
                        message.what = 0x02;
                        handler.sendMessage(message);

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String responseString = response.body().string();
                        // Log.e(TAG, "onResponse: " + responseString);
                        Message message = handler.obtainMessage();
                        message.what = 0x01;
                        message.obj = responseString;
                        handler.sendMessage(message);
                    }
                });
            }
        }).start();
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DiscoveryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DiscoveryFragment newInstance(String param1, String param2) {
        DiscoveryFragment fragment = new DiscoveryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_discovery, container, false);
        initView();
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
