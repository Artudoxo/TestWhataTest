package com.liarkat.testwhatatest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText eduser;
    Button btnempezar, btnrules;

    private Locale locale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnempezar = findViewById(R.id.btnempezar);
        btnrules = findViewById(R.id.brnrules);
        btnempezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Empezar();
            }
        });

        btnrules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mostrar_dialogo();
            }
        });




    }


    public void Mostrar_dialogo(){
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle(getResources().getString(R.string.rules));
        dialogo.setIcon(android.R.drawable.ic_dialog_info);
        dialogo.setMessage(getResources().getString(R.string.d1)+  " \n\n" +getResources().getString(R.string.d2) +
        "\n\n"+getResources().getString(R.string.d3) +" \n\n"+getResources().getString(R.string.d4) +
                "\n\n"+getResources().getString(R.string.d5) +"\n\n\n "+getResources().getString(R.string.d6));
        dialogo.setCancelable(true);
        dialogo.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),getResources().getString(R.string.adv) , Toast.LENGTH_LONG).show();
            }
        });

        dialogo.setNegativeButton(getResources().getString(R.string.canc), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.neg), Toast.LENGTH_LONG).show();

            }
        });

        dialogo.setNeutralButton(getResources().getString(R.string.da), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.bueno), Toast.LENGTH_LONG).show();

            }
        });

        dialogo.show();
    }

    public void Empezar(){
        eduser = findViewById(R.id.eduser);
        try{
            if (eduser.getText().toString().isEmpty()){
                eduser.setError(getResources().getString(R.string.camp));
            }else{
                Intent empezar = new Intent(this, Primerapregunta.class);
                empezar.putExtra("user", eduser.getText().toString());
                startActivity(empezar);
            }
        }catch(Exception e){
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.user), Toast.LENGTH_LONG).show();
        }


    }

    @Override
    protected void onPause() {
        super.onPause();
        eduser.getText().clear();
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
