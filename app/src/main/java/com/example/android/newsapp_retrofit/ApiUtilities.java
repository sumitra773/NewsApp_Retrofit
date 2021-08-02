package com.example.android.newsapp_retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtilities {

    private static final String BASE_URL = "https://newsapi.org/v2/";

    private static Retrofit retrofit = null;

    public static ApiInterface getApiInterface()
    {
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiInterface.class);
    }
}
