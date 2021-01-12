package com.example.ungdungdocbao;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ungdungdocbao.Models.Post;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TheThaoFragment extends Fragment {
    private RecyclerView recyclerView;
    private NewsListAdapter mAdapter;
//    private final LinkedList<Post> mListNews = new LinkedList<>();
private final List<Post> mListNews = new ArrayList<>();
    View v;
    public TheThaoFragment() {
    }


    public static TheThaoFragment newInstance(String param1, String param2) {
        TheThaoFragment fragment = new TheThaoFragment();

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
       viewdata();
        return v;


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
                .url("http://10.0.2.2:8000/api/thethao")
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