package com.thefinestartist.realmandroidtest.counter;

/**
 * Created by TheFinestArtist on 4/25/15.
 */
public interface Counter {

    public void increment();

    public int getValue();

    public void setValue(int value);

    public void reset();
}
