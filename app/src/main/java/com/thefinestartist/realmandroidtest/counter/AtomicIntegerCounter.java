package com.thefinestartist.realmandroidtest.counter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by TheFinestArtist on 4/25/15.
 */
public class AtomicIntegerCounter implements Counter {

    AtomicInteger value;

    public AtomicIntegerCounter() {
        value = new AtomicInteger();
    }

    @Override
    public void increment() {
        value.incrementAndGet();
    }

    @Override
    public int getValue() {
        return value.intValue();
    }

    @Override
    public void setValue(int value) {
        this.value.set(value);
    }

    @Override
    public void reset() {
        value.set(0);
    }
}
