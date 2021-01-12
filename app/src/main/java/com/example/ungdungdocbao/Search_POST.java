package com.example.ungdungdocbao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.ungdungdocbao.Models.Post;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Search_POST extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search__p_o_s_t);

        Intent intent = getIntent();

        String title = intent.getStringExtra("Edit_KEY");
        Log.d("huynhcho","ok" + title);
       viewdata(title);
    }
    public void viewdata(String timkiem) {
        // Khởi tạo OkHttpClient để lấy dữ liệu.
        final RecyclerView rvTKs=(RecyclerView)findViewById(R.id.recy_search);

        rvTKs.setLayoutManager(new LinearLayoutManager(this));
        OkHttpClient client = new OkHttpClient();

        // Khởi tạo Moshi adapter để biến đổi json sang model java (ở đây là User)
        Moshi moshi = new Moshi.Builder().build();
        Type postType = Types.newParameterizedType(List.class, Post.class);

        final JsonAdapter<List<Post>> jsonAdapter=moshi.adapter(postType);


        // Tạo request lên server.
        Request request = new Request.Builder()
                .url("http://10.0.2.2:8000/api/post?title="+timkiem)
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
               runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        rvTKs.setAdapter(new NewsListAdapter(Search_POST.this, list));
                    }
                });

            }
        });
    }
}