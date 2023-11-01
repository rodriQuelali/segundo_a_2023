package com.example.sharenprefencenotificaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnAgra, btnRecu;
    private EditText txtGmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        estadoR();
        estadoClick();
    }

    private void estadoR(){
        btnAgra = (Button) findViewById(R.id.btnShare);
        btnRecu = (Button) findViewById(R.id.btnRecup);
        txtGmail = (EditText) findViewById(R.id.editTextText);
    }

    private void estadoClick(){

        //agregar gmail.
        btnAgra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("mail", txtGmail.getText().toString());
                //editor.putString("password", txtGmail.getText().toString());
                editor.commit();
                finish();
            }
        });

        //recuperar gmail
        btnRecu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
                String d = sharedPreferences.getString("mail", "");
                //String p = sharedPreferences.getString("password", "");
                if(d.length() == 0){
                    Toast.makeText(MainActivity.this, "No Registro", Toast.LENGTH_SHORT).show();
                }else{
                    txtGmail.setText(d);
                }
            }
        });
    }

}