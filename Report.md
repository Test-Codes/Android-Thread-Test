#### Android Process & Thread
- http://developer.android.com/guide/components/processes-and-threads.html
- 1 Process & 1 Thread when start application
- You can set up process for activity, service, receiver, provider using android:process in manifest
- application for default process value
- Process Lifecycle & Importance
    - Foreground
    - Visible
    - Service
    - Background
    - Empty
- Method that run in system callback always run in “UI Thread"
- "UI Thread” block more that 5 second will cause ANR (Application Not Responding) dialog.
- Android UI Toolkit is not thread safe
    - Do not block the UI Thread
    - Do not access Android UI Components outside the UI Thread
- Accessing UI Thread from other thread
    - Activity.runOnUiThread(Runnable)
    - View.post(Runnable)
    - View.postDelayed(Runnable, long)
- Using Thread can cause the code complicated, consider using Handler or AsyncTask

#### Android Activity Life Cycle
- http://developer.android.com/guide/components/activities.html#SavingActivityState
- http://developer.android.com/training/basics/activity-lifecycle/recreating.html

#### Varargs (Variable number of arguments)
- http://docs.oracle.com/javase/1.5.0/docs/guide/language/varargs.html
- Method that took arbitrary number of argument, varargs features automate and hide the process
- It is upward compatible with preexisting APIs
- String.format(String format, Object… args)

#### Autoboxing
- http://docs.oracle.com/javase/1.5.0/docs/guide/language/autoboxing.html
- Automating process to cast between primitive value and appropriate wrapper class

#### Final (JAVA)
- http://en.wikipedia.org/wiki/Final_(Java)
- Final Classes
    - Final class can not be subclassed
    - Grant security and efficiency benefits
    - Many of JAVA standard libraries are final
    - Method inside final class implicitly work like final method
- Final Methods
    - Cannot be overridden or hidden by subclasses
    - Prevent unexpected behaviour of subclass
    - Final method has nothing to do with efficiency or performance issue
- Final Variables
    - http://docs.oracle.com/javase/specs/jls/se7/html/jls-8.html#jls-8.3.1.2
    - Can only be initialized once
        - via initializer
        - via constructor
    - Blank final instance variable must be definitely assigned at the end of every constructor

#### Annotation
- http://en.wikipedia.org/wiki/Java_annotation
- https://docs.oracle.com/javase/tutorial/java/annotations/
- Form of syntactic metadata that can be added java code.
    - Classes
    - Methods
    - Variables
    - Parameters
    - Packages

#### Javadoc
- http://en.wikipedia.org/wiki/Javadoc
- Document generator from Oracle

#### Thread Safety
- http://en.wikipedia.org/wiki/Thread_safety
- A code is thread safe if it only manipulates shared data structure in a manner that guarantees safe execution by multiple thread at the same time
- Thread Safe
    - Implementation is guaranteed to be free of race conditions when accessed by multiple thread simultaneously
- Conditionally Safe
    - Different thread can access different objects simultaneously, and access of shared data is protected from race condition
- Not Thread Safe
    - Code should not accessed simultaneously by different thread

#### Race Condition
- http://en.wikipedia.org/wiki/Race_condition#Computing
- A behaviour of electronic, software or other system where the output is dependent on the sequence or timing of other uncontrollable events
- Two signal racing each other to influence the output first
- Critical race condition often happens when processes or threads depend on the shared state

#### Dead Lock
- http://en.wikipedia.org/wiki/Deadlock
- A situation in which two or more competing actions are each waiting for the other to finish, and thus neither ever does

#### Difference Between Atomic, Volatile, Synchronize
- http://stackoverflow.com/questions/9749746/what-is-the-difference-of-atomic-volatile-synchronize

#### Java Synchronized Analysis
- http://egloos.zum.com/iilii/v/4071694

#### Atomic Variable
- https://docs.oracle.com/javase/tutorial/essential/concurrency/atomicvars.html

