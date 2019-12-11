package com.example.xpaly.com.xpaly.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xpaly.R;
import com.example.xpaly.com.xpaly.adapter.FilmClassificationAdapter;
import com.example.xpaly.com.xpaly.adapter.HotMovieAdapter;
import com.example.xpaly.com.xpaly.application.MyApplication;
import com.example.xpaly.com.xpaly.pojo.HotMovieBean;
import com.example.xpaly.com.xpaly.utils.ToastShow;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.io.FileInputStream;
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
 * {@link CatalogFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CatalogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CatalogFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CatalogFragment() {
        // Required empty public constructor
    }

    private View rootView;
    private RecyclerView movieForm;
    private RecyclerView movieType;
    private RecyclerView movieArea;
    private RecyclerView movieTime;


    private String TAG = getClass().getName();
    private HotMovieAdapter hotMovieAdapter;
    private XRecyclerView loadMore;
    private int offset = 0;
    private List<HotMovieBean.DataBean> hotMovieBeanList = new ArrayList<>();

    // handler处理
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0x01) {
                String result = (String) msg.obj;
                HotMovieBean hotMovieBean = new Gson().fromJson(result, HotMovieBean.class);
                if (offset == 0) {
                    hotMovieBeanList = hotMovieBean.getData();
                    hotMovieAdapter.setHotMovieBeanList(hotMovieBeanList);
                    hotMovieAdapter.notifyDataSetChanged();
                    loadMore.refreshComplete();
                } else {
                    try {
                        hotMovieBeanList.addAll(hotMovieBean.getData());
                        hotMovieAdapter.setHotMovieBeanList(hotMovieBeanList);
                    } catch (Exception e) {
                        Log.e("接收", e.getMessage());
                    }

                    hotMovieAdapter.notifyDataSetChanged();
                    loadMore.loadMoreComplete();
                }


                Log.e("接收", "ok");

            } else if (msg.what == 0x02) {
                ToastShow.shortToast(MyApplication.getContext(), "数据加载失败！");
                loadMore.refreshComplete();
            }
        }
    };

    /**
     * 网络请求 参数下一次数据的的位置 请求结果post到handler
     *
     * @param offset
     */
    private void getData(final int offset) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = "https://movie.douban.com/j/new_search_subjects?sort=U&range=0,10&tags=&start=" + offset;
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
                        Message message = handler.obtainMessage();
                        message.what = 0x02;
                        handler.sendMessage(message);

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String responseString = response.body().string();
                        Log.e(TAG, "onResponse: " + responseString);
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
     * @return A new instance of fragment CatalogFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CatalogFragment newInstance(String param1, String param2) {
        CatalogFragment fragment = new CatalogFragment();
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

        this.rootView = inflater.inflate(R.layout.fragment_catalog, container, false);
        initView();//初始化控件
        return rootView;
    }

    private void initView() {
        //设置actionbar的中间标题
        TextView title = rootView.findViewById(R.id.actionbar_title_center);
        title.setText("分类");
        title.setVisibility(View.VISIBLE);
        //初始化布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext());
        linearLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(getContext());
        linearLayoutManager3.setOrientation(LinearLayoutManager.HORIZONTAL);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
        //初始化
        movieForm = rootView.findViewById(R.id.CatalogFragment_RecyclerView_movieForm);
        movieType = rootView.findViewById(R.id.CatalogFragment_RecyclerView_movieType);
        movieArea = rootView.findViewById(R.id.CatalogFragment_RecyclerView_movieArea);
        movieTime = rootView.findViewById(R.id.CatalogFragment_RecyclerView_movieTime);
        loadMore = rootView.findViewById(R.id.CatalogFragment_RecyclerView_loadMore);
        //必须设置最大缓存数不然会有选中状态错乱的bug
        movieType.setItemViewCacheSize(30);
        movieArea.setItemViewCacheSize(30);
        movieTime.setItemViewCacheSize(30);
        //设置布局管理器不能复用日了狗了
        movieForm.setLayoutManager(linearLayoutManager);
        movieType.setLayoutManager(linearLayoutManager1);
        movieArea.setLayoutManager(linearLayoutManager2);
        movieTime.setLayoutManager(linearLayoutManager3);
        loadMore.setLayoutManager(gridLayoutManager);
        loadMore.setPullRefreshEnabled(true);//设置能够刷新和加载更多
        //设置动作监听
        loadMore.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                hotMovieBeanList.clear();
                offset = 0;
                getData(0);
            }

            @Override
            public void onLoadMore() {
                offset = offset + 10;
                getData(offset);
            }
        });
        //设置适配器，dataType为数据类型
        movieForm.setAdapter(new FilmClassificationAdapter(0));
        movieType.setAdapter(new FilmClassificationAdapter(1));
        movieArea.setAdapter(new FilmClassificationAdapter(2));
        movieTime.setAdapter(new FilmClassificationAdapter(3));
        hotMovieAdapter = new HotMovieAdapter(hotMovieBeanList, getActivity());
        loadMore.setAdapter(hotMovieAdapter);
        loadMore.refresh();
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
