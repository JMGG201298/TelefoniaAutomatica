package com.example.telefoniaautomatica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

    BrodcastSms brodcastSms=new BrodcastSms();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("android.intent.action.PHONE_STATE");
        registerReceiver(brodcastSms,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(brodcastSms);
    }
}