package com.example.ungdungdocbao;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ungdungdocbao.Models.Post;
import com.example.ungdungdocbao.ui.home.HomeViewModel;
import com.squareup.moshi.Moshi;

import java.io.IOException;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import okhttp3.OkHttpClient;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;

import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThoiSuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThoiSuFragment extends Fragment {
    //private HomeViewModel homeViewModel;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private  List<Post> mListNews = new ArrayList<>();
//    private final LinkedList<News> mListNews = new LinkedList<>();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
//        mAdapter=new NewsListAdapter(getContext(), mListNews);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        viewdata();
    }

    public ThoiSuFragment() {

    }


    public static ThoiSuFragment newInstance(String param1, String param2) {
        ThoiSuFragment fragment = new ThoiSuFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        for (int i = 0; i < 10; i++) {
//            News news = new News("Tieu de" + i, "Mo ta " + i);
//            mListNews.addLast(news);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thoi_su, container, false);
    }


    public void viewdata() {
        // Khởi tạo OkHttpClient để lấy dữ liệu.
        OkHttpClient client = new OkHttpClient();

        // Khởi tạo Moshi adapter để biến đổi json sang model java (ở đây là User)
        Moshi moshi = new Moshi.Builder().build();
        Type postType = Types.newParameterizedType(List.class, Post.class);

        final JsonAdapter<List<Post>> jsonAdapter=moshi.adapter(postType);


        // Tạo request lên server.
        Request request = new Request.Builder()
                .url("http://192.168.0.102/DoAnAndroid/public/api/thoisu")
                .build();

        // Thực thi request.
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("Error", "Network Error");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                // Lấy thông tin JSON trả về. Bạn có thể log lại biến json này để xem nó như thế nào.
                String json = response.body().string();
                final List<Post> list = jsonAdapter.fromJson(json);

                // Cho hiển thị lên RecyclerView.
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setAdapter(new NewsListAdapter(getActivity(), list));
                    }
                });

            }
        });
    }
}

