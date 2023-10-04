package com.example.fragmensqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

import com.example.fragmensqlite.IU_producto.FragmentRegistroProducto;
import com.example.fragmensqlite.IU_producto.ListaFragmentProducto;


public class principal extends AppCompatActivity {

    Fragment fragmentP, fragmentLP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        fragmentP = new FragmentRegistroProducto();
getSupportFragmentManager().beginTransaction().add(R.id.fragmetProducto, fragmentP).commit();

    }

    public void registro(View v){
        fragmentP = new FragmentRegistroProducto();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmetProducto, fragmentP).commit();

    }

    public void listaProducto(View v){
        fragmentLP = new ListaFragmentProducto();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmetProducto, fragmentLP).commit();

    }
}