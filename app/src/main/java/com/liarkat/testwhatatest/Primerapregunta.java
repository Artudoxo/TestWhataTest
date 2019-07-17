package com.liarkat.testwhatatest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RadioButton;

public class Primerapregunta extends AppCompatActivity {
    RadioButton r11, r12, r13, r14;
    public static int espera = 1000;
    int rst1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primerapregunta);

        r11 = findViewById(R.id.r11);
        r12 = findViewById(R.id.r12);
        r13 = findViewById(R.id.r13);
        r14 = findViewById(R.id.r14);



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
        startActivity(intent1);

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



}
