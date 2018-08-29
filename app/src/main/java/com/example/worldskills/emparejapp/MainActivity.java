package com.example.worldskills.emparejapp;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.worldskills.emparejapp.DataBase.DataBase;

public class MainActivity extends AppCompatActivity {

    DataBase conexion = new DataBase(getApplicationContext(), "Jugadores", null, 1);
    EditText et_nombrejugador1, et_nombrejugador2;
    Button btn_continuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nombrejugador1 = findViewById(R.id.et_nomjug1);
        et_nombrejugador2 = findViewById(R.id.et_nomjug2);

        btn_continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = et_nombrejugador1.getText().toString();
                String nombred = et_nombrejugador2.getText().toString();
            }
        });
    }

    /**
     * Metodo que Ingresa Un Nuevo JUgador a la base de Datos
     * @param db base de datos a modificar
     */
    public void agregarJugador(SQLiteDatabase db){
        db = conexion.getWritableDatabase();

        //db.execSQL("INSERT INTO Historial ");

    }
}
