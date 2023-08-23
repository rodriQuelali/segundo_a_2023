package com.example.spiner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class AddList extends AppCompatActivity {

    //lista en java -- lista enlazadas,
    private ArrayList<String> lisArrEm;
    private ArrayAdapter<String> adapList;
    ListView listEm;
    EditText txtAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_list);

        //Editext
        txtAdd = (EditText) findViewById(R.id.txtAdd);

        //lista
        listEm = (ListView) findViewById(R.id.listAdd);
        lisArrEm = new ArrayList<>();
        lisArrEm.add("Alan brito");
        adapList = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,lisArrEm);
        listEm.setAdapter(adapList);
    }
    //funcion de agregar a la lista
    public void addLista (View v){
        lisArrEm.add(txtAdd.getText().toString());
        listEm.setAdapter(adapList);
    }
}