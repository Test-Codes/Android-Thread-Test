package com.thefinestartist.realmandroidtest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends Activity {

    @InjectView(R.id.counter_tv)
    TextView counterTv;
    @InjectView(R.id.first_bt)
    Button firstBt;
    @InjectView(R.id.second_bt)
    Button secondBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }
}
