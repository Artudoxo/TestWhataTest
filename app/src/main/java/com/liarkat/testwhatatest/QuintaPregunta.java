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

public class QuintaPregunta extends AppCompatActivity {
    RadioButton r51,r52,r53,r54;
    TextView user;
    ImageButton ibtn;
    int rst5;
    public static int espera = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quinta_pregunta);
        ibtn = findViewById(R.id.ibtn);
        r51 = findViewById(R.id.rq51);
        r52 = findViewById(R.id.rq52);
        r53 = findViewById(R.id.rq53);
        r54 = findViewById(R.id.rq54);
        user = findViewById(R.id.user);
        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();
        String us = bundle.getString("user");

        user.setText(us);

        ibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mostrar_dialogo();
            }
        });
        r51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                esperar(espera);
            }
        });
        r52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                esperar(espera);
            }
        });
        r53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                esperar(espera);
            }
        });
        r54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                esperar(espera);
            }
        });
    }

    public void Sextapregunta1(){
        Bundle bundle2 = new Bundle();
        bundle2 = getIntent().getExtras();
        Intent intent1 = new Intent(this, QuintaPregunta.class);
        String us2 =  user.getText().toString();
        int rs1 = bundle2.getInt("result1");
        int rs2 = bundle2.getInt("result2");
        int rs3 = bundle2.getInt("result3");
        int rs4 = bundle2.getInt("result4");
        intent1.putExtra("result1", rs1);
        intent1.putExtra("result2",rs2);
        intent1.putExtra("result3", rs3);
        intent1.putExtra("result4", rs4);
        intent1.putExtra("result5", rst5);
        intent1.putExtra("user", us2);
        startActivity(intent1);
        finish();
    }

    public void esperar(int milisegundos){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Sextapregunta1();
            }
        },milisegundos);
    }


    public void Mostrar_dialogo(){
        new Bundle();
        Bundle bundle3;
        bundle3 = getIntent().getExtras();
        int p1 = bundle3.getInt("result1");
        int p2 = bundle3.getInt("result2");
        int p3 = bundle3.getInt("result3");
        int p4 = bundle3.getInt("result4");
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle("Puntuación");
        dialogo.setIcon(android.R.drawable.ic_dialog_info);
        dialogo.setMessage("Las puntuaciones se veran reflejadas con 1 y 0, 1 para la respuesta correcta y 0 para la respuesta incorrecta. \n\n" +
                "Pregunta 1: " + p1 + "\n Pregunta 2: " + p2 + " \n Pregunta 3: "+ p3 +" \n Pregunta 4: " + p4 + "");
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
