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
 * Use the {@link TheGioiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TheGioiFragment extends Fragment {
    private RecyclerView recyclerView;
    private NewsListAdapter mAdapter;
    private final LinkedList<News> mListNews = new LinkedList<>();
////    private final LinkedList<News> mListNews = new LinkedList<>();
//private final List<Post> mListNews = new ArrayList<>();
    View v;


    public TheGioiFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static TheGioiFragment newInstance(String param1, String param2) {
        TheGioiFragment fragment = new TheGioiFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        for(int i=0;i<10;i++)
//        {
//            News news = new News("Tieu de"+i,"Mo ta "+i);
//            mListNews.addLast(news);
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