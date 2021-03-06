package com.example.android.newsapp_retrofit.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android.newsapp_retrofit.Model.Articles;
import com.example.android.newsapp_retrofit.R;
import com.example.android.newsapp_retrofit.WebViewActivity;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    Context context;
    ArrayList<Articles> mArticlesArrayList;

    public ItemAdapter(Context context, ArrayList<Articles> articlesArrayList) {
        this.context = context;
        this.mArticlesArrayList = articlesArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.list_item, null,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebViewActivity.class);
                intent.putExtra("url", mArticlesArrayList.get(position).getUrl());
                context.startActivity(intent);

            }
        });
        holder.mTime.setText("Published At :-"+ mArticlesArrayList.get(position).getPublishedAt());
        holder.mHeading.setText(mArticlesArrayList.get(position).getTitle());
        holder.mAuthor.setText(mArticlesArrayList.get(position).getAuthor());
        holder.mContent.setText(mArticlesArrayList.get(position).getDescription());
        Glide.with(context).load(mArticlesArrayList.get(position).getUrlToImage()).into(holder.mImageView);

    }

    @Override
    public int getItemCount() {
        return mArticlesArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mHeading,mContent,mAuthor,mTime;
        CardView mCardView;
        ImageView mImageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mHeading = itemView.findViewById(R.id.mainHeading);
            mContent = itemView.findViewById(R.id.content);
            mAuthor = itemView.findViewById(R.id.author);
            mTime = itemView.findViewById(R.id.time);
            mCardView = itemView.findViewById(R.id.card_view);
            mImageView = itemView.findViewById(R.id.image_view);

        }
    }
}
