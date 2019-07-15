package com.liarkat.testwhatatest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RadioButton;

public class SextaPregunta extends AppCompatActivity {

    RadioButton r61,r62,r63,r64;
    public static int espera = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sexta_pregunta);
        r61 = findViewById(R.id.rq64);
        r62 = findViewById(R.id.rq62);
        r63 = findViewById(R.id.rq63);
        r64 = findViewById(R.id.rq64);

        r61.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                esperar(espera);
            }
        });
        r62.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                esperar(espera);
            }
        });
        r63.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                esperar(espera);
            }
        });
        r64.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                esperar(espera);
            }
        });
    }

    public void Septimapregunta1(){
        Intent intent1 = new Intent(this, SeptimaPregunta.class);
        startActivity(intent1);
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

}
