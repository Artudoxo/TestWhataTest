package com.liarkat.testwhatatest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Resultado extends AppCompatActivity {
    Button btnvolver;
    TextView txtmensaje, txtresultado, user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();
        String us = bundle.getString("user");
        user = findViewById(R.id.user);
        user.setText(us);
        int rs1 = bundle.getInt("result1");
        int rs2 = bundle.getInt("result2");
        int rs3 = bundle.getInt("result3");
        int rs4 = bundle.getInt("result4");
        int rs5 = bundle.getInt("result5");
        int rs6 = bundle.getInt("result6");
        int rs7 = bundle.getInt("result7");
        int rs8 = bundle.getInt("result8");
        int rs9 = bundle.getInt("result9");
        int rs10 = bundle.getInt("result10");

        int resultado = rs1 +rs2 + rs3 + rs4 + rs5 + rs6 + rs7 + rs8 + rs9 + rs10;
        txtresultado = findViewById(R.id.txtresultado);
        txtresultado.setText(resultado +"/10");
        txtmensaje = findViewById(R.id.txtmensaje);
        if (resultado == 10){
            txtmensaje.setText(getResources().getString(R.string.nerd));
        } else if(resultado < 10 && resultado > 6){
            txtmensaje.setText(getResources().getString(R.string.nomal));
        } else if (resultado < 7 && resultado > 3){
            txtmensaje.setText(getResources().getString(R.string.scary));
        } else if (resultado < 4 && resultado > 0){
            txtmensaje.setText(getResources().getString(R.string.classes));
        } else if (resultado == 0){
            txtmensaje.setText(getResources().getString(R.string.alcance));
        }
        btnvolver = findViewById(R.id.btnvolver);

        btnvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Volver();
            }
        });
    }

    public void Volver(){
        Intent volver = new Intent(this, MainActivity.class);
        startActivity(volver);
        finish();
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
