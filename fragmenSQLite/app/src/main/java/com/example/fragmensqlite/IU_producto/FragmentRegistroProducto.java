package com.example.fragmensqlite.IU_producto;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fragmensqlite.DB.AdminSQLiteOpenHelper;
import com.example.fragmensqlite.DB.DBProducto;
import com.example.fragmensqlite.Model.Producto;
import com.example.fragmensqlite.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentRegistroProducto#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentRegistroProducto extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentRegistroProducto() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentRegistroProducto.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentRegistroProducto newInstance(String param1, String param2) {
        FragmentRegistroProducto fragment = new FragmentRegistroProducto();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    private EditText txtCod, txtDes, txtPre;
    private Button botonGuardar, botonEliminar, botonEditar, botonBuscar;
    private AdminSQLiteOpenHelper admin;
    private Producto registroAll;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registro_producto, container, false);
        //instanacia del AdminSQliteHelper
        admin = new AdminSQLiteOpenHelper(getContext(), "administracion", null, 1);
        cargarR(view);
        estadoButton();
        return view;
    }

    private void cargarR(View view){
        botonGuardar = view.findViewById(R.id.btnGuardar);
        botonEliminar = view.findViewById(R.id.btnEliminar);
        botonEditar = view.findViewById(R.id.btnEditar);
        botonBuscar = view.findViewById(R.id.btnBucar);
        txtCod = view.findViewById(R.id.txtCodigoProducto);
        txtDes = view.findViewById(R.id.txtDescriProducto);
        txtPre=view.findViewById(R.id.txtPrecioProducto);
    }

    private void estadoButton(){

        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //SQLiteDatabase bd = admin.getWritableDatabase();
                //intancia del objeto
                DBProducto regis = new DBProducto(getContext());

                registroAll = new Producto(Integer.parseInt(txtCod.getText().toString()),txtDes.getText().toString(),Double.parseDouble(txtPre.getText().toString()));

                int stack = regis.insertPro(registroAll);
                if(stack == 1){
                    Toast.makeText(getContext(), "Registro exitoso", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(), "NO se REGISTRO.....", Toast.LENGTH_SHORT).show();
                }

                txtCod.setText("");
                txtDes.setText("");
                txtPre.setText("");
                System.out.println("registro db..........---------------------------");
            }
        });


        //eliminar

        botonEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase bd = admin.getWritableDatabase();
                Producto eliminarAll = new Producto(Integer.parseInt(txtCod.getText().toString()));
                String cod = String.valueOf(eliminarAll.getCod());
                int cant  = bd.delete("articulo","codigo=" + cod, null);
                bd.close();

                if(cant == 1){
                    Toast.makeText(getContext(), "Se elimino el producto", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getContext(), "NOooooo...Se elimino el producto", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //editar datos
        botonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBProducto regis = new DBProducto(getContext());

                registroAll = new Producto(Integer.parseInt(txtCod.getText().toString()),txtDes.getText().toString(),Double.parseDouble(txtPre.getText().toString()));

                int stack = regis.updatePro(registroAll);
                if(stack == 1){
                    Toast.makeText(getContext(), "Registro exitoso", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(), "NO se REGISTRO.....", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //buscar
        botonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = admin.getWritableDatabase();
                String sqlConsul = "SELECT * FROM articulo WHERE codigo=";
                Producto eli = new Producto(Integer.parseInt(txtCod.getText().toString()));
                String cod = String.valueOf(eli.getCod());
                Cursor fila = db.rawQuery(sqlConsul + cod, null);
                if(fila.moveToFirst()){
                    //objeto para calcular IVA
                    Producto bus = new Producto(Integer.parseInt(fila.getString(0)),fila.getString(1),Double.parseDouble(fila.getString(2)));

                    Toast.makeText(getContext(), "IVA: " + String.valueOf(bus.calIVA()), Toast.LENGTH_SHORT).show();

                    Toast.makeText(getContext(), "Total: " + String.valueOf(bus.calTotal(bus)), Toast.LENGTH_SHORT).show();
                    txtCod.setText(String.valueOf(bus.getCod()));
                    txtDes.setText(bus.getDescripcion());
                    txtPre.setText(String.valueOf(bus.getPrecio()));
                }else{
                    Toast.makeText(getContext(), "Datos No encontrados", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}