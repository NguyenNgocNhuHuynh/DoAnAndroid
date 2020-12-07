package com.example.ungdungdocbao;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ungdungdocbao.Models.Post;
import com.example.ungdungdocbao.ui.home.HomeViewModel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GocNhinFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GocNhinFragment extends Fragment {

    //private HomeViewModel homeViewModel;
    private RecyclerView recyclerView;
    private NewsListAdapter mAdapter;
    private final List<Post> mListNews = new ArrayList<>();
//    private final LinkedList<News> mListNews = new LinkedList<>();
    View v;

    public GocNhinFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GocNhinFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GocNhinFragment newInstance(String param1, String param2) {
        GocNhinFragment fragment = new GocNhinFragment();

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