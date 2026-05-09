# Class Description: GraphView

## 1. General Information
*   **Class Name:** `GraphView`
*   **Type:** Custom View (Extends `View`)
*   **Purpose:** This is the "Brain" and "Canvas" of the application. It handles the complex math of sine waves and Lissajous figures and draws them on the screen pixel by pixel.
*   **Interaction:** It is used inside `JunctionActivity` for previews and `ViewResultActivity` for the final result.

## 2. Variables (Class Fields)
| Name | Type | Purpose | Where is it used |
| :--- | :--- | :--- | :--- |
| `paint` | `Paint` | The "pen" or "brush" used to draw the red wave. | `init`, `onDraw` |
| `axisPaint` | `Paint` | The "pencil" used to draw the black coordinate axes (X and Y). | `init`, `onDraw` |
| `animator` | `ValueAnimator` | A timer that changes a value from 0 to 1 over 10 seconds to animate the drawing process. | `init`, `setParameters` |
| `amp1`, `freq1`... | `float` | Store the mathematical properties of the waves. | `onDraw`, `setParameters` |

## 3. Class Methods

### Method name: `init`
*   **Type:** `private void`
*   **Detailed Logic:** Configures the colors and thicknesses of the "brushes" (`Paint`) and prepares the `ValueAnimator`.
*   **When called:** When the object is first created.

### Method name: `setParameters`
*   **Type:** `public void`
*   **Parameters:** `String type`, and 6 integers for wave properties.
*   **Detailed Logic:**
    1.  Converts "integer" progress from sliders into "float" math values (e.g., degree to radians).
    2.  Resets the animation timer (`animator`).
    3.  Starts the animation.
*   **When called:** When we want to start a new drawing.

### Method name: `onDraw`
*   **Type:** `protected void`
*   **Parameters:** `Canvas canvas` (The virtual paper).
*   **Detailed Logic:**
    1.  **Draw Axes:** Draws the vertical and horizontal lines.
    2.  **Calculate & Draw Wave:**
        *   If `type` is "same_axis": It calculates the sum of two sine functions: `y = sin(x1) + sin(x2)` for every pixel on the screen.
        *   If `type` is "perpendicular": It calculates a "Lissajous figure" where one wave moves the "pen" Left-Right and the other moves it Up-Down.
    3.  **Animate:** It only draws up to the current `animatorValue` (e.g., if the timer is at 50%, only half the graph is drawn).
*   **When called:** Automatically by Android whenever the screen needs a "refresh".

## 4. Lifecycle (Custom View)
*   **`onDraw()`:** The main event. Called repeatedly during animation.
*   **`onDetachedFromWindow()`:** Called when the view is removed. We stop the animation here to save battery.

## 5. Interface Interaction (UI)
This is a purely graphical component. It doesn't have buttons, but it responds to commands from the Activities.

## 6. Interaction with other components
Receives data from `JunctionActivity` or `ViewResultActivity` via the `setParameters` method.

## 7. General Logic
It takes numbers (parameters) -> converts them to coordinates using trigonometry (`Math.sin`) -> connects points with lines on a `Canvas`.

## 8. Simplified Explanation
**Analogy:** It's like a **Robotic Artist**. The Activities give it "Instructions" (how big and fast to move the hand), and `GraphView` moves the pen across the paper, drawing the line exactly as instructed, one millimeter at a time.
