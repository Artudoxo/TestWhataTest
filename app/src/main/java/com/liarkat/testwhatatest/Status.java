package com.liarkat.testwhatatest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Status extends AppCompatActivity {
    private static String TAG = "Servicio";

    Button contador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        contador = findViewById(R.id.txtcountdown);

        //inicia el servicio
        startService(new Intent(Status.this, ServicioTimer.class));

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
}
