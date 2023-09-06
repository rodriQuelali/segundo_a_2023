package com.example.poo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.poo.adapter.listaPersona;
import com.example.poo.clases.Persona;

import java.util.ArrayList;

public class Persona_Recy extends AppCompatActivity {

    ArrayList<Persona> viewsLista;

    RecyclerView listaViewsRecy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persona_recy);

        listaViewsRecy = (RecyclerView) findViewById(R.id.reclyPersona);
        listaViewsRecy.setLayoutManager(new LinearLayoutManager(this));

        viewsLista = new ArrayList<>();
        viewsLista.add(new Persona("Juan"));
        viewsLista.add(new Persona("Juan"));
        viewsLista.add(new Persona("Juan"));
        viewsLista.add(new Persona("Juan"));
        viewsLista.add(new Persona("Juan"));
        viewsLista.add(new Persona("Juan"));




        listaPersona adapterViews = new listaPersona(viewsLista);

        listaViewsRecy.setAdapter(adapterViews);


    }
}