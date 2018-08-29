package com.example.worldskills.emparejapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolderJugadores>{

    ArrayList<Jugador> listaPuntajes;

    public Adaptador(ArrayList<Jugador> listaPuntajes) {
        this.listaPuntajes = listaPuntajes;
    }

    @NonNull
    @Override
    public ViewHolderJugadores onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,null);
        return new ViewHolderJugadores(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderJugadores holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listaPuntajes.size();
    }

    public class ViewHolderJugadores extends RecyclerView.ViewHolder {
        public ViewHolderJugadores(View itemView) {
            super(itemView);
        }
    }
}
