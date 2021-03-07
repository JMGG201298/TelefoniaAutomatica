package com.example.telefoniaautomatica;

import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class MyEscuchadorLlamadar extends PhoneStateListener {
    @Override
    public void onCallStateChanged(int state, String phoneNumber) {
        super.onCallStateChanged(state, phoneNumber);
        if(state==1){
            BrodcastSms.numeroentrante=phoneNumber;
        }
    }
}
