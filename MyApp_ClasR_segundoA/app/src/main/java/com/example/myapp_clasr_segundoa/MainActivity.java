package com.example.myapp_clasr_segundoa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    TextView tvRes;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = (EditText) findViewById(R.id.txt1);
        num2 = (EditText) findViewById(R.id.txt2);
        tvRes = (TextView) findViewById(R.id.txtResult);
        btn = (Button) findViewById(R.id.btnCalcular);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //encontrar el error o bug de esta suma:
                //2,2 return(22)
                tvRes.setText(String.valueOf(Integer.parseInt(num1.getText().toString()))+Integer.parseInt(num2.getText().toString()));
            }
        });
    }

    public void cal(View v){
        int a,b,s;
        a=Integer.parseInt(num1.getText().toString());
        b=Integer.parseInt(num2.getText().toString());
        s=a+b;
        tvRes.setText(String.valueOf(s));
    }
}