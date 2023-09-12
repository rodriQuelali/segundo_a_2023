package com.example.poo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.poo.adapter.listaPersona;
import com.example.poo.clases.Persona;

import java.util.ArrayList;

public class Persona_Recy extends AppCompatActivity {

    ArrayList<Persona> viewsLista;

    RecyclerView listaViewsRecy;
    EditText txtName;
    Button btnAg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persona_recy);

        txtName = (EditText) findViewById(R.id.txtName);
        btnAg = (Button) findViewById(R.id.btnAgregar);

        listaViewsRecy = (RecyclerView) findViewById(R.id.reclyPersona);
        listaViewsRecy.setLayoutManager(new LinearLayoutManager(this));

        viewsLista = new ArrayList<>();
        viewsLista.add(new Persona("Juan"));
        viewsLista.add(new Persona("Juan"));
        viewsLista.add(new Persona("Alex"));
        viewsLista.add(new Persona("Juan"));
        viewsLista.add(new Persona("Ruth"));
        viewsLista.add(new Persona("Juan"));




        listaPersona adapterViews = new listaPersona(viewsLista);
        adapterViews.setOnClickListener(new listaPersona.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, Persona persona) {
                Toast.makeText(Persona_Recy.this, "Nombre: " + persona.getName() + "Posiscion: " + pos, Toast.LENGTH_SHORT).show();


            }
        });
        listaViewsRecy.setAdapter(adapterViews);

        //llamar onclick buton
        btnAg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewsLista.add(new Persona(txtName.getText().toString()));
                listaViewsRecy.setAdapter(adapterViews);
            }
        });


    }

}