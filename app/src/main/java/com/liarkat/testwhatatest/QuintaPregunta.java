package com.liarkat.testwhatatest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RadioButton;

public class QuintaPregunta extends AppCompatActivity {
    RadioButton r51,r52,r53,r54;
    public static int espera = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quinta_pregunta);
        r51 = findViewById(R.id.rq51);
        r52 = findViewById(R.id.rq52);
        r53 = findViewById(R.id.rq53);
        r54 = findViewById(R.id.rq54);

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
        Intent intent1 = new Intent(this, SextaPregunta.class);
        startActivity(intent1);
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

}
