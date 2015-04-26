package com.thefinestartist.realmandroidtest.worker;

import android.os.SystemClock;

/**
 * Created by TheFinestArtist on 4/25/15.
 */
public class ThreadWorker implements Worker {

    private Thread thread;

    @Override
    public void start(final WorkerListener listener) {
        if (!isRunning()) {
            thread = new Thread() {
                @Override
                public void run() {
                    SystemClock.sleep(1000);
                    while (isRunning()) {
                        if (listener != null)
                            listener.work();
                        SystemClock.sleep(1000);
                    }
                }
            };
            thread.start();
        }
    }

    @Override
    public void stop() {
        if (isRunning()) {
            thread.interrupt();
            thread = null;
        }
    }

    @Override
    public boolean isRunning() {
        return thread != null && !thread.isInterrupted();
    }
}
