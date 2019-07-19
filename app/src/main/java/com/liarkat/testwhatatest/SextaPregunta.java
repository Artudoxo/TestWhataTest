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

public class SextaPregunta extends AppCompatActivity {

    RadioButton r61,r62,r63,r64;
    int rst6;
    TextView user;
    ImageButton ibtn;
    public static int espera = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sexta_pregunta);
        ibtn = findViewById(R.id.ibtn);
        r61 = findViewById(R.id.rq61);
        r62 = findViewById(R.id.rq62);
        r63 = findViewById(R.id.rq63);
        r64 = findViewById(R.id.rq64);
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
        r61.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rst6 = 0;
                r61.setBackgroundDrawable(getResources().getDrawable(R.drawable.rrounded_error));
                esperar(espera);
            }
        });
        r62.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rst6 = 0;
                r62.setBackgroundDrawable(getResources().getDrawable(R.drawable.rrounded_error));
                esperar(espera);
            }
        });
        r63.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rst6 = 0;
                r63.setBackgroundDrawable(getResources().getDrawable(R.drawable.rrounded_error));
                esperar(espera);
            }
        });
        r64.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rst6 = 0;
                r64.setBackgroundDrawable(getResources().getDrawable(R.drawable.rrounded_error));
                esperar(espera);
            }
        });
    }

    public void Septimapregunta1(){
        try{
            Bundle bundle2 = new Bundle();
            bundle2 = getIntent().getExtras();
            Intent intent1 = new Intent(this, SeptimaPregunta.class);
            String us2 =  user.getText().toString();
            int rs1 = bundle2.getInt("result1");
            int rs2 = bundle2.getInt("result2");
            int rs3 = bundle2.getInt("result3");
            int rs4 = bundle2.getInt("result4");
            int rs5 = bundle2.getInt("result5");
            intent1.putExtra("result1", rs1);
            intent1.putExtra("result2",rs2);
            intent1.putExtra("result3", rs3);
            intent1.putExtra("result4",rs4);
            intent1.putExtra("result5", rs5);
            intent1.putExtra("result6", rst6);
            intent1.putExtra("user", us2);
            startActivity(intent1);
            finish();
        }catch(Exception e){
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }

    public void esperar(int milisegundos){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Septimapregunta1();
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
        int p5 = bundle3.getInt("result5");
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle("Puntuación");
        dialogo.setIcon(android.R.drawable.ic_dialog_info);
        dialogo.setMessage("Las puntuaciones se veran reflejadas con 1 y 0, 1 para la respuesta correcta y 0 para la respuesta incorrecta. \n\n" +
                "Pregunta 1: " + p1 + "\n Pregunta 2: " + p2 + " \n Pregunta 3: "+ p3 +" \n Pregunta 4: " + p4 + "\n Pregunta 5: " + p5 +"");
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
