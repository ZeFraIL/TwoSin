# Class Description: MainActivity

## 1. General Information
*   **Class Name:** `MainActivity`
*   **Type:** Activity
*   **Purpose:** This class serves as the entry point of the application. It displays a "Splash Screen" (a welcoming screen) that plays a short introductory video before moving the user to the main settings screen.
*   **Interaction:** It starts the application life cycle and transitions to `JunctionActivity` after a set delay or when the video ends.

## 2. Variables (Class Fields)
| Name | Type | Purpose | Where is it used |
| :--- | :--- | :--- | :--- |
| `SPLASH_DELAY` | `int` (static final) | Stores the duration (4000ms = 4 seconds) to wait before automatically switching screens. | `onCreate` |
| `activityStarted` | `boolean` | A "flag" (check) to ensure we don't start the next screen twice (e.g., if video ends and timer triggers at the same time). | `startJunctionActivity` |

## 3. Class Methods

### Method name: `onCreate`
*   **Type:** `protected`
*   **Return value:** `void` (returns nothing)
*   **Parameters:** `Bundle savedInstanceState` (Standard Android object used to restore activity state).
*   **Detailed Logic:**
    1.  Calls `super.onCreate` to perform standard setup.
    2.  Enables `EdgeToEdge` mode (making the app content go behind the status/navigation bars for a modern look).
    3.  Sets the visual layout from `activity_main.xml`.
    4.  Initializes a `VideoView` to play the `twosin` video from the `raw` resources folder.
    5.  Sets up a listener: if the video finishes, call `startJunctionActivity`.
    6.  Starts a timer (`Handler`) that will call `startJunctionActivity` after 4 seconds regardless.
*   **When called:** Automatically by the Android system when the app is first launched.

### Method name: `startJunctionActivity`
*   **Type:** `private`
*   **Return value:** `void`
*   **Parameters:** None
*   **Detailed Logic:**
    1.  Checks if `activityStarted` is `false`.
    2.  If false, sets it to `true`.
    3.  Creates an `Intent` (a message to the system) to open `JunctionActivity`.
    4.  Starts the new Activity and calls `finish()` (this closes `MainActivity` so the user can't go back to the splash screen).
*   **When called:** When the video ends or when the 4-second timer expires.

## 4. Lifecycle
*   **`onCreate()`:** Called when the Activity starts. Here, we set up the video and the timer.
*   **`onDestroy()` (Implicit):** When `finish()` is called, the Activity is destroyed to free up memory.

## 5. Interface Interaction (UI)
*   **`VideoView`:** Used to play the intro animation. Linked via `findViewById(R.id.videoView)`.
*   **`RainbowTextView`:** A custom text view that shows a colorful title.

## 6. Interaction with other components
*   **`Intent`:** Used to transition from `MainActivity` to `JunctionActivity`.

## 7. General Logic
When you open the app, `MainActivity` pops up, plays a video for a few seconds, and then quickly "hands over" the control to `JunctionActivity` while closing itself.

## 8. Simplified Explanation
**Analogy:** Imagine entering a cinema. `MainActivity` is like the "Intro/Logo" shown on the screen while you find your seat. After a few seconds, the actual movie (the main app) starts, and the logo disappears.
