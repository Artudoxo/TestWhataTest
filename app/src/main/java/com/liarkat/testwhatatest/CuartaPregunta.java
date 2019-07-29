package com.liarkat.testwhatatest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class CuartaPregunta extends AppCompatActivity {
    RadioButton r41,r42,r43,r44;
    TextView user;
    int rst4;
    ImageButton ibtn;
    public static int espera = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuarta_pregunta);
        ibtn = findViewById(R.id.ibtn);
        r41 = findViewById(R.id.r41);
        r42 = findViewById(R.id.r42);
        r43 = findViewById(R.id.r43);
        r44 = findViewById(R.id.r44);
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
        r41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rst4 = 0;
                r41.setBackgroundDrawable(getResources().getDrawable(R.drawable.rrounded_error));
                esperar(espera);
            }
        });
        r42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rst4 = 0;
                r42.setBackgroundDrawable(getResources().getDrawable(R.drawable.rrounded_error));
                esperar(espera);
            }
        });
        r43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rst4 = 0;
                r43.setBackgroundDrawable(getResources().getDrawable(R.drawable.rrounded_error));
                esperar(espera);
            }
        });
        r44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rst4 = 1;
                r44.setBackgroundDrawable(getResources().getDrawable(R.drawable.rrounded_correct));
                esperar(espera);
            }
        });
    }

    public void Quintapregunta1(){
        Bundle bundle2 = new Bundle();
        bundle2 = getIntent().getExtras();
        Intent intent1 = new Intent(this, QuintaPregunta.class);
        String us2 =  user.getText().toString();
        int rs1 = bundle2.getInt("result1");
        int rs2 = bundle2.getInt("result2");
        int rs3 = bundle2.getInt("result3");
        intent1.putExtra("result1", rs1);
        intent1.putExtra("result2",rs2);
        intent1.putExtra("result3", rs3);
        intent1.putExtra("result4", rst4);
        intent1.putExtra("user", us2);
        startActivity(intent1);
        finish();
    }

    public void esperar(int milisegundos){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Quintapregunta1();
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
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle(getResources().getString(R.string.puntuacion));
        dialogo.setIcon(android.R.drawable.ic_dialog_info);
        dialogo.setMessage(getResources().getString(R.string.dp1)+"\n\n" +
                getResources().getString(R.string.q1)+ + p1 + "\n"+ getResources().getString(R.string.q2)+
                p2 + " \n"+ getResources().getString(R.string.q3)+ p3);
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
