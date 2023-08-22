package com.example.spiner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner ps;
    ListView lv;

    private String [] empleados = {"alan", "ximena", "Rider", "Efrain", "Ruth", "Vanesa"};
    private String [] Sueldos = {"1500", "2000", "3500", "3000", "2800", "4500"};
    //0 = inactivo, 1= activo
    private  String [] Estados ={"1","1", "0", "0", "1","1"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //spiner
        ps = (Spinner) findViewById(R.id.sp1);
        String [] paises = {"Bolivia","Peru","Venezuela", "Argentina"};
        ArrayAdapter<String> op = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, paises);
        ps.setAdapter(op);

        //listview
        lv = (ListView) findViewById(R.id.listaID);
        ArrayAdapter<String> listOP = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,empleados);
        lv.setAdapter(listOP);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //utilizar un if
                String es = Estados[i] == "1" ? "Activo": "Inactivo";
                System.out.println("empleado: ------------------->" +lv.getItemAtPosition(i) + ", sueldo: ---->" +Sueldos[i]+", Estado: ---->" +es);
                Toast.makeText(MainActivity.this, "posicion: " + lv.getItemAtPosition(i) , Toast.LENGTH_SHORT).show();

                //Visualizar en TextView los datos.
            }
        });


    }


}