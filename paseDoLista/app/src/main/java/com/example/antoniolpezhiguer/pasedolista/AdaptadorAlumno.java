package com.example.antoniolpezhiguer.pasedolista;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorAlumno extends RecyclerView.Adapter<AdaptadorAlumno.AlumnoViewHolder> {
    private ArrayList<Alumno> alumnos;
    private RecyclerViewOnItemClickListener listener;

    public AdaptadorAlumno(ArrayList<Alumno> alumnos, RecyclerViewOnItemClickListener listener) {
        this.alumnos = alumnos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AlumnoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_mostrar_alumno, viewGroup, false);
        return new AlumnoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AlumnoViewHolder alumnoViewHolder, int i) {
        Alumno alumno = alumnos.get(i);
        alumnoViewHolder.nombre.setText(alumno.getNombre());
        alumnoViewHolder.matricula.setText(alumno.getMatricula());
        alumnoViewHolder.foto.setImageResource(alumno.getImagenAlumno());
        alumnoViewHolder.checkie.setChecked(alumno.asistencia);

        alumnoViewHolder.setItemClickLListener(new ItemCllickListener() {
            @Override
            public void onClick(View v, int pos) {
                CheckBox myCheckBox = (CheckBox) v;
                Alumno alumno = alumnos.get(pos);
                if(!alumno.isAsistencia()){
                    alumno.setAsistencia(true);
                }else{
                    if(!myCheckBox.isSelected()){
                        alumno.setAsistencia(false);
                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return alumnos.size();
    }

    public class AlumnoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView foto;
        private TextView nombre;
        private TextView matricula;
        private CheckBox checkie;

        ItemCllickListener listenerCllick;

        public AlumnoViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre = itemView.findViewById(R.id.tv_nombreAlumno);
            matricula = itemView.findViewById(R.id.tv_matriculaAlumno);
            foto = itemView.findViewById(R.id.iv_imagenAlumno);
            checkie = itemView.findViewById(R.id.ckb_asis);
            checkie.setOnClickListener(this);
        }

        public void setItemClickLListener(ItemCllickListener ic){
            this.listenerCllick = ic;
        }

        @Override
        public void onClick(View v) {
            this.listenerCllick.onClick(v, getLayoutPosition());
        }
    }
}
