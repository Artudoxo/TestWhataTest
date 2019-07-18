package com.liarkat.testwhatatest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RadioButton;

public class TerceraPregunta extends AppCompatActivity {
    RadioButton r31,r32,r33,r34;
    int rst3;
    public static int espera =1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera_pregunta);
        r31 = findViewById(R.id.r31);
        r32 = findViewById(R.id.r32);
        r33 = findViewById(R.id.r33);
        r34 = findViewById(R.id.r34);

        r31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rst3 = 0;
                r31.setBackgroundDrawable(getResources().getDrawable(R.drawable.rrounded_error));
                esperar(espera);
            }
        });
        r32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rst3 = 0;
                r32.setBackgroundDrawable(getResources().getDrawable(R.drawable.rrounded_error));
                esperar(espera);
            }
        });
        r33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rst3 = 0;
                r33.setBackgroundDrawable(getResources().getDrawable(R.drawable.rrounded_correct));
                esperar(espera);
            }
        });
        r34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rst3 = 0;
                r34.setBackgroundDrawable(getResources().getDrawable(R.drawable.rrounded_error));
                esperar(espera);
            }
        });
    }

    public void Cuartapregunta1(){
        Intent intent1 = new Intent(this, CuartaPregunta.class);
        intent1.putExtra("result2", rst3);
        startActivity(intent1);
    }

    public void esperar(int milisegundos){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Cuartapregunta1();
            }
        },milisegundos);
    }

}
