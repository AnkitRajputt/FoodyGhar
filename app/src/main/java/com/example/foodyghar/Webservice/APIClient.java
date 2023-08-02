package com.example.foodyghar.Webservice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static final String BASEURL1 = "https://foodyghaar.000webhostapp.com/";
    public static Retrofit getClient() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        return new Retrofit.Builder()
                .baseUrl(BASEURL1)
                .addConverterFactory(GsonConverterFactory.create(gson)).build();
    }
}
