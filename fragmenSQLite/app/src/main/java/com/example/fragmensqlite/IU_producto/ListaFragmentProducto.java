package com.example.fragmensqlite.IU_producto;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmensqlite.DB.DBProducto;
import com.example.fragmensqlite.R;
import com.example.fragmensqlite.adapter.adapterProducto;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListaFragmentProducto#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaFragmentProducto extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListaFragmentProducto() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaFragmentProducto.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaFragmentProducto newInstance(String param1, String param2) {
        ListaFragmentProducto fragment = new ListaFragmentProducto();
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

    RecyclerView proRecy;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista_producto, container, false);
        proRecy = view.findViewById(R.id.listaRecyclerview);
        proRecy.setLayoutManager(new LinearLayoutManager(getContext()));

        DBProducto dbProducto = new DBProducto(getContext());
        adapterProducto adapPro = new adapterProducto(dbProducto.listaProducto());
        proRecy.setAdapter(adapPro);


        return view;
    }
}