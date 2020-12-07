package com.example.ungdungdocbao;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
 * Use the {@link GiaiTriFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GiaiTriFragment extends Fragment {

   // private HomeViewModel homeViewModel;
    private RecyclerView recyclerView;
    private NewsListAdapter mAdapter;
    private final List<Post> mListNews = new ArrayList<>();
//private final LinkedList<News> mListNews = new LinkedList<>();

    public GiaiTriFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GiaiTriFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GiaiTriFragment newInstance(String param1, String param2) {
        GiaiTriFragment fragment = new GiaiTriFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_giai_tri, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        for(int i=0;i<10;i++)
//        {
//            News news = new News("Tieu de"+i,"Mo ta "+i);
//            mListNews.addLast(news);
//        }
        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerview);
//        mAdapter=new NewsListAdapter(getContext(), mListNews);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(mAdapter);
    }
}