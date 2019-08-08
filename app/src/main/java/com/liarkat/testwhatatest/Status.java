package com.liarkat.testwhatatest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class Status extends AppCompatActivity {
    private static String TAG = "Servicio";

    Button contador, logoutt;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        contador = findViewById(R.id.txtcountdown);

        //inicia el servicio
        startService(new Intent(Status.this, ServicioTimer.class));

        firebaseAuth = FirebaseAuth.getInstance();
        logoutt = findViewById(R.id.logout);

        logoutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(Status.this, MainActivity.class));
            }
        });

    }

    private BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //aqui obtienes los datos enviados por el servicio
            //obtienes el tiempo que lleva
            if (intent.getExtras() != null){
                if (intent.hasExtra("Tiempo")){
                    String tiempo = intent.getStringExtra("Tiempo");
                    contador.setText(tiempo);
                } if (intent.hasExtra("Fin")){
                    //se recibe que se ha finalizado el contador
                    String tiempo = intent.getStringExtra("Fin");
                    contador.setText(tiempo);
                    contador.setEnabled(true);
                    //cierras el servicio ya que no es necesario mantenerlo, sera creado al pulsar el boton nuevamente
                    stopService(new Intent(Status.this, ServicioTimer.class));
                }
            }
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(br, new IntentFilter(ServicioTimer.PAQUETE));
        Log.i(TAG, "Broadcast registrado");
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(br);
        Log.i(TAG, "Broadcast desligado");
    }

    @Override
    protected void onStop() {
        try {
            unregisterReceiver(br);
        }catch (Exception e){
        }
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        stopService(new Intent(Status.this, ServicioTimer.class));
        Log.i(TAG, "Termina el servicio");
        super.onDestroy();
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
                firebaseAuth.signOut();
                startActivity(new Intent(Status.this, MainActivity.class));
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
