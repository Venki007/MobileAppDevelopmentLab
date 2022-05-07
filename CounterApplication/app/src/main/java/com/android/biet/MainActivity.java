package com.android.biet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean isCounterRunning = false;
    int counter = 0;
    TextView countText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countText = findViewById(R.id.counter_text);
        countText.setText(Integer.toString(counter));
    }

    public void start(View view) {
        if(!isCounterRunning)
        {
            isCounterRunning = true;
            startTimerThread();
        }
    }

    public void pause(View view) {
        isCounterRunning = false;
    }

    public void reset(View view) {
        isCounterRunning = false;
        counter = 0;
        countText.setText(Integer.toString(counter));
    }

    private void startTimerThread() {
        Handler handler = new Handler();
        Runnable runnable = () -> {
            while (isCounterRunning) {
                counter++;
                handler.post(() -> countText.setText(Integer.toString(counter)));
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(runnable).start();
    }
}

