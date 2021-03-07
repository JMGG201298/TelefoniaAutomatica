package com.example.telefoniaautomatica;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class BrodcastSms extends BroadcastReceiver {
    static String numeroentrante=null;
    @Override
    public void onReceive(Context context, Intent intent) {
        MyEscuchadorLlamadar myEscuchadorLlamadar=new MyEscuchadorLlamadar();
        TelephonyManager telephonyManager=(TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        telephonyManager.listen(myEscuchadorLlamadar, PhoneStateListener.LISTEN_CALL_STATE);


        if(numeroentrante!=null){
            String entro=numeroentrante;
            Intent intent1=new Intent(context.getApplicationContext(),MainActivity.class);
            intent1.putExtra("numero",entro);
            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.getApplicationContext().startActivity(intent1);

        }


    }


}