#### Android Background Process Tutorial
- http://www.vogella.com/tutorials/AndroidBackgroundProcessing/article.html
- http://arabiannight.tistory.com/344
- http://arabiannight.tistory.com/entry/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9CAndroid-Thread-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0
- http://arabiannight.tistory.com/entry/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9CAndroid-Timer-%EC%99%80-TimerTask%EB%A5%BC-%ED%99%9C%EC%9A%A9%ED%95%9C-IntroActivity-%EA%B5%AC%EC%84%B1
- http://arabiannight.tistory.com/entry/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9CAndroid-AsyncTask-%EC%82%AC%EC%9A%A9%EB%B2%95
- http://arabiannight.tistory.com/entry/356

#### Synchronized Method
- https://docs.oracle.com/javase/tutorial/essential/concurrency/syncmeth.html
- It is not possible for two invocations of synchronized methods on the same object to interleave.
- Changes of the state of the objects are visible to all threads

#### Thread Pooling
- http://en.wikipedia.org/wiki/Thread_pool_pattern
- Creating number of threads to perform number of tasks.
- When a thread done a task, it request next task until all the tasks are done.
- After all the tasks are done, thread can be either terminated or wait for new tasks.

#### Handler, Looper, Message, Queue
- http://codetheory.in/android-handlers-runnables-loopers-messagequeue-handlerthread/

#### iOS strong, retain, atomic, non-atimic
- http://www.quora.com/What-is-the-difference-between-strong-retain-nonatomic-etc-in-the-Objective-C-iOS-property
- Atomic
    - Atomic object is thread safe
    - Slow in performance
    - Default in iOS
- Non-Atomic
    - Non-atomic object is not thread safe
    - Fast in performance

#### Android SQLite Tutorial
- http://www.vogella.com/tutorials/AndroidSQLite/article.html
- SQLite Database is not thread safe
- http://touchlabblog.tumblr.com/post/24474398246/android-sqlite-locking

#### Volatile
- http://en.wikipedia.org/wiki/Volatile_(computer_programming)
- http://www.javamex.com/tutorials/synchronization_volatile.shtml
- When variable's value will modified by different threads
- Access of the variable acts as though it is enclosed in synchronized block (synchronised on itself)

#### Volatile in Java 5
- http://www.javamex.com/tutorials/synchronization_volatile_java_5.shtml
- Accessing volatile variable creates memory barrier
- Synchronize all cached copies of variables with main memory
 
#### Volatile
- http://stackoverflow.com/questions/19744508/volatile-vs-atomic
- int, long, double is not atomic and all other primitive variables are already atomic

#### The volatile keyword is used:
- to make non atomic 64-bit operations atomic: long and double. (all other, primitive accesses are already guaranteed to be atomic!)
- to make variable updates guaranteed to be seen by other threads + visibility effects: after writing to a volatile variable, all the variables that where visible before writing that variable become visible to another thread after reading the same volatile variable (happen-before ordering).


#### Transient
- http://en.wikibooks.org/wiki/Java_Programming/Keywords/transient
- member variable not to be serialized when it persist to stream of bytes
- Not transferred over network, lost intentionally
- http://stackoverflow.com/questions/910374/why-does-java-have-transient-variables

#### Native
- The native keyword is applied to a method to indicate that the method is implemented in native code using JNI(Java Native Interface).
- http://stackoverflow.com/questions/6101311/what-is-the-native-keyword-in-java-for

#### Generic programming
- Style of computer programming in which algorithms are written in terms of types to-be-specified-later that are then instantiated when needed for specific types provided as parameters
- http://en.wikipedia.org/wiki/Generic_programming
 
#### Covariant return type
- Covariant return type of a method is one that can be replaced by a "narrower" type when the method is overridden in a subclass
- http://en.wikipedia.org/wiki/Covariant_return_type

#### Android Testing
- https://developer.android.com/tools/testing/testing_android.html
- http://www.vogella.com/tutorials/JUnit/article.html
- https://www.youtube.com/watch?v=z47B1nhC3K0

#### More to Read
- https://docs.oracle.com/javase/tutorial/essential/concurrency/index.html
- http://en.wikipedia.org/wiki/Happened-before
- http://en.wikipedia.org/wiki/Synchronization_(computer_science)
- http://en.wikipedia.org/wiki/Critical_section
- http://www.oracle.com/technetwork/articles/java/javaserial-1536170.html
