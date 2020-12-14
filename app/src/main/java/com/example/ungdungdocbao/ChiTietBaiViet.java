package com.example.ungdungdocbao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class ChiTietBaiViet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_bai_viet);
        Intent intent = getIntent();

        String title = intent.getStringExtra("POST_TITLE");
        String content = intent.getStringExtra("POST_CONTENT");
        String img = intent.getStringExtra("POST_IMAGE");
        String id = intent.getStringExtra("POST_ID");
        String pubDate = intent.getStringExtra("POST_PUBDATE");
        String decription = intent.getStringExtra("POST DECRIPTION");

        TextView txttitle = findViewById(R.id.title);
        TextView mcontent = findViewById(R.id.content);
        ImageView imageView = findViewById(R.id.img_ctbv);
        TextView mpubDate = findViewById(R.id.pubDate);
        TextView mDecription = findViewById(R.id.decription);

        String url = "http://192.168.137.216/DoAnAndroid/public/img_Android/"+img;
        Picasso.with(this).load(url).centerCrop().resize(411, 280).into(imageView);
        txttitle.setText(title);
        mcontent.setText(content);
        mpubDate.setText(pubDate);
        mDecription.setText(decription);


    }
}