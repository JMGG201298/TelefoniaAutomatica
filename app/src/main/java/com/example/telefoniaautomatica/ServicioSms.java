package com.example.telefoniaautomatica;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class ServicioSms extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Thread hilo=new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        return START_NOT_STICKY;
    }

    @Override
    public boolean stopService(Intent name) {
        return super.stopService(name);
    }
}
