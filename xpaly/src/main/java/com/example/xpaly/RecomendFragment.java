package com.example.xpaly;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;

import com.example.xpaly.com.xpaly.activity.SearchMovieActivity;
import com.example.xpaly.com.xpaly.adapter.RVAdapter;
import com.example.xpaly.com.xpaly.fragment.HotAnimeFragment;
import com.example.xpaly.com.xpaly.fragment.HotMovieFragment;
import com.example.xpaly.com.xpaly.fragment.HotTVFragment;
import com.example.xpaly.com.xpaly.fragment.HotVarietyShowFragment;
import com.example.xpaly.com.xpaly.fragment.PianDanFragment;
import com.example.xpaly.com.xpaly.fragment.TestFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import mehdi.sakout.fancybuttons.FancyButton;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RecomendFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RecomendFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecomendFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View rootView;
    private OnFragmentInteractionListener mListener;

    public RecomendFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecomendFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecomendFragment newInstance(String param1, String param2) {
        RecomendFragment fragment = new RecomendFragment();
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
        rootView = inflater.inflate(R.layout.fragment_recomend, container, false);
        initView();
        return rootView;
    }

    public void initView() {
        Button button = rootView.findViewById(R.id.recommend_searchButton);
        //搜索按钮设置点击事件
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SearchMovieActivity.class));
            }
        });
        TabLayout tabLayout = rootView.findViewById(R.id.recommend_tabLayout);
        ViewPager viewPager = rootView.findViewById(R.id.recommend_fragment_viewPage);
        viewPager.setOffscreenPageLimit(4);
        tabLayout.setupWithViewPager(viewPager);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new PianDanFragment());
        fragments.add(new HotTVFragment());
        fragments.add(new HotMovieFragment());
        fragments.add(new HotVarietyShowFragment());
        fragments.add(new HotAnimeFragment());

        viewPager.setAdapter(new RVAdapter(getFragmentManager(), 1, fragments));
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
