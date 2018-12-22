package com.example.feryanto.smslistenerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SmsReceiverActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvsmsform;
    private TextView tvsmsmessage;
    private Button btnclose;
    public static final String EXTRA_SMS_NO ="extra_sms_no";
    public static final String EXTRA_SMS_MESSAGE ="extra_sms_message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_receiver);
        tvsmsform = (TextView)findViewById(R.id.tv_on);
        tvsmsmessage =(TextView)findViewById(R.id.tv_message);
        btnclose =(Button)findViewById(R.id.btn_close);
        btnclose.setOnClickListener(this);
        String senderNo = getIntent().getStringExtra(EXTRA_SMS_NO);
        String senderMessage = getIntent().getStringExtra(EXTRA_SMS_MESSAGE);

        tvsmsform.setText("Form : "+senderNo);
        tvsmsmessage.setText(senderMessage);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.btn_close){
            finish();
        }
    }
}
