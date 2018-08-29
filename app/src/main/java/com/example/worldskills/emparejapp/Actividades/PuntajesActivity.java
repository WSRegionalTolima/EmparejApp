package com.example.worldskills.emparejapp.Actividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.worldskills.emparejapp.Adaptador;
import com.example.worldskills.emparejapp.Jugador;
import com.example.worldskills.emparejapp.R;

import java.util.ArrayList;

public class PuntajesActivity extends AppCompatActivity {

    RecyclerView listaPuntajes;
    ArrayList<Jugador> puntajes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntajes);
        setTitle(R.string.m_btn_High);


        listaPuntajes = findViewById(R.id.rv_puntajes);
        listaPuntajes.setLayoutManager(new LinearLayoutManager(null));

        Adaptador adaptador = new Adaptador(puntajes);
        listaPuntajes.setAdapter(adaptador);


    }
}
