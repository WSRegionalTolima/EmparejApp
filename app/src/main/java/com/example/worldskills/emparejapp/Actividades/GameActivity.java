package com.example.worldskills.emparejapp.Actividades;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.worldskills.emparejapp.Actividades.MainActivity;
import com.example.worldskills.emparejapp.R;

import java.util.ArrayList;
import java.util.Collections;

public class GameActivity extends AppCompatActivity {

    int imagenes[];
    int normal;
    Button arregloBotones[] = new Button[8];
    MediaPlayer mediaPlayer;
    TextView tv_Jugador1, tv_Jugador2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        setearNombreJugadores();

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.win);
        mediaPlayer.start();
    }

    public void asignarImagenes(){
        imagenes[0] = R.drawable.cuddles;
        imagenes[1] = R.drawable.flaky;
        imagenes[2] = R.drawable.flippy;
        imagenes[3] = R.drawable.handy;

        normal = R.drawable.duda1;
    }


    public ArrayList revolverArreglo(){
        ArrayList numeros = new ArrayList();
        numeros.add(2 % arregloBotones.length / 2);
        Collections.shuffle(numeros);
        return numeros;
    }

    public void setearNombreJugadores(){
        tv_Jugador1 = findViewById(R.id.nom_Jug1);
        tv_Jugador1.setText(MainActivity.jugadores.get(0).getNombreJugador());

        tv_Jugador2 = findViewById(R.id.nom_Jug2);
        tv_Jugador2.setText(MainActivity.jugadores.get(1).getNombreJugador());
    }
}
