# Tasks

## Email

Following your interview last week, we would like you to complete the following coding exercise.
We are sending you this exercise to evaluate if you can improve your understanding of concurrency.
Showing us what you learned (and maybe telling us how you learned it) will be very important.

## Realm Android Test

The task is to create a simple app with the requirements described below.


### App description

(done) We would like a single page app with 3 elements: 2 buttons and a text counter. The counter should be centered in the middle of the screen while the two buttons are placed at the bottom next to each other.


### Requirements

- (done) The text counter should be placed in the middle of the screen. It should start at 0.
- When clicking the first button, the counter should increase by 1.
- When clicking the second button, it should start a background thread that updates the counter by 1 every second. Clicking the button again, should stop this background thread.
- It should be possible to rotate the screen between portrait and landscape.
- The app should stop incrementing the counter while being in the background, but it must remember its state if resumed, even if it has been killed.
- (done) TargetSDK is 22, MinSDK is 15.
- (done) The app should have a Material look and feel on Lollipop (SDK 21-22) and a Holo look below (SDK 14 - 19).


## Evaluation

The solution will be evaluated by the following criteria (in prioritized order):

1) Is the solution thread safe? Please document why.

2) Does it respect the Android lifecycle?

3) Does it work across all supported SDK versions

4) Are the code base and XML resources well structured?

5) Are there tests?

6) Does it follow Google design guidelines?

3rd party libraries are allowed, but you must be prepared to defend why they are included and what problem they solve.


## More
- Volatile, Translucent(?)
- Atomic
- final for variable, method, class
- Race condition
- garbage collector for java and android
- synchronize method
- cocurrenthashmap


# Description

## 3rd Party libraries
- Butterknife
    Automatically inject views in layout to corresponding object using @Injectview annotation.
    Helps to reduce code line and increase code readability.

## Reference
- http://realm.io/ for Corporate Identity Colors
- http://android-holo-colors.com/ for holo style button generation
- http://jakewharton.github.io/butterknife/ for view injection