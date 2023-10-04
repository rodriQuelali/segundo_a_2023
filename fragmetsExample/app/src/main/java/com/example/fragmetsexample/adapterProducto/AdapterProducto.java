package com.example.fragmetsexample.adapterProducto;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmetsexample.clase_producto.Producto;

import java.util.ArrayList;

public class AdapterProducto extends RecyclerView.Adapter<AdapterProducto.ProductoHolder> {

    ArrayList<Producto> listAdpPro;

    public AdapterProducto(ArrayList<Producto> listAdpPro) {
        this.listAdpPro = listAdpPro;
    }

    @NonNull
    @Override
    public AdapterProducto.ProductoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProducto.ProductoHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ProductoHolder extends RecyclerView.ViewHolder {
        public ProductoHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
