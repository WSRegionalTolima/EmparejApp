package com.example.worldskills.emparejapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.worldskills.emparejapp.DataBase.DataBase;

public class MainActivity extends AppCompatActivity {

    DataBase conexion;


    EditText et_nombrejugador1, et_nombrejugador2;
    SQLiteDatabase db;
    Button btn_continuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conexion = new DataBase(getApplicationContext(), "Jugadores", null, 1);
        et_nombrejugador1 = findViewById(R.id.et_nomjug1);
        et_nombrejugador2 = findViewById(R.id.et_nomjug2);

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
     * Metodo que Ingresa Un Nuevo JUgador a la base de Datos
     * @param db base de datos a modificar
     */
    public void agregarJugador(SQLiteDatabase db, String jug1, String jug2){
        db = conexion.getWritableDatabase();

        db.execSQL("INSERT INTO Historial VALUES (jug1, null),(jug2, null) ");

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
            Toast.makeText(getApplicationContext(), par1 + " " + par2, Toast.LENGTH_LONG).show();
            Bundle bundle = new Bundle();
            bundle.putString("Nombre1", par1);
            bundle.putString("Nombre2", par2);
            Intent i = new Intent(getApplicationContext(), MenuActivity.class);
            i.putExtras(bundle);
        }
    }
}
