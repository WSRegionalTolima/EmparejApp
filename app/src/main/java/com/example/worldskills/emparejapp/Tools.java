package com.example.worldskills.emparejapp;

import java.util.Random;

public class Tools {

    private static Random r = new Random();
    private int JUGADOR_1 = 0;
    private int JUGADOR_2 = 1;

    public static int setTurnoJugar(){
       return r.nextInt(2);
    }
}
