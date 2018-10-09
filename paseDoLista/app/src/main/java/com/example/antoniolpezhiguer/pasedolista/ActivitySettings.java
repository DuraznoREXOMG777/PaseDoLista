package com.example.antoniolpezhiguer.pasedolista;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActivitySettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void guardar(View view){
        EditText etNombre = findViewById(R.id.et_correin);
        String nombre = etNombre.getText().toString();
        SharedPreferences preferences = getSharedPreferences("correos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("correo", nombre);
        editor.commit();
        Toast toast = Toast.makeText(this, "Correo guardado", Toast.LENGTH_LONG);
        toast.show();
    }
}
