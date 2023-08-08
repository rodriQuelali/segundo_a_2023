package com.example.myapplication_radio_check;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Editext
        EditText Num1 = (EditText) findViewById(R.id.txt1);
        EditText Num2 = (EditText) findViewById(R.id.txt2);
        //radio
        RadioButton br1 = (RadioButton) findViewById(R.id.rb1);
        RadioButton br2 = (RadioButton) findViewById(R.id.rb2);
        //Check
        CheckBox ch1 = (CheckBox) findViewById(R.id.check1);
        CheckBox ch2 = (CheckBox) findViewById(R.id.check2);


    }
    //funciones para los botones.
    public void ejeRadio(View v){
        
    }
}