package com.thefinestartist.realmandroidtest;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.MediumTest;

/**
 * Created by TheFinestArtist on 4/27/15.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    MainActivity activity;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.activity = getActivity();
    }

    @MediumTest
    public void testTextViewNotNull() {
        assertNotNull(activity.findViewById(R.id.counter_tv));
    }

    @MediumTest
    public void testButtonFirstNotNull() {
        assertNotNull(activity.findViewById(R.id.first_bt));
    }

    @MediumTest
    public void testButtonSecondNotNull() {
        assertNotNull(activity.findViewById(R.id.second_bt));
    }
}
