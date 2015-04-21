package com.thefinestartist.realmandroidtest;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends Activity implements View.OnClickListener {

    @InjectView(R.id.counter_tv)
    TextView counterTv;
    @InjectView(R.id.first_bt)
    Button firstBt;
    @InjectView(R.id.second_bt)
    Button secondBt;

    Thread counterThread;
    boolean isThreadRunning = false;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        counterTv.setText(String.valueOf(count));
        firstBt.setOnClickListener(this);
        secondBt.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isThreadRunning)
            toggleThread();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isThreadRunning)
            toggleThread();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // When clicking the first button, the counter should increase by 1.
            case R.id.first_bt:
                updateCouter();
                break;
            // When clicking the second button, it should start a background thread that updates the counter by 1 every second. Clicking the button again, should stop this background thread.
            case R.id.second_bt:
                toggleThread();
                break;
        }
    }

    /**
     * Private Methods
     */
    private void updateCouter() {
        count++;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                counterTv.setText(String.valueOf(count));
            }
        });
    }

    private void toggleThread() {
        if (counterThread == null) {
            counterThread = new Thread() {
                @Override
                public void run() {
                    while (true) {
                        updateCouter();
                        SystemClock.sleep(1000);
                    }
                }
            };
            counterThread.start();
            isThreadRunning = true;
        } else {
            counterThread.interrupt();
            counterThread = null;
            isThreadRunning = false;
        }
    }
}
