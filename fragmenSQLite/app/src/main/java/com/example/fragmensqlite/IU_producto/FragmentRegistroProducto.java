package com.example.fragmensqlite.IU_producto;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fragmensqlite.DB.AdminSQLiteOpenHelper;
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
    EditText txtCod;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registro_producto, container, false);

        txtCod = view.findViewById(R.id.txtCodigoProducto);
        
        return view;
    }

    //funcion para guardar articulos
    public void guadar(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getContext(), "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = txtCod.getText().toString();
        String descri = "";
        String precio = "";
        ContentValues registro = new ContentValues();
        registro.put("codigo", cod);
        registro.put("descripcion", descri);
        registro.put("precio", precio);
        bd.insert("articulo", null, registro);
        bd.close();
        Toast.makeText(getContext(), "REGISTRO EXITOSO....", Toast.LENGTH_SHORT).show();
    }
}