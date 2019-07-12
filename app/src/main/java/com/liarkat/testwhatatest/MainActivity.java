package com.liarkat.testwhatatest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText eduser;
    Button btnempezar, btnrules;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnempezar = findViewById(R.id.btnempezar);
        btnrules = findViewById(R.id.brnrules);

        btnempezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Empezar();
            }
        });

        btnrules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mostrar_dialogo();
            }
        });




    }
    public void Mostrar_dialogo(){
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle("Reglas a seguir");
        dialogo.setMessage("Este es el cuerpo \ndel dialogo");
        dialogo.setCancelable(true);
        dialogo.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Ok, ya estas advertido. ¡Suerte!", Toast.LENGTH_LONG).show();
            }
        });

        dialogo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "¡Ey, las reglas son importantes!", Toast.LENGTH_LONG).show();

            }
        });

        dialogo.setNeutralButton("Da igual", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Bueno... Suerte supongo...", Toast.LENGTH_LONG).show();

            }
        });
        dialogo.show();
    }

    public void Empezar(){
        eduser = findViewById(R.id.eduser);
        Intent empezar = new Intent(this, Primerapregunta.class);
        empezar.putExtra("user", eduser.getText().toString());
        startActivity(empezar);
    }
}
