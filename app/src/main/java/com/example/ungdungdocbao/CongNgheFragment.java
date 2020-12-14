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
//        recyclerView.setAdapter(mAdapter);
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
                .url("http://192.168.137.216/DoAnAndroid/public/api/congnghe")
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