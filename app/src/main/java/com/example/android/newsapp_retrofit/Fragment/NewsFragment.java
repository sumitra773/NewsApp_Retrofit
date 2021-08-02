package com.example.android.newsapp_retrofit.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.android.newsapp_retrofit.Adapter.ItemAdapter;
import com.example.android.newsapp_retrofit.ApiUtilities;
import com.example.android.newsapp_retrofit.Model.Articles;
import com.example.android.newsapp_retrofit.Model.News;
import com.example.android.newsapp_retrofit.R;
import java.io.IOException;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsFragment extends Fragment {
    String api = "aae324fdda6f40da9be4ff2584411420";

    ArrayList<Articles> mArticlesArrayList;
    private ItemAdapter adapter;
    String country = "in";
    private RecyclerView recyclerViewOfTechnology;

    private String category;

    ProgressBar mPB;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_container,null);

        category = getArguments().getString("category");
        recyclerViewOfTechnology = v.findViewById(R.id.rec_view);
        mArticlesArrayList = new ArrayList<>();
        recyclerViewOfTechnology.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ItemAdapter(getContext(), mArticlesArrayList);
        recyclerViewOfTechnology.setAdapter(adapter);
        mPB = v.findViewById(R.id.loading_progress_bar);

        findNews();
        return v;
    }

    private void findNews() {
        mPB.setVisibility(View.VISIBLE);
        ApiUtilities.getApiInterface().getCategoryNews(country,category,100,api).enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {

                if(response.isSuccessful()){
                    mArticlesArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                    mPB.setVisibility(View.GONE);
                }

            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                mPB.setVisibility(View.GONE);
                String message;
                if(t instanceof IOException) {
                    message = "No Internet Connection Available, Please connect with wifi or mobile data to proceed further.";
                } else {
                    message = t.getMessage();
                }
                Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show();

            }
        });
    }
}
