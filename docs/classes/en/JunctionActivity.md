# Class Description: JunctionActivity

## 1. General Information
*   **Class Name:** `JunctionActivity`
*   **Type:** Activity
*   **Purpose:** This is the "Control Panel" of the app. It allows the user to adjust the mathematical properties (Amplitude, Frequency, Phase) of two different sine waves and see a small preview of them.
*   **Interaction:** Receives no data, but sends user-selected parameters to `ViewResultActivity` via an `Intent`.

## 2. Variables (Class Fields)
| Name | Type | Purpose | Where is it used |
| :--- | :--- | :--- | :--- |
| `seekBarAmplitude1` | `SeekBar` | Slider to control the height of Wave 1. | `setupViews`, `openResultActivity` |
| `textViewFrequency1` | `TextView` | Label to show the numeric value of frequency. | `updateTextViews` |
| `graphView1` | `GraphView` | A custom view that draws Wave 1 preview. | `updateGraph1` |
| `buttonSameAxis` | `Button` | Button to see the result of adding waves on one axis. | `setupListeners` |

*(Note: Similar variables exist for Wave 2 and other parameters like Phase and Frequency).*

## 3. Class Methods

### Method name: `onCreate`
*   **Type:** `protected void`
*   **Detailed Logic:** Sets the layout, calls helper methods to link UI elements (`setupViews`) and define what happens when users move sliders (`setupListeners`).
*   **When called:** When the activity starts after `MainActivity`.

### Method name: `setupListeners`
*   **Type:** `private void`
*   **Detailed Logic:** Creates "Listeners" for the SeekBars. Every time a user moves a slider, the code automatically calls `updateGraph()` and `updateTextViews()`. This creates a "live" feedback effect.
*   **When called:** Once during `onCreate`.

### Method name: `updateGraph1` / `updateGraph2`
*   **Type:** `private void`
*   **Detailed Logic:** Gets the current progress (0-100) from the sliders and tells the `GraphView` to redraw the wave with these new numbers.
*   **When called:** Whenever a slider is moved.

### Method name: `openResultActivity`
*   **Type:** `private void`
*   **Parameters:** `String type` (indicates if we want "Same Axis" or "Perpendicular").
*   **Detailed Logic:** It packs all 6 wave parameters (Amp1, Freq1, Phase1, Amp2, Freq2, Phase2) into an `Intent` (like putting letters in an envelope) and sends it to `ViewResultActivity`.

## 4. Lifecycle
*   **`onCreate()`:** Used to build the UI and prepare the sliders.

## 5. Interface Interaction (UI)
*   **`SeekBar`:** Sliders for user input.
*   **`TextView`:** Displaying current values.
*   **`Button`:** Triggers the transition to the result screen.
*   **`GraphView`:** Shows a mini-preview of the waves.

## 6. Interaction with other components
*   **`Intent`:** Transfers all mathematical data to `ViewResultActivity` using `putExtra()`.

## 7. General Logic
The user moves sliders -> The code detects the change -> The preview graph and text update instantly -> The user clicks a button -> All data is sent to the next screen for the final animation.

## 8. Simplified Explanation
**Analogy:** Think of a **Radio**. `JunctionActivity` is the front panel where you turn knobs to change the station or volume. As you turn them, you see the numbers change on the display. When you are happy, you press "Play" to hear the music on the main speakers.
