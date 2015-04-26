package com.thefinestartist.realmandroidtest.counter;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by TheFinestArtist on 4/25/15.
 */
public class PreferenceCounter implements Counter {

    private static final String PREF_NAME = "Realm";
    private static final String COUNTER = "COUNTER";

    private Context context;

    public PreferenceCounter(Context ctx) {
        this.context = ctx;
    }

    public SharedPreferences getInstance() {
        if (context == null)
            return null;

        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public void increment() {
        SharedPreferences pref = getInstance();
        if (pref == null)
            return;

        SharedPreferences.Editor edit = getInstance().edit();
        edit.putInt(COUNTER, getValue() + 1);
        edit.apply();
    }

    @Override
    public int getValue() {
        SharedPreferences pref = getInstance();
        if (pref == null)
            return 0;

        return pref.getInt(COUNTER, 0);
    }

    @Override
    public void setValue(int value) {
        SharedPreferences pref = getInstance();
        if (pref == null)
            return;

        SharedPreferences.Editor edit = getInstance().edit();
        edit.putInt(COUNTER, value);
        edit.apply();
    }

    @Override
    public void reset() {
        SharedPreferences pref = getInstance();
        if (pref == null)
            return;

        SharedPreferences.Editor edit = getInstance().edit();
        edit.putInt(COUNTER, 0);
        edit.apply();
    }
}
