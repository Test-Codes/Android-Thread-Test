package com.thefinestartist.realmandroidtest.worker;

import android.os.AsyncTask;
import android.os.SystemClock;

/**
 * Created by TheFinestArtist on 4/26/15.
 */
public class AsyncWorker implements Worker {

    private class CounterTask extends AsyncTask<WorkerListener, WorkerListener, Void> {
        @Override
        protected Void doInBackground(WorkerListener... params) {
            SystemClock.sleep(1000);
            while (!isCancelled()) {
                publishProgress(params);
                SystemClock.sleep(1000);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(WorkerListener... values) {
            super.onProgressUpdate(values);
            for (WorkerListener listener : values)
                if (listener != null)
                    listener.work();
        }
    }

    CounterTask task;

    @Override
    public void start(WorkerListener listener) {
        if (!isRunning()) {
            task = new CounterTask();
            task.execute(listener);
        }
    }

    @Override
    public void stop() {
        if (isRunning()) {
            task.cancel(true);
            task = null;
        }
    }

    @Override
    public boolean isRunning() {
        return task != null && !task.isCancelled();
    }
}
