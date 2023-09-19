package com.example.fragmetsexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.fragmetsexample.ui_producto.FragmentRegistroProducto;
import com.example.fragmetsexample.ui_producto.InicioFragment;

public class MainActivity extends AppCompatActivity {

    Fragment fragInicio, fragRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragInicio = new InicioFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.fragmentProducto,fragInicio).commit();

    }

    public void fragRegisB (View v){
        fragRegistro = new FragmentRegistroProducto();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentProducto, fragRegistro).commit();
    }
}