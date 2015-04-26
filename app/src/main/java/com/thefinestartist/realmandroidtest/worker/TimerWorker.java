package com.thefinestartist.realmandroidtest.worker;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by TheFinestArtist on 4/26/15.
 */
public class TimerWorker implements Worker {

    Timer timer;

    @Override
    public void start(final WorkerListener listener) {
        if (!isRunning()) {
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    if (listener != null)
                        listener.work();
                }
            }, 1000, 1000);
        }
    }

    @Override
    public void stop() {
        if (isRunning()) {
            timer.cancel();
            timer = null;
        }
    }

    @Override
    public boolean isRunning() {
        return timer != null;
    }
}
