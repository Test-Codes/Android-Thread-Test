#### Basic Information
- Supports Android API 15 - 22 (no need for support package)
- Using 3 libraries
    - Android Annotation
    - Butterknife
    - Logger
- Color themed after Realm CI
- API 15-20 follows Holo design
- API 21-22 follows Material design

#### UI
- Two button at the bottom
    - First
    - Second
- One textview for counter
    - It is at the center of the view below toolbar (or action bar) and above buttons

#### Counter Policy
- Keep the value if the app is rotated
- Keep the value if the app is in background
- Reset the value if the app is killed

#### Counter Interface
     public void increment();
     public int getValue();
     public void setValue(int value);
     public void reset();

#### Counters
- IntegerCounter
    - using primitive int value, which is not-thread safe
- AtomicIntegerCounter
    - using AtomicInteger which already is thread-safe
- SynchronizedMethodCounter
    - using primitive int value, but all the methods are synchronized
- SynchronizedObjectCounter
    - using primitive int value, but all the codes in the method are synchronized
- PreferenceCounter
    - using SharedPreference which already is thread-safe
- SQLCounter
    - using SQLite, which is not thread-safe

#### Worker Policy
- Toggle worker if the second button is pressed
- Stop worker is the app is in background, start back if the app came back to foreground
- It the worker was running, re-create the worker when the app is created again
- If the worker was running, re-create the worker if the app is rotated (the consumed time won’t be reserved)

#### Worker Interface
     public void start(WorkerListener listener);
     public void stop();
     public boolean isRunning();

#### WorkerListener
- Send event to increase counter value by one
```
     public interface WorkerListener {
          public void work();
     }
```

#### Workers
- ThreadWorker
- Using thread
- AsyncWorker
- Using AsyncTask
- TimerWorker
- Using Timer

There are 6 kinds of counters and 3 kinds of workers. You can pick one of the counter and one of the worker from “initializeCounter” and “initializeWorker” methods.

#### Android Life Cycle
- Activity Created
    - onCreate
    - onResume
    - onPause
    - onDestroy
- Device Rotation
    - onPause
    - onSaveInstanceState
    - onDestroy
    - onCreate
    - onRestoreInstanceState
    - onResume

#### Why it is thread safe
- All of the method for counter are executed in Main Thread.
- Some of the counter is already thread-safe, so you can use the method in any thread.