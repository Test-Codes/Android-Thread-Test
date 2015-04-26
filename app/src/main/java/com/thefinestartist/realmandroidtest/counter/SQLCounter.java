package com.thefinestartist.realmandroidtest.counter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by TheFinestArtist on 4/25/15.
 */
public class SQLCounter implements Counter {

    private static SQLiteHelper SQLiteHelper;
    private Context context;

    public SQLCounter(Context ctx) {
        this.context = ctx;
    }

    private SQLiteHelper getInstance() {
        if (context == null)
            return null;

        if (SQLiteHelper == null)
            SQLiteHelper = new SQLiteHelper(context);

        return SQLiteHelper;
    }

    public class SQLiteHelper extends SQLiteOpenHelper {

        private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_NAME = "Realm";
        private static final String KEY_COUNTER = "counter";
        private static final String TABLE_NAME_COUNTER = "COUNTER";
        private static final String TABLE_CREATE_COUNTER = "CREATE TABLE " + TABLE_NAME_COUNTER + " (" + KEY_COUNTER + " Integer DEFAULT 0);";
        private static final String TABLE_INCREMENT_COUNTER = "UPDATE " + TABLE_NAME_COUNTER + " SET " + KEY_COUNTER + " = " + KEY_COUNTER + " + 1;";

        SQLiteHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(TABLE_CREATE_COUNTER);

            ContentValues values = new ContentValues();
            values.put(KEY_COUNTER, 0);
            db.insert(TABLE_NAME_COUNTER, null, values);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }

        public int getCounter() {
            String query = "SELECT  * FROM " + TABLE_NAME_COUNTER;
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor;
            if (db != null) {
                cursor = db.rawQuery(query, null);
                if (cursor.moveToFirst()) {
                    do {
                        return cursor.getInt(0);
                    } while (cursor.moveToNext());
                }
            }
            return 0;
        }

        public void setCounter(int value) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(KEY_COUNTER, value);
            if (db != null) {
                db.update(TABLE_NAME_COUNTER, values, null, null);
                db.close();
            }
        }

        public void incrementCounter() {
            SQLiteDatabase db = this.getWritableDatabase();
            if (db != null) {
                db.execSQL(TABLE_INCREMENT_COUNTER);
                db.close();
            }

        }
    }

    @Override
    public void increment() {
        SQLiteHelper helper = getInstance();
        if (helper == null)
            return;

        helper.incrementCounter();
    }

    @Override
    public int getValue() {
        SQLiteHelper helper = getInstance();
        if (helper == null)
            return 0;

        return helper.getCounter();
    }

    @Override
    public void setValue(int value) {
        SQLiteHelper helper = getInstance();
        if (helper == null)
            return;

        helper.setCounter(value);
    }

    @Override
    public void reset() {
        SQLiteHelper helper = getInstance();
        if (helper == null)
            return;

        helper.setCounter(0);
    }
}
