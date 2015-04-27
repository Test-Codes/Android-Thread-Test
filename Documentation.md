## Basic Information
- Supports Android API 15 - 22 (no need for support package)
- Using 3 libraries
    - Android Annotation
    - Butterknife
    - Logger
- Color themed after Realm CI
- API 15-20 follows Holo design
- API 21-22 follows Material design

## UI
- Two button at the bottom
    - First
    - Second
- One textview for counter
    - It is at the center of the view below toolbar (or action bar) and above buttons

## Counter

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
    - using SharedPreference which already is thread-safe, not process-safe though
- SQLCounter
    - using SQLite, which is not thread-safe

## Worker

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

There are 6 kinds of counters and 3 kinds of workers. **You can pick one of the counter and one of the worker from _“initializeCounter”_ and _“initializeWorker”_ methods.**

## Android Life Cycle
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

## Why it is thread safe
- All of the method for counter are executed in Main Thread.
- Some of the counter is already thread-safe, so you can use the method in any thread.

## Android Test
- How to run
```
    $./gradlew connectAndroidTest
```
- Testing whether the Counter class is thread-safe
- Some of the counter class is thread-safe and some are not as expected
- There will be 100 thread pool running increment method
- There will be 1000 times increment
- If the value is 1000 after all of the pool is done, it is succeeded.
- For IntegerCounter, AtomicIntegerCounter, SynchronizedMethodCounter, SynchronizedObjectCounter I made is 100000 times of work since the calculation is so fast.

#### Test Result
- PreferenceCounter, SQLCounter, IntegerCounter is not thread-safe
- SQL is know to be not thread-safe, also there were way over database execution, so that the process crashed.
- Shared Preference is know to be thread-safe, but code I wrote on PreferenceCounter wasn't thread-safe. getValue() in the middle makes the code not to be thread-safe.
```
        SharedPreferences.Editor edit = getInstance().edit();
        edit.putInt(COUNTER, getValue() + 1);
        edit.apply();
```
- To make PreferenceCounter to be thread safe, I have to make all the method to be synchronized.
- IntegerCounter is not thread-safe as expected. But the calculation is so fast, usually it won't cause any problem.