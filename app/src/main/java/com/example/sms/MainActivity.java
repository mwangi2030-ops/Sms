package com.example.sms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=(Button)findViewById(R.id.buttonSend);
        final EditText phoneNumber=(EditText)findViewById(R.id.EPhoneNo);
        final EditText EdsendSms=(EditText) findViewById(R.id.editTextSMS);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNo=phoneNumber.getText().toString();
                String sms=EdsendSms.getText().toString();
                try{
                    SmsManager smsManager=SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNo, null, sms, null, null);
                    Toast.makeText(getApplicationContext(), "SMS Sent !", Toast.LENGTH_LONG).show();
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(), "SMS failed, Please try again later !", Toast.LENGTH_LONG).show();
                   e.printStackTrace();
                }
            }
        });
    }
}
