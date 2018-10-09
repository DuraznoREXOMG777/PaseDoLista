package com.example.antoniolpezhiguer.pasedolista;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorGrupo extends RecyclerView.Adapter<AdaptadorGrupo.GrupoViewHolder>{
    private ArrayList<Grupo> Grupo;
    private RecyclerViewOnItemClickListener listener;

    public AdaptadorGrupo(ArrayList<com.example.antoniolpezhiguer.pasedolista.Grupo> grupo, RecyclerViewOnItemClickListener listener) {
        Grupo = grupo;
        this.listener = listener;
    }

    @NonNull
    @Override
    public GrupoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_mostrar_grupo, viewGroup, false);
        return new GrupoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GrupoViewHolder grupoViewHolder, int i) {
        Grupo grupo = Grupo.get(i);
        grupoViewHolder.nombre.setText(grupo.getNombreGrupo());
        grupoViewHolder.foto.setImageResource(grupo.getImagenGrupo());
    }

    @Override
    public int getItemCount() {
        return Grupo.size();
    }

    public class GrupoViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView nombre;

        public GrupoViewHolder(@NonNull View itemView) {
            super(itemView);

            foto = itemView.findViewById(R.id.iv_fotoGrupo);
            nombre = itemView.findViewById(R.id.tv_nombreGrupo);
            foto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(v, getAdapterPosition(), 1);
                }
            });
            nombre.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(v, getAdapterPosition(), 1);
                }
            });
        }
    }
}
