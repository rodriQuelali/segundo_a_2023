package com.example.myapplication_radio_check;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Num1,Num2;
    RadioButton br1, br2;
    CheckBox ch1,ch2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Editext
        Num1 = (EditText) findViewById(R.id.txt1);
        Num2 = (EditText) findViewById(R.id.txt2);
        //radio
        br1 = (RadioButton) findViewById(R.id.rb1);
        br2 = (RadioButton) findViewById(R.id.rb2);
        //Check
        ch1 = (CheckBox) findViewById(R.id.check1);
        ch2 = (CheckBox) findViewById(R.id.check2);


    }
    //funciones para los botones.
    public void ejeRadio(View v){
        int num = Integer.parseInt(Num1.getText().toString());
        int num2 = Integer.parseInt(Num2.getText().toString());
        int s =0;
        if(br1.isChecked() == true){
            s = num+num2;
            System.out.println("--------------"+s);
            Toast.makeText(this, "la suma es" + s, Toast.LENGTH_SHORT).show();
        } else if (br2.isChecked() == true) {
            s = num-num2;
            Toast.makeText(this, "la resta es" + s, Toast.LENGTH_SHORT).show();
        }
    }

    //funcion para check
    public void ejeCheck(View v){
        int num = Integer.parseInt(Num1.getText().toString());
        int num2 = Integer.parseInt(Num2.getText().toString());
        int s =0;
        if(ch1.isChecked() == true){
            s = num*num2;
            System.out.println("--------------"+s);
            Toast.makeText(this, "Multiplicacion es:" + s, Toast.LENGTH_SHORT).show();
        }
        if (ch2.isChecked() == true) {
            String ax = num2 == 0 ? "No se Puede":String.valueOf(num / num2);
            Toast.makeText(this, "Division es:" + ax, Toast.LENGTH_SHORT).show();
        }
    }
}