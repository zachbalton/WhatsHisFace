package com.skylarkingstudios.whatshisface.data.remote;


import com.squareup.okhttp.OkHttpClient;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class OmdbServiceGenerator {

    public static final String API_BASE_URL = "http://www.omdbapi.com";

    private static OkHttpClient httpClient = new OkHttpClient();
    private static Retrofit builder = new Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder;
        return retrofit.create(serviceClass);
    }
}
