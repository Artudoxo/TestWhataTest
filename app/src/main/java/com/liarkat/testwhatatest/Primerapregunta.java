package com.liarkat.testwhatatest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Primerapregunta extends AppCompatActivity {
    RadioButton r11, r12, r13, r14;
    public static int espera = 1000;
    TextView users;
    ImageButton itbn;
    int rst1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primerapregunta);

        r11 = findViewById(R.id.r11);
        r12 = findViewById(R.id.r12);
        r13 = findViewById(R.id.r13);
        r14 = findViewById(R.id.r14);
        itbn = findViewById(R.id.ibtn);

        itbn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mostrar_dialogo();
            }
        });
        users = findViewById(R.id.users);
        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();
        String us = bundle.getString("user");
        users.setText(us);

        r11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rst1 = 1;
                r11.setBackgroundDrawable(getResources().getDrawable(R.drawable.rrounded_correct));
                esperar(espera);
            }
        });
        r12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rst1 = 0;
                r12.setBackgroundDrawable(getResources().getDrawable(R.drawable.rrounded_error));
                esperar(espera);
            }
        });
        r13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rst1 = 0;
                r13.setBackgroundDrawable(getResources().getDrawable(R.drawable.rrounded_error));
                esperar(espera);
            }
        });
        r14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rst1 = 0;
                r14.setBackgroundDrawable(getResources().getDrawable(R.drawable.rrounded_error));
                esperar(espera);
            }
        });
    }

    public void Segundapregunta1(){
        Intent intent1 = new Intent(this, SegundaPregunta.class);
        intent1.putExtra("result1", rst1);
        String us2 =  users.getText().toString();
        intent1.putExtra("user", us2);
        startActivity(intent1);
        finish();
    }

    public void esperar(int milisegundos){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               Segundapregunta1();
            }
        },milisegundos);
    }

    public void Mostrar_dialogo(){

        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle("Puntuación");
        dialogo.setIcon(android.R.drawable.ic_dialog_info);
        dialogo.setMessage("Las puntuaciones se veran reflejadas con 1 y 0, 1 para la respuesta correcta y 0 para la respuesta incorrecta.\n\nHey acabas de empezar, estas en la primera pregunta, cuando respondas esta ven a verme.");
        dialogo.setCancelable(true);
        dialogo.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Ok, parece que todo va bien... supongo...", Toast.LENGTH_LONG).show();
            }
        });


        dialogo.show();
    }

    public void onBackPressed() {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle("Hacia la pantalla principal");
        dialogo.setIcon(android.R.drawable.ic_dialog_info);
        dialogo.setMessage("¿Estas seguro/a que deseas dar hacia atras? \n\n Todo tu proceso se perdera si lo haces");
        dialogo.setCancelable(true);
        dialogo.setPositiveButton("¡Si! Sacame de aquí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Ok, hacerlo otra vez no vendra mal tampoco.", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        dialogo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Bueno, continuemos con esto", Toast.LENGTH_LONG).show();

            }
        });
        dialogo.show();

    }


}
