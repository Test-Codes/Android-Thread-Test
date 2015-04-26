package com.thefinestartist.realmandroidtest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.thefinestartist.realmandroidtest.counter.Counter;
import com.thefinestartist.realmandroidtest.counter.SynchronizedCounter;
import com.thefinestartist.realmandroidtest.storage.Preferences;
import com.thefinestartist.realmandroidtest.worker.TimerWorker;
import com.thefinestartist.realmandroidtest.worker.Worker;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends Activity implements View.OnClickListener, Worker.WorkerListener {

    @InjectView(R.id.counter_tv)
    TextView counterTv;
    @InjectView(R.id.first_bt)
    Button firstBt;
    @InjectView(R.id.second_bt)
    Button secondBt;

    private Counter counter;
    private Worker worker;
    private static final String COUNTER = "COUNTER";

    /**
     * Initializer
     */
    private void initializeCounter() {
//        counter = new IntegerCounter();
//        counter = new AtomicIntegerCounter();
        counter = new SynchronizedCounter();
//        counter = new PreferenceCounter(getApplication());
//        counter = new SQLCounter();
    }

    private void initializeWorker() {
//        worker = new ThreadWorker();
//        worker = new AsyncWorker();
        worker = new TimerWorker();
    }

    /**
     * Android Activity Life Cycle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        initializeCounter();
        initializeWorker();

        counter.reset();

        counterTv.setText(String.valueOf(counter.getValue()));
        firstBt.setOnClickListener(this);
        secondBt.setOnClickListener(this);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        counter.setValue(savedInstanceState.getInt(COUNTER));
        counterTv.setText(String.valueOf(counter.getValue()));
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Preferences.isRunning(getApplicationContext()))
            worker.start(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (Preferences.isRunning(getApplicationContext()))
            worker.stop();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(COUNTER, counter.getValue());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * Listeners
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.first_bt:
                updateCouter();
                break;
            case R.id.second_bt:
                if (!Preferences.isRunning(getApplicationContext())) {
                    worker.start(this);
                    Preferences.setRunning(getApplicationContext(), true);
                } else {
                    worker.stop();
                    Preferences.setRunning(getApplicationContext(), false);
                }
                break;
        }
    }

    @Override
    public void work() {
        updateCouter();
    }

    /**
     * Private Methods
     */
    private void updateCouter() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                counter.increment();
                counterTv.setText(String.valueOf(counter.getValue()));
            }
        });
    }
}
