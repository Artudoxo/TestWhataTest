package com.liarkat.testwhatatest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
    EditText eduser, pass;
    String corre, contraseña;
    Button btnempezar, btnrules;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eduser = findViewById(R.id.eduser);
        pass = findViewById(R.id.edpass);
        firebaseAuth = FirebaseAuth.getInstance();
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
                corre = eduser.getText().toString().trim();
                contraseña = pass.getText().toString().trim();
                firebaseAuth.createUserWithEmailAndPassword(corre,contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Registrado", Toast.LENGTH_SHORT).show();
                            eduser.getText().clear();
                            pass.getText().clear();
                            Empezar();
                        }else {
                            Toast.makeText(MainActivity.this, "No registrado", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest2 = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest2);


    }


    public void Mostrar_dialogo(){
        MaterialAlertDialogBuilder dialogo = new MaterialAlertDialogBuilder(this);
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
        pass = findViewById(R.id.edpass);
        try{
            if (eduser.getText().toString().isEmpty() && pass.getText().toString().isEmpty() ){
                eduser.setError(getResources().getString(R.string.camp));
                pass.setError(getResources().getString(R.string.camp));

            }else{

                Intent empezar = new Intent(this, Status.class);
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
        pass.getText().clear();
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
