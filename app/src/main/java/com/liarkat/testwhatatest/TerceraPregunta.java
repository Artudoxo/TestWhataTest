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

public class TerceraPregunta extends AppCompatActivity {
    RadioButton r31,r32,r33,r34;
    int rst3;
    TextView user;
    ImageButton ibtn;
    public static int espera =1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera_pregunta);

        ibtn = findViewById(R.id.ibtn);


        r31 = findViewById(R.id.r31);
        r32 = findViewById(R.id.r32);
        r33 = findViewById(R.id.r33);
        r34 = findViewById(R.id.r34);
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
                rst3 = 1;
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
        Bundle bundle2 = new Bundle();
        bundle2 = getIntent().getExtras();
        Intent intent1 = new Intent(this, CuartaPregunta.class);
        String us2 =  user.getText().toString();
        int rs1 = bundle2.getInt("result1");
        int rs2 = bundle2.getInt("result2");
        intent1.putExtra("result1", rs1);
        intent1.putExtra("result2",rs2);
        intent1.putExtra("result3", rst3);
        intent1.putExtra("user", us2);
        startActivity(intent1);
        finish();
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

    public void Mostrar_dialogo(){
        new Bundle();
        Bundle bundle3;
        bundle3 = getIntent().getExtras();
        int p1 = bundle3.getInt("result1");
        int p2 = bundle3.getInt("result2");
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle(getResources().getString(R.string.puntuacion));
        dialogo.setIcon(android.R.drawable.ic_dialog_info);
        dialogo.setMessage(getResources().getString(R.string.dp1)+"\n\n" +
                getResources().getString(R.string.q1)+ + p1 + "\n"+ getResources().getString(R.string.q2)+ + p2);
        dialogo.setCancelable(true);
        dialogo.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.dp3), Toast.LENGTH_LONG).show();
            }
        });

        dialogo.setNegativeButton(getResources().getString(R.string.canc), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.dp4), Toast.LENGTH_LONG).show();

            }
        });
        dialogo.show();
    }

    public void onBackPressed() {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle(getResources().getString(R.string.sal));
        dialogo.setIcon(android.R.drawable.ic_dialog_info);
        dialogo.setMessage(getResources().getString(R.string.sa));
        dialogo.setCancelable(true);
        dialogo.setPositiveButton(getResources().getString(R.string.sali), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        dialogo.setNegativeButton(getResources().getString(R.string.canc), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.conti), Toast.LENGTH_LONG).show();

            }
        });
        dialogo.show();

    }

}
