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

import org.w3c.dom.Text;

public class SegundaPregunta extends AppCompatActivity {
    RadioButton r21, r22, r23, r24;
    int rst2;
    TextView users;
    ImageButton ibtn;
    public static int espera = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pregunta);
        ibtn = findViewById(R.id.ibtn);
        r21 = findViewById(R.id.r21);
        r22 = findViewById(R.id.r22);
        r23 = findViewById(R.id.r23);
        r24 = findViewById(R.id.r24);
        users = findViewById(R.id.users);
        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();
        String us = bundle.getString("user");

        users.setText(us);


        ibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mostrar_dialogo();
            }
        });
        r21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rst2 = 0;
                r21.setBackgroundDrawable(getResources().getDrawable(R.drawable.rrounded_error));
                esperar(espera);
            }
        });
        r22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rst2 = 0;
                r22.setBackgroundDrawable(getResources().getDrawable(R.drawable.rrounded_error));
                esperar(espera);
            }
        });
        r23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rst2 = 0;
                r23.setBackgroundDrawable(getResources().getDrawable(R.drawable.rrounded_error));
                esperar(espera);
            }
        });
        r24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rst2 = 1;
                r24.setBackgroundDrawable(getResources().getDrawable(R.drawable.rrounded_correct));
                esperar(espera);
            }
        });
    }

    public void Tercerapregunta1(){
        Bundle bundle2 = new Bundle();
        bundle2 = getIntent().getExtras();
        Intent intent1 = new Intent(this, TerceraPregunta.class);
        intent1.putExtra("result2", rst2);
        String us2 =  users.getText().toString();
        int rs1 = bundle2.getInt("result1");
        intent1.putExtra("user", us2);
        intent1.putExtra("result1", rs1);
        startActivity(intent1);
        finish();
    }

    public void esperar(int milisegundos){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Tercerapregunta1();
            }
        },milisegundos);
    }

    public void Mostrar_dialogo(){
        new Bundle();
        Bundle bundle3;
        bundle3 = getIntent().getExtras();
        int p1 = bundle3.getInt("result1");
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle("Puntuación");
        dialogo.setIcon(android.R.drawable.ic_dialog_info);
        dialogo.setMessage("Las puntuaciones se veran reflejadas con 1 y 0, 1 para la respuesta correcta y 0 para la respuesta incorrecta. \n\n" +
                "Pregunta 1:" + p1 + " ");
        dialogo.setCancelable(true);
        dialogo.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Ok, parece que todo va bien... supongo...", Toast.LENGTH_LONG).show();
            }
        });

        dialogo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "No se como vayas, pero... ¡Suerte!", Toast.LENGTH_LONG).show();

            }
        });
        dialogo.show();
    }
}
