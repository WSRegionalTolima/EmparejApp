package com.example.worldskills.emparejapp.Actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.worldskills.emparejapp.R;

public class MenuActivity extends AppCompatActivity {

    Button boton_jugar, boton_puntajes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setTitle(R.string.menu);

        boton_jugar = findViewById(R.id.btn_jugar);
        boton_puntajes = findViewById(R.id.btn_puntajes);

        boton_jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                startActivity(intent);
            }
        });

        boton_puntajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PuntajesActivity.class);
                startActivity(intent);
            }
        });
    }
}
