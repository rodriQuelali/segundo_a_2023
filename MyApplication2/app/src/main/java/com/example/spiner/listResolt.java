package com.example.spiner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class listResolt extends AppCompatActivity {

    private ArrayList<String> listEmployee;
    private ArrayList<String> listSalary;

    private String lisEmArr []={"Alex Mamani", "Alan Brito", "Rocio Alanoca","Alex Mamani", "Alan Brito", "Rocio Alanoca"};
    private String lisSueArr []={"800", "4500", "3500","2500", "3000", "1500"};
    private ArrayAdapter<String> arrAdapEm;

    EditText txtEmployee, searchEmployee, txtSalary;
    ListView listMostEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_resolt);
        txtEmployee = (EditText) findViewById(R.id.txtAddResolt);
        searchEmployee = (EditText) findViewById(R.id.txtAddResoltSearch);
        txtSalary = (EditText) findViewById(R.id.txtSalary);

        listEmployee = new ArrayList<>();
        listSalary = new ArrayList<>();
        listMostEmployee =(ListView) findViewById(R.id.listAddResolt);
        for (int i=0; i<lisEmArr.length; i++) {
            //System.out.println("---------"+lisEmArr[i]);
            listEmployee.add(lisEmArr[i]);
            listSalary.add(lisSueArr[i]);
        }
        arrAdapEm = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listEmployee);
        listMostEmployee.setAdapter(arrAdapEm);
        listMostEmployee.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(listResolt.this, "empleado: " +listMostEmployee.getItemAtPosition(i) + "\n sueldo: " +listSalary.get(i), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void searchEmployee(View v){

    }

    public void addEmployee(View v){
        if(listEmployee.size() == 20){
            Toast.makeText(this, "Ya no se recive mas Empleados", Toast.LENGTH_SHORT).show();
        }else {
            listEmployee.add(txtEmployee.getText().toString());
            listSalary.add(txtSalary.getText().toString());
            listMostEmployee.setAdapter(arrAdapEm);
        }
    }
}