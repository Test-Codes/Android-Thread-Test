package com.thefinestartist.realmandroidtest.counter;

/**
 * Created by TheFinestArtist on 4/25/15.
 */
public class SynchronizedObjectCounter implements Counter {

    int value;
    private final Object sync = new Object();

    @Override
    public void increment() {
        synchronized (sync) {
            value++;
        }
    }

    @Override
    public synchronized int getValue() {
        synchronized (sync) {
            return value;
        }
    }

    @Override
    public synchronized void setValue(int value) {
        synchronized (sync) {
            this.value = value;
        }
    }

    @Override
    public synchronized void reset() {
        synchronized (sync) {
            value = 0;
        }
    }
}
