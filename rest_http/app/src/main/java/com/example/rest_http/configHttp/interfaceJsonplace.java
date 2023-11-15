package com.example.rest_http.configHttp;

import com.example.rest_http.model.jsonplace;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface interfaceJsonplace {
    @GET("posts")
    Call<List<jsonplace>> getJsonplaces();
}
