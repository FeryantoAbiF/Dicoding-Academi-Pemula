package com.example.feryanto.kumato;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

import static android.drm.DrmStore.Playback.START;

public class MainActivity extends AppCompatActivity {

    private static final long START_TIME_IN_MILIS = 1500000;
    private TextView countdown;
    private Button btnstart_pause;
    private Button btnreset;

    private CountDownTimer mCountDownTimer;

    private boolean mTimerRunnig;

    private long mTimeleftinmilis = START_TIME_IN_MILIS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countdown = findViewById(R.id.waktu);
        btnstart_pause= findViewById(R.id.tombolstart_pause);
        btnreset = findViewById(R.id.tombolreset);

        btnstart_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTimerRunnig) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });
        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                risetTimer();
            }
        });
        updateCountDownText();

    }

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeleftinmilis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeleftinmilis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunnig = false;
                btnstart_pause.setText("Start");
                btnstart_pause.setVisibility(View.INVISIBLE);
                btnreset.setVisibility(View.VISIBLE);

            }
        }.start();

        mTimerRunnig = true;
        btnstart_pause.setText("Pause");
        btnreset.setVisibility(View.VISIBLE);
    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunnig = false;
        btnstart_pause.setText("Start");
        btnreset.setVisibility(View.VISIBLE);
    }

    private void risetTimer() {
        mTimeleftinmilis = START_TIME_IN_MILIS;
        updateCountDownText();
        btnreset.setVisibility(View.VISIBLE);
        btnstart_pause.setVisibility(View.VISIBLE);
    }

    private void updateCountDownText() {

        int minutes = (int) (mTimeleftinmilis / 1000) / 60;
        int seconds = (int) (mTimeleftinmilis / 1000) % 60;

        String timeleftFormated = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        countdown.setText(timeleftFormated);
    }

}
