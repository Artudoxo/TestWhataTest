package com.liarkat.testwhatatest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RadioButton;

public class DecimaPregunta extends AppCompatActivity {

    RadioButton r101,r102,r103,r104;
    public static int espera = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decima_pregunta);
        r101 = findViewById(R.id.rq104);
        r102 = findViewById(R.id.rq102);
        r103 = findViewById(R.id.rq103);
        r104 = findViewById(R.id.rq104);

        r101.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                esperar(espera);
            }
        });
        r102.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                esperar(espera);
            }
        });
        r103.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                esperar(espera);
            }
        });
        r104.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                esperar(espera);
            }
        });
    }

    public void Resultado(){
        Intent intent1 = new Intent(this, Resultado.class);
        startActivity(intent1);
    }

    public void esperar(int milisegundos){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Resultado();
            }
        },milisegundos);
    }
}
