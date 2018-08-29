package com.example.worldskills.emparejapp.Actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.worldskills.emparejapp.Jugador;
import com.example.worldskills.emparejapp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static ArrayList<Jugador> jugadores;

    EditText et_nombrejugador1, et_nombrejugador2;
    Button btn_continuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nombrejugador1 = findViewById(R.id.et_nomjug1);
        et_nombrejugador2 = findViewById(R.id.et_nomjug2);
        jugadores = new ArrayList<>();

        btn_continuar = findViewById(R.id.btn_continuar);

        btn_continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = et_nombrejugador1.getText().toString();
                String nombred = et_nombrejugador2.getText().toString();
                verificarCampos(nombre, nombred);
                //agregarJugador(db,nombre, nombred);
            }
        });
    }


    /**
     * Metodo que verifica si los campos de Texto Estan Vacios, en el caso de que no esten vacios ingresa la informacion
     * @param par1
     * @param par2
     */
    public void verificarCampos(String par1, String par2){
        if (par1.equals("") || par2.equals("")){
            Toast.makeText(getApplicationContext(), "Ingrese Un Nombre", Toast.LENGTH_LONG).show();
        }else{
            jugadores.add(new Jugador(par1, 0));
            jugadores.add(new Jugador(par2, 0));
            Intent i = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(i);
        }
    }
}
