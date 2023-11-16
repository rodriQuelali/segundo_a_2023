package com.example.rest_http.configHttp;

import com.example.rest_http.model.Carrera;
import com.example.rest_http.model.jsonplace;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface interfaceJsonplace {
    @GET("posts")
    Call<List<jsonplace>> getJsonplaces();


    @GET("Grado/listarGrado")
    Call<List<Carrera>> getCarrera();
    /*@POST("posts")
    Call<List<jsonplace>> getJsonplacesSAve();*/
}
