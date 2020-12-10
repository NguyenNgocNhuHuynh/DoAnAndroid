package com.example.ungdungdocbao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ungdungdocbao.Models.Post;
import com.squareup.picasso.Picasso;

import java.util.LinkedList;
import java.util.List;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsViewHolder> {
    private final List<Post> newsList;
    private LayoutInflater mInflater;
    Context mcontext;
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
        String url = "http://192.168.1.7/DoAnAndroid/public/img_Android/"+mCurrent.getThumbnail();
        Picasso.with(holder.mcontext).load(url).centerCrop().resize(411, 280).into(holder.img);
        //----//
        holder.mTitle.setText(mCurrent.getTitle());
        holder.mDesciption.setText(mCurrent.getDescription());

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{
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
        }
    }
}
