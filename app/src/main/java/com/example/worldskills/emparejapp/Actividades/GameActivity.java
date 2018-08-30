package com.example.worldskills.emparejapp.Actividades;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.worldskills.emparejapp.Actividades.MainActivity;
import com.example.worldskills.emparejapp.R;

import java.util.ArrayList;
import java.util.Collections;

public class GameActivity extends AppCompatActivity {

    int imagenes[];
    ImageButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, boton1;
    int defecto;

    ArrayList<Integer> numeros;

    static ImageButton primerBoton = null;
    int primero, segundo;
    boolean bloquear = false;
    ImageButton arregloBotones[] = new ImageButton[8];

    MediaPlayer mediaWin, mediaLose;
    TextView tv_Jugador1, tv_Jugador2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        setearNombreJugadores();
        asignarImagenes();
        iniciar();
    }

    private void iniciar() {
        revolverArreglo(imagenes.length*2);
        asignarBotones();

        for (int i = 0; i<arregloBotones.length; i++){
            arregloBotones[i].setScaleType(ImageView.ScaleType.FIT_XY);
            arregloBotones[i].setImageResource(R.drawable.duda1);
        }

        for (int i = 0; i < numeros.size(); i++){
            final int n = i;
            arregloBotones[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!bloquear) {
                        comprobarIguales(n, arregloBotones[n]);
                    }
                }
            });
        }
    }

    /**
     * Este metodo asigna las imagenes a un arreglo para despues ser asignadas a un boton
     */
    public void asignarImagenes(){
        imagenes = new int[]{
                R.drawable.cuddles,
                R.drawable.flaky,
                R.drawable.flippy,
                R.drawable.handy
        };
        defecto = R.drawable.duda1;
    }

    /**
     * Este metodo Revuelve el arreglo para asignar una imagen al azar al boton
     * @param largo
     * @return
     */
    public ArrayList revolverArreglo(int largo){
        numeros = new ArrayList();
        for (int i = 0; i < largo; i++){
            numeros.add(i % largo / 2);
        }
        Collections.shuffle(numeros);
        return numeros;
    }

    /**
     * Este metodo asigna al arreglo todos los botones, ademas de setear la imagen por defecto
     */
    public void asignarBotones(){
        btn1 = findViewById(R.id.btn_1);
        arregloBotones[0] = btn1;

        btn2 = findViewById(R.id.btn_2);
        arregloBotones[1] = btn2;

        btn3 = findViewById(R.id.btn_3);
        arregloBotones[2] = btn3;

        btn4 = findViewById(R.id.btn_4);
        arregloBotones[3] = btn4;

        btn5 = findViewById(R.id.btn_5);
        arregloBotones[4] = btn5;

        btn6 = findViewById(R.id.btn_6);
        arregloBotones[5] = btn6;

        btn7 = findViewById(R.id.btn_7);
        arregloBotones[6] = btn7;

        btn8 = findViewById(R.id.btn_8);
        arregloBotones[7] = btn8;
    }

    /**
     * Metodo que Comprueba si las 2 imagenes son iguales
     * @param i
     * @param btn
     */
    public void comprobarIguales(int i, final ImageButton btn){
        if (primerBoton == null){
            primerBoton = btn;
            boton1 = btn;
            primerBoton.setScaleType(ImageView.ScaleType.FIT_XY);
            primerBoton.setImageResource(imagenes[numeros.get(i)]);
            primero = numeros.get(i);

        }else{
            bloquear = true;
            primerBoton = null;
            btn.setScaleType(ImageView.ScaleType.FIT_XY);
            btn.setImageResource(imagenes[numeros.get(i)]);
            segundo = numeros.get(i);

            if (primero == segundo){
                reproducirWin();
                bloquear = false;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        boton1.setVisibility(View.INVISIBLE);
                        btn.setVisibility(View.INVISIBLE);
                    }
                },1000);

            }else {
                reproducirLose();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        boton1.setImageResource(R.drawable.duda1);
                        btn.setImageResource(R.drawable.duda1);
                    }
                },1000);
                bloquear = false;
            }
        }
    }

    public void reproducirWin(){
        mediaWin = MediaPlayer.create(getApplicationContext(), R.raw.win);
        mediaWin.start();
    }

    public void reproducirLose(){
        mediaLose = MediaPlayer.create(getApplicationContext(), R.raw.lose);
        mediaLose.start();
    }

    /**
     * Metodo que sirve para setear los valores de los text view con los nombres de los Jugadores Ingresados en el inicio
     */
    public void setearNombreJugadores(){
        tv_Jugador1 = findViewById(R.id.nom_Jug1);
        tv_Jugador1.setText(MainActivity.jugadores.get(0).getNombreJugador());

        tv_Jugador2 = findViewById(R.id.nom_Jug2);
        tv_Jugador2.setText(MainActivity.jugadores.get(1).getNombreJugador());
    }
}
