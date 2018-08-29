package com.example.worldskills.emparejapp;

public class Jugador {

    private String nombreJugador;
    private int puntajeJugador;

    public Jugador(String nombreJugador, int puntajeJugador) {
        this.nombreJugador = nombreJugador + ":  ";
        this.puntajeJugador = puntajeJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public int getPuntajeJugador() {
        return puntajeJugador;
    }

    public void setPuntajeJugador(int puntajeJugador) {
        this.puntajeJugador = puntajeJugador;
    }
}
