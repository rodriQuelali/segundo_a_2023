package com.example.myapp_clasr_segundoa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class palindromo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palindromo);

        Button btnpa = (Button) findViewById(R.id.btnCalPali);
        btnpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txtC = (EditText) findViewById(R.id.pal1);
                String txt = String.valueOf(txtC.getText().toString().replace(" ",""));
                TextView tvr = findViewById(R.id.palRes);
                //System.out.println(new StringBuilder(txtC.getText().toString()).reverse().toString() + "-------------");
                tvr.setText( txt.equals(new StringBuilder(txtC.getText().toString().replace(" ", "")).reverse().toString()) ?"SI-palindromo":"NO-palindromo" );
            }
        });
    }
}