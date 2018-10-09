package com.example.antoniolpezhiguer.pasedolista;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ActivityLista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        int grupo = extras.getInt("grupo");

        ArrayList<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("Samuel Lara Molina", "15130200",
                1, R.mipmap.ic_launcher, true));
        alumnos.add(new Alumno("Antonio López Higuera", "15130253",
                1, R.mipmap.ic_launcher, true));
        alumnos.add(new Alumno("Aneth Shariany Ibarra Márquez", "15130109",
                2, R.mipmap.ic_launcher, true));
        alumnos.add(new Alumno("Andrea Daniella Gaxiola Coronado", "15130128",
                2, R.mipmap.ic_launcher, true));
        alumnos.add(new Alumno("Abdel Ahiran Quiñonez Jaime", "15130256",
                2, R.mipmap.ic_launcher, true));
        alumnos.add(new Alumno("Samuel Lara Molina", "15130200",
                1, R.mipmap.ic_launcher, true));

        final ArrayList<Alumno> alumno = new ArrayList<>();
        for (int i = 0; i < alumnos.size(); i++) {
            if(alumnos.get(i).getGrupo() == grupo)
                alumno.add(alumnos.get(i));
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("correos", Context.MODE_PRIVATE);
                String correo = preferences.getString("correo", "");
                String to[] = {correo};

                Date currentTime = Calendar.getInstance().getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String subject = "Pase de Lista "+ sdf.format(currentTime);
                String body = "";

                for (int i = 0; i < alumno.size(); i++) {
                    body += alumno.get(i).getNombre() + " ";
                    if(alumno.get(i).isAsistencia()){
                        body+= 1;
                    }else{
                        body+= 0;
                    }
                    body+= "\n";
                }

                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                Log.d("output", correo);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                emailIntent.putExtra(Intent.EXTRA_TEXT, body);

                startActivity(Intent.createChooser(emailIntent, "Enviar correo..."));
                finish();
            }
        });


        LinearLayoutManager llm = new LinearLayoutManager(ActivityLista.this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        RecyclerView listaAlumnos = findViewById(R.id.rv_mainLista);
        listaAlumnos.setLayoutManager(llm);

        RecyclerViewOnItemClickListener listener = new RecyclerViewOnItemClickListener() {
            @Override
            public void onClick(View v, int posicion, int elemento) {

            }
        };

        AdaptadorAlumno ada = new AdaptadorAlumno(alumno,listener);

        listaAlumnos.setAdapter(ada);
    }


}
