package com.example.stopwatch;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    private boolean running;
    private int second = 0;
    public final String mypreference = "mypref";
    public final String secondss = "secondsKey";
    public final String runnings = "runningKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null){
            second = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
        }
        sharedPreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        if (sharedPreferences.contains(secondss)){
            second = sharedPreferences.getInt(secondss,0);
        }
        if (sharedPreferences.contains(runnings)){
            running = sharedPreferences.getBoolean(runnings,true);
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
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(secondss,second);
                editor.putBoolean(runnings,running);
                editor.apply();
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
