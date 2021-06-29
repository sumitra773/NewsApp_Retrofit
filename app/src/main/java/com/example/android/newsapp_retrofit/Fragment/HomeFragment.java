package com.example.android.newsapp_retrofit.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.newsapp_retrofit.Adapter.ItemAdapter;
import com.example.android.newsapp_retrofit.ApiInterface;
import com.example.android.newsapp_retrofit.ApiUtilities;
import com.example.android.newsapp_retrofit.Model.ModelClass;
import com.example.android.newsapp_retrofit.Model.News;
import com.example.android.newsapp_retrofit.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    String api = "aae324fdda6f40da9be4ff2584411420";

    ArrayList<ModelClass> modelClassArrayList;
    private ItemAdapter adapter;
    String country = "in";
    private RecyclerView recyclerViewOfHome;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.homefragment,null);

        recyclerViewOfHome = v.findViewById(R.id.rec_view_home);
        modelClassArrayList = new ArrayList<>();
        recyclerViewOfHome.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ItemAdapter(getContext(),modelClassArrayList);
        recyclerViewOfHome.setAdapter(adapter);
        
        findNews();
        
        return v;
    }

    private void findNews() {

        ApiUtilities.getApiInterface().getNews(country,100,api).enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {

                if(response.isSuccessful()){
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

            }
        });
    }
}
