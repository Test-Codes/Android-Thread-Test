package com.thefinestartist.realmandroidtest.counter;

/**
 * Created by TheFinestArtist on 4/25/15.
 */
public class IntegerCounter implements Counter {

    int value;

    @Override
    public void increment() {
        value++;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public void reset() {
        value = 0;
    }
}
