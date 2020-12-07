package com.example.ungdungdocbao;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ungdungdocbao.Models.Post;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CongNgheFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CongNgheFragment extends Fragment {
    private RecyclerView recyclerView;
    private NewsListAdapter mAdapter;
    private final List<Post> mListNews = new ArrayList<>();
//    private final LinkedList<Post> mListNews = new LinkedList<>();
    View v;

    public CongNgheFragment() {
        // Required empty public constructor
    }


    public static CongNgheFragment newInstance(String param1, String param2) {
        CongNgheFragment fragment = new CongNgheFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        for(int i=0;i<10;i++)
//        {
//            Post post = new News("Tieu de"+i,"Mo ta "+i);
//            mListNews.addLast(post);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_the_thao, container, false);
        recyclerView=(RecyclerView)v.findViewById(R.id.recyclerview);
//        mAdapter=new NewsListAdapter(getContext(), mListNews);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(mAdapter);
        return v;
    }
}