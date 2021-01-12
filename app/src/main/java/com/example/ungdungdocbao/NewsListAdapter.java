package com.example.ungdungdocbao;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ungdungdocbao.Models.Post;
import com.squareup.picasso.Picasso;

import java.util.LinkedList;
import java.util.List;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsViewHolder> {
    private final List<Post> newsList;
    private LayoutInflater mInflater;
    //Context mcontext;




    public NewsListAdapter(Context context, List<Post> newsList) {
        mInflater=LayoutInflater.from(context);
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView=mInflater.inflate(R.layout.list_news,parent,false);
        return new NewsViewHolder(mItemView,this);

    }




    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        Post mCurrent = newsList.get(position);
        //--Lay hinh---//
       // String url = "http://192.168.43.216/DoAnAndroid/public/img_Android/"+mCurrent.getThumbnail();
        String url = "http://10.0.2.2/DoAnAndroid/public/img_Android/"+mCurrent.getThumbnail();
        Picasso.with(holder.mcontext).load(url).centerCrop().resize(411, 280).into(holder.img);
        //----//
        holder.mTitle.setText(mCurrent.getTitle());
        holder.mDesciption.setText(mCurrent.getDescription());


    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    //chi tiet bai viet
    public class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final ImageView img;
        private final TextView mTitle;
        private final TextView mDesciption;
        final NewsListAdapter mAdapter;
        private Context mcontext;


        public NewsViewHolder(@NonNull View itemView, NewsListAdapter mAdapter) {
            super(itemView);
            this.img=itemView.findViewById(R.id.img_main);
            this.mTitle=itemView.findViewById(R.id.txt_tieude);
            this.mDesciption=itemView.findViewById(R.id.txt_mota);
            this.mAdapter = mAdapter;
            this.mcontext = itemView.getContext();

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getLayoutPosition(); // gets item position
            Post post = newsList.get(position);
            // We can access the data within the views
           Intent intent = new Intent(mcontext,ChiTietBaiViet.class);
           intent.putExtra("POST_ID",post.getId());
           intent.putExtra("POST_TITLE",post.getTitle());
           intent.putExtra("POST_IMAGE",post.getThumbnail());
           intent.putExtra("POST_CONTENT",post.getContent());
           intent.putExtra("POST_PUBDATE",post.getPubDate());
           intent.putExtra("POST DECRIPTION",post.getDescription());

           mcontext.startActivity(intent);
        }
    }


}
