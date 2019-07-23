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

public class DecimaPregunta extends AppCompatActivity {

    RadioButton r101,r102,r103,r104;
    int rst10;
    TextView user;
    ImageButton ibtn;
    public static int espera = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decima_pregunta);
        ibtn = findViewById(R.id.ibtn);
        r101 = findViewById(R.id.rq101);
        r102 = findViewById(R.id.rq102);
        r103 = findViewById(R.id.rq103);
        r104 = findViewById(R.id.rq104);
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
        r101.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rst10 = 0;
                r101.setBackgroundDrawable(getResources().getDrawable(R.drawable.rrounded_error));
                esperar(espera);
            }
        });
        r102.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rst10 = 0;
                r102.setBackgroundDrawable(getResources().getDrawable(R.drawable.rrounded_error));
                esperar(espera);
            }
        });
        r103.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rst10 = 0;
                r103.setBackgroundDrawable(getResources().getDrawable(R.drawable.rrounded_error));
                esperar(espera);
            }
        });
        r104.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rst10 = 1;
                r104.setBackgroundDrawable(getResources().getDrawable(R.drawable.rrounded_correct));
                esperar(espera);
            }
        });
    }

    public void Resultado(){
        Bundle bundle2 = new Bundle();
        bundle2 = getIntent().getExtras();
        Intent intent1 = new Intent(this, Resultado.class);
        String us2 =  user.getText().toString();
        int rs1 = bundle2.getInt("result1");
        int rs2 = bundle2.getInt("result2");
        int rs3 = bundle2.getInt("result3");
        int rs4 = bundle2.getInt("result4");
        int rs5 = bundle2.getInt("result5");
        int rs6 = bundle2.getInt("result6");
        int rs7 = bundle2.getInt("result7");
        int rs8 = bundle2.getInt("result8");
        int rs9 = bundle2.getInt("result9");
        intent1.putExtra("result1", rs1);
        intent1.putExtra("result2",rs2);
        intent1.putExtra("result3", rs3);
        intent1.putExtra("result4",rs4);
        intent1.putExtra("result5", rs5);
        intent1.putExtra("result6", rs6);
        intent1.putExtra("result7", rs7);
        intent1.putExtra("result8", rs8);
        intent1.putExtra("result9", rs9);
        intent1.putExtra("result10", rst10);
        intent1.putExtra("user", us2);
        startActivity(intent1);
        finish();
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

    public void Mostrar_dialogo(){
        new Bundle();
        Bundle bundle3;
        bundle3 = getIntent().getExtras();
        int p1 = bundle3.getInt("result1");
        int p2 = bundle3.getInt("result2");
        int p3 = bundle3.getInt("result3");
        int p4 = bundle3.getInt("result4");
        int p5 = bundle3.getInt("result5");
        int p6 = bundle3.getInt("result6");
        int p7 = bundle3.getInt("result7");
        int p8 = bundle3.getInt("result8");
        int p9 = bundle3.getInt("result9");
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle("Puntuación");
        dialogo.setIcon(android.R.drawable.ic_dialog_info);
        dialogo.setMessage("Las puntuaciones se veran reflejadas con 1 y 0, 1 para la respuesta correcta y 0 para la respuesta incorrecta. \n\n" +
                "Pregunta 1: " + p1 + "\n Pregunta 2: " + p2 + " \n Pregunta 3: "+ p3 +" \n Pregunta 4: " + p4 + "\n Pregunta 5: " + p5 +"" +
                "\nPregunta 6: " +p6+"\n Pregunta 7: "+p7+"\n Pregunta 8: "+p8+"\n Pregunta 9: "+p9+"");
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

    public void onBackPressed() {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle(getResources().getString(R.string.sal));
        dialogo.setIcon(android.R.drawable.ic_dialog_info);
        dialogo.setMessage(getResources().getString(R.string.conf));
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
