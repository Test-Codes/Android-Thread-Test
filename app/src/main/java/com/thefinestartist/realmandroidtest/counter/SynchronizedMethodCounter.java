package com.thefinestartist.realmandroidtest.counter;

/**
 * Created by TheFinestArtist on 4/25/15.
 */
public class SynchronizedMethodCounter implements Counter {

    int value;

    @Override
    public synchronized void increment() {
        value++;
    }

    @Override
    public synchronized int getValue() {
        return value;
    }

    @Override
    public synchronized void setValue(int value) {
        this.value = value;
    }

    @Override
    public synchronized void reset() {
        value = 0;
    }
}
