package com.example.rest_http;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.rest_http.adapter.PostAdapter;
import com.example.rest_http.configHttp.apiJsonplace;
import com.example.rest_http.configHttp.interfaceJsonplace;
import com.example.rest_http.model.Carrera;
import com.example.rest_http.model.jsonplace;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    List<jsonplace> listJsoplace;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        http();
        listView = findViewById(R.id.listView);


    }

    public void http(){
        /*Call<List<Carrera>> calldos = apiJsonplace.getCarr().create(interfaceJsonplace.class).getCarrera();

        calldos.enqueue(new Callback<List<Carrera>>() {
            @Override
            public void onResponse(Call<List<Carrera>> call, Response<List<Carrera>> response) {

            }

            @Override
            public void onFailure(Call<List<Carrera>> call, Throwable t) {

            }
        });*/





        Call<List<jsonplace>> call = apiJsonplace.getJsonplace().create(interfaceJsonplace.class).getJsonplaces();
        System.out.println("-----------------------------------------jjjjjj");
        call.enqueue(new Callback<List<jsonplace>>() {
            @Override
            public void onResponse(Call<List<jsonplace>> call, Response<List<jsonplace>> response) {
                System.out.println("-----------------------------------------bbbbbbbbbbbb");
                if(response.isSuccessful()){
                    listJsoplace = new ArrayList<>();
                    listJsoplace.addAll(response.body());
                    PostAdapter adapter = new PostAdapter(MainActivity.this, listJsoplace);

                    listView.setAdapter(adapter);

                    System.out.println("--------jjjjj----"+response.body());
                    Toast.makeText(MainActivity.this, listJsoplace.toString(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<jsonplace>> call, Throwable t) {
                System.out.println("errrrrrrrrrrrrrrrrrrrrrr");
                Toast.makeText(MainActivity.this, "Error en la peticion", Toast.LENGTH_SHORT).show();
            }
        });
    }
}