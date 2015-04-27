package com.thefinestartist.realmandroidtest;

import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.LargeTest;

import com.orhanobut.logger.Logger;
import com.thefinestartist.realmandroidtest.counter.AtomicIntegerCounter;
import com.thefinestartist.realmandroidtest.counter.Counter;
import com.thefinestartist.realmandroidtest.counter.IntegerCounter;
import com.thefinestartist.realmandroidtest.counter.PreferenceCounter;
import com.thefinestartist.realmandroidtest.counter.SQLCounter;
import com.thefinestartist.realmandroidtest.counter.SynchronizedMethodCounter;
import com.thefinestartist.realmandroidtest.counter.SynchronizedObjectCounter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by TheFinestArtist on 4/27/15.
 */
public class CounterTest extends AndroidTestCase {

    ExecutorService executor;

    public class Worker implements Runnable {

        private Counter counter;

        public Worker(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            counter.increment();
        }
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        executor = Executors.newFixedThreadPool(100);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @LargeTest
    public void testInteger() {
        Counter counter = new IntegerCounter();

        for (int i = 0; i < 1000000; i++) {
            Runnable worker = new Worker(counter);
            executor.execute(worker);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        Logger.e("Terminated : " + executor.isTerminated() + ", Counter : " + counter.getValue());
        assertEquals(1000000, counter.getValue());
    }

    @LargeTest
    public void testAtomicInteger() {
        Counter counter = new AtomicIntegerCounter();

        for (int i = 0; i < 1000000; i++) {
            Runnable worker = new Worker(counter);
            executor.execute(worker);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        Logger.e("Terminated : " + executor.isTerminated() + ", Counter : " + counter.getValue());
        assertEquals(1000000, counter.getValue());
    }

    @LargeTest
    public void testMethod() {
        Counter counter = new SynchronizedMethodCounter();

        for (int i = 0; i < 1000000; i++) {
            Runnable worker = new Worker(counter);
            executor.execute(worker);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        Logger.e("Terminated : " + executor.isTerminated() + ", Counter : " + counter.getValue());
        assertEquals(1000000, counter.getValue());
    }

    @LargeTest
    public void testObject() {
        Counter counter = new SynchronizedObjectCounter();

        for (int i = 0; i < 1000000; i++) {
            Runnable worker = new Worker(counter);
            executor.execute(worker);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        Logger.e("Terminated : " + executor.isTerminated() + ", Counter : " + counter.getValue());
        assertEquals(1000000, counter.getValue());
    }

    @LargeTest
    public void testPreference() {
        Counter counter = new PreferenceCounter(getContext());

        for (int i = 0; i < 1000; i++) {
            Runnable worker = new Worker(counter);
            executor.execute(worker);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        Logger.e("Terminated : " + executor.isTerminated() + ", Counter : " + counter.getValue());
        assertEquals(1000, counter.getValue());
    }

    @LargeTest
    public void testSQL() {
        Counter counter = new SQLCounter(getContext());

        for (int i = 0; i < 1000; i++) {
            Runnable worker = new Worker(counter);
            executor.execute(worker);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        Logger.e("Terminated : " + executor.isTerminated() + ", Counter : " + counter.getValue());
        assertEquals(1000, counter.getValue());
    }
}
