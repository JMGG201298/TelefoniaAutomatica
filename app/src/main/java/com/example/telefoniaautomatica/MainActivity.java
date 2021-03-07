package com.example.telefoniaautomatica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtNumero;
    EditText txtMensa;
    Button btnEnviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNumero=findViewById(R.id.txtNumero);
        txtMensa=findViewById(R.id.txtMensaje);
        btnEnviar=findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtNumero.getText().toString()!="" && txtMensa.getText().toString()!=""){
                    enviarSms(txtNumero.getText().toString(),txtMensa.getText().toString());
                }else{
                    Toast.makeText(getBaseContext(),"Es necesario que todos los datos esten llenos",Toast.LENGTH_SHORT).show();
                }

            }
        });
        String numero=getIntent().getStringExtra("numero");
        if(numero!=null){
            txtNumero.setText(numero);
        }


    }


    public void  enviarSms(String numero, String mensaje){
        SmsManager smsManager=SmsManager.getDefault();
        smsManager.sendTextMessage(numero,null,mensaje,null, null);
    }
    public void permisoEnviarSms(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            if(ActivityCompat.checkSelfPermission(getBaseContext(), Manifest.permission.SEND_SMS)!=PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS},1);
            }else{
                enviarSms(null,null);
            }
        }else {
            enviarSms(null,null);
        }
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

    }
}