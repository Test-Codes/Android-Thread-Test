package com.thefinestartist.realmandroidtest.storage;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by TheFinestArtist on 4/25/15.
 */
public class Preferences {

    private static final String PREF_NAME = "Realm";
    private static final String WORKING_BACKGROUND = "WORKING_BACKGROUND";


    private static SharedPreferences mPref = null;
    private static final Object mSingletonLock = new Object();

    private static SharedPreferences getInstance(Context context) {
        synchronized (mSingletonLock) {
            if (mPref != null)
                return mPref;

            if (context != null) {
                mPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
            }
            return mPref;
        }
    }

    public static boolean isRunning(Context context) {
        return getInstance(context).getBoolean(WORKING_BACKGROUND, false);
    }

    public static void setRunning(Context context, boolean running) {
        SharedPreferences.Editor edit = getInstance(context).edit();
        edit.putBoolean(WORKING_BACKGROUND, running);
        edit.apply();
    }
}
