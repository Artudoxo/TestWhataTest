package com.liarkat.testwhatatest;

import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.util.Log;

import java.util.concurrent.TimeUnit;

public class ServicioTimer extends Service {

    String FORMAT = "%02d:%02d:%02d";
    private static String TAG = "Servicio";
    public static final String PAQUETE = "com.liarkat.com.activity_status";
    Intent bi = new Intent(PAQUETE);

    CountDownTimer cdt = null;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "Comienza el timer...");
        cdt = new CountDownTimer(86400000, 1000) {
            @Override
            public void onTick(long l) {
                String tiempo = ""+String.format(FORMAT,
                        TimeUnit.MILLISECONDS.toHours(l),
                        TimeUnit.MILLISECONDS.toMinutes(l)- TimeUnit.HOURS.toMinutes(
                                TimeUnit.MILLISECONDS.toHours(l)),
                        TimeUnit.MILLISECONDS.toSeconds(l) - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(l)
                        ));
                //con esto se envia el tiempo
                bi.putExtra("Tiempo", tiempo);
                sendBroadcast(bi);
            }

            @Override
            public void onFinish() {
                //se envia el tiempo finalizado
                bi.putExtra("Fin", "Recoger");
                sendBroadcast(bi);
            }
        }.start();
    }

    @Override
    public void onDestroy() {
        cdt.cancel();
        Log.i(TAG, "Timer cancelado");
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
