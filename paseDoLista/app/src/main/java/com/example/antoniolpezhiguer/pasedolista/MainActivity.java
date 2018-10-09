package com.example.antoniolpezhiguer.pasedolista;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Grupo> grupos;
    private ArrayList<String> nombreGrupos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        grupos = new ArrayList();
        grupos.add(new Grupo("Grupo 1", 1, R.mipmap.ic_launcher));
        grupos.add(new Grupo("Grupo 2", 2, R.mipmap.ic_launcher));

        nombreGrupos = new ArrayList<>();
        for (int i = 0; i < grupos.size(); i++) {
            nombreGrupos.add(grupos.get(i).getNombreGrupo());
        }

        LinearLayoutManager llm = new LinearLayoutManager(MainActivity.this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        RecyclerView listaGrupos = findViewById(R.id.rv_main);
        listaGrupos.setLayoutManager(llm);

        RecyclerViewOnItemClickListener listener = new RecyclerViewOnItemClickListener() {
            @Override
            public void onClick(View v, int posicion, int elemento) {
                String item = "Manzana";
                Toast.makeText(MainActivity.this,item, Toast.LENGTH_LONG);
                Intent intent = new Intent(MainActivity.this, ActivityLista.class);
                intent.putExtra("grupo", grupos.get(posicion).getNumeroGrupo());
                startActivity(intent);
            }
        };
        AdaptadorGrupo adp = new AdaptadorGrupo(grupos, listener);

        listaGrupos.setAdapter(adp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, ActivitySettings.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void abrirSettings(){
        Intent intent = new Intent(MainActivity.this, ActivityLista.class);
        startActivity(intent);
    }
}
