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

public class listaPersona extends RecyclerView.Adapter<listaPersona.PersonaViewsHolder>{

    ArrayList<Persona> listAdpPer;
    private OnItemClickListener onclickPerson;

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

    public void setOnClickListener(OnItemClickListener onclickPerson){
        this.onclickPerson = onclickPerson;
    }
    public interface OnItemClickListener{
        void onItemClick(int pos, Persona persona);
    }

    public class PersonaViewsHolder extends RecyclerView.ViewHolder {

        TextView txtLisPer;
        public PersonaViewsHolder(@NonNull View itemView) {
            super(itemView);
            txtLisPer = itemView.findViewById(R.id.txtListPersona);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onclickPerson != null){
                        int post =getAdapterPosition();
                        if(post != RecyclerView.NO_POSITION){
                            Persona perSele = listAdpPer.get(post);
                            onclickPerson.onItemClick(post, perSele);
                        }
                    }
                }
            });
        }
    }
}
