package com.example.fragmensqlite.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmensqlite.Model.Producto;
import com.example.fragmensqlite.R;

import java.util.List;

public class adapterProducto extends RecyclerView.Adapter<adapterProducto.ViewHolderProducto> {

    private List<Producto> producListAdapter;

    public adapterProducto(List<Producto> producListAdapter) {
        this.producListAdapter = producListAdapter;
    }

    @NonNull
    @Override
    public adapterProducto.ViewHolderProducto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.disenolistaproducto, null, false);
        return new ViewHolderProducto(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterProducto.ViewHolderProducto holder, int position) {
        holder.tvCod.setText(String.valueOf(producListAdapter.get(position).getCod()));
        holder.tvDesc.setText(String.valueOf(producListAdapter.get(position).getDescripcion()));
        holder.tvPreci.setText(String.valueOf((int)producListAdapter.get(position).getPrecio()));
    }

    @Override
    public int getItemCount() {
        return producListAdapter.size();
    }

    public class ViewHolderProducto extends RecyclerView.ViewHolder {
        TextView tvCod, tvDesc, tvPreci;
        public ViewHolderProducto(@NonNull View itemView) {
            super(itemView);
            tvCod = itemView.findViewById(R.id.tvCodigo);
            tvDesc = itemView.findViewById(R.id.tvDescripcion);
            tvPreci = itemView.findViewById(R.id.tvPrecio);

        }
    }
}
