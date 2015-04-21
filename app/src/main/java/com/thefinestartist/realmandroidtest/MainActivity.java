package com.thefinestartist.realmandroidtest;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends ActionBarActivity {

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
