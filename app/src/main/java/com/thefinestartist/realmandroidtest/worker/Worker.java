package com.thefinestartist.realmandroidtest.worker;

/**
 * Created by TheFinestArtist on 4/25/15.
 */
public interface Worker {

    public interface WorkerListener {
        public void work();
    }

    public void start(WorkerListener listener);

    public void stop();

    public boolean isRunning();
}
