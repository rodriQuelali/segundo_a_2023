package com.example.poo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.poo.clases.Calculadora;

public class MainActivity extends AppCompatActivity {

    Calculadora casio;

    EditText txt1,txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = (EditText) findViewById(R.id.txt1);
        txt2 = (EditText) findViewById(R.id.txt2);


    }

    public void ope(View v){
        casio = new Calculadora();
        //((Object)myInteger).getClass().getSimpleName()
        double va1 = Double.parseDouble(txt1.getText().toString());
        double va2 = Double.parseDouble(txt2.getText().toString());

        /*int va3 = Integer.parseInt(txt1.getText().toString());
        int va4 = Integer.parseInt(txt2.getText().toString());*/
        if((Double)va1 instanceof Double && (Double)va2 instanceof Double){
            System.out.println("La suma es : ---->>"+ casio.suma(Double.parseDouble(txt1.getText().toString()),Double.parseDouble(txt2.getText().toString())));
        }else {
            System.out.println("La suma es : ---->>"+ casio.suma(Integer.parseInt(txt1.getText().toString()),Integer.parseInt(txt2.getText().toString())));
        }


    }
}