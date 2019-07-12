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
                left(btnempezar);
            }
        });

        btnrules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mostrar_dialogo();
            }
        });




    }

    @Override
    protected void onResume() {
        super.onResume();
        eduser.setFocusable(false);
    }

    public void Mostrar_dialogo(){
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle("Reglas a seguir");
        dialogo.setIcon(android.R.drawable.ic_dialog_info);
        dialogo.setMessage("De acuerdo a la cantidad de preguntas acertadas se te sera evaluado. \n\na. 10 preguntas acertadas = ¡Que haces aqui nerd!" +
        "\n\nb. De 7 a 9 preguntas acertadas = !Hey, no se te da mal! \n\nc. De 4 a 6 preguntas acertadas = Mira... no quiero asustarte pero... estudia mas..."+
                "\n\nd. De 1 a 3 preguntas acertadas = ¿De verdad asistias a clases?\n\n\n Toda puntuación alcanzada en esta App no sera publicada en ningun medio conocido, por favor, sientete libre de responder con confianza.");
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
                Toast.makeText(getApplicationContext(), "Bueno... Suerte, supongo...", Toast.LENGTH_LONG).show();

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

    public void left(View button)
    {
        startActivity(new Intent(this, Primerapregunta.class));
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }
}
