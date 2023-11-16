package com.example.rest_http.configHttp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class apiJsonplace {
    private static String URL = "https://jsonplaceholder.typicode.com/";
    private static String URLdos = "https://apirestitpm.itpm.edu.bo/apis/index.php/";
    private static Retrofit retrofit;

    public static Retrofit getJsonplace(){
        retrofit= new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    public static Retrofit getCarr(){
        retrofit= new Retrofit.Builder()
                .baseUrl(URLdos)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
