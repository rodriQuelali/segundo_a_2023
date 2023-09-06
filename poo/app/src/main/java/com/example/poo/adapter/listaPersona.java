package com.example.poo.adapter;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.poo.R;
import com.example.poo.clases.Persona;

import java.util.ArrayList;

public class listaPersona extends RecyclerView.Adapter<listaPersona.PersonaViewsHolder> {

    ArrayList<Persona> listAdpPer;

    public listaPersona(ArrayList<Persona> listAdpPer) {
        this.listAdpPer = listAdpPer;
    }

    @NonNull
    @Override
    public listaPersona.PersonaViewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_persona,null,false);

        return new PersonaViewsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull listaPersona.PersonaViewsHolder holder, int position) {
        holder.txtLisPer.setText(listAdpPer.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return listAdpPer.size();
    }

    public class PersonaViewsHolder extends RecyclerView.ViewHolder {

        TextView txtLisPer;
        public PersonaViewsHolder(@NonNull View itemView) {
            super(itemView);
            txtLisPer = itemView.findViewById(R.id.txtListPersona);
        }
    }
}
