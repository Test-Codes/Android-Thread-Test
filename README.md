# Realm Android Test

The task is to create a simple app with the requirements described below.


## App description

We would like a single page app with 3 elements: 2 buttons and a text counter. The counter should be centered in the middle of the screen while the two buttons are placed at the bottom next to each other.


## Requirements

- The text counter should be placed in the middle of the screen. It should start at 0.
- When clicking the first button, the counter should increase by 1.
- When clicking the second button, it should start a background thread that updates the counter by 1 every second. Clicking the button again, should stop this background thread.
- It should be possible to rotate the screen between portrait and landscape.
- The app should stop incrementing the counter while being in the background, but it must remember its state if resumed, even if it has been killed.
- TargetSDK is 22, MinSDK is 15.
- The app should have a Material look and feel on Lollipop (SDK 21-22) and a Holo look below (SDK 14 - 19).


# Evaluation

The solution will be evaluated by the following criteria (in prioritized order):

1) Is the solution thread safe? Please document why.
2) Does it respect the Android lifecycle?
3) Does it work across all supported SDK versions
4) Are the code base and XML resources well structured?
5) Are there tests?
6) Does it follow Google design guidelines?

3rd party libraries are allowed, but you must be prepared to defend why they are included and what problem they solve.


# TODO
- Update Target SDK version to 22
- Volatile, Translucent(?)
- Atomic
- final for variable, method, class
- Race condition
- garbage collector for java and android
- synchronize method
- cocurrenthashmap


## 3rd Party libraries
- Butterknife