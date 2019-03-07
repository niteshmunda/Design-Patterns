package com.example.stopwatch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean running;
    private int second = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null){
            second = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
        }
        runtimer();
    }

    private void runtimer() {
        final TextView textView = findViewById(R.id.timeText);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = second / 3600;
                int minutes = (second % 3600)/60;
                int seconds = second%60;

                String time = String.format("%d:%02d:%02d",hours,minutes,seconds);
                textView.setText(time);
                if(running)
                    second++;
                handler.postDelayed(this,1000);
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("seconds",second);
        outState.putBoolean("running",running);
        super.onSaveInstanceState(outState);
    }

    public void startCLick(View view) {
        running  = true;
    }

    public void pauseClick(View view) {
        running  = false;
    }

    public void restartCLick(View view) {
        running = false;
        second = 0;
    }
}
