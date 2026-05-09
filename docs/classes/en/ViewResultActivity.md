# Class Description: ViewResultActivity

## 1. General Information
*   **Class Name:** `ViewResultActivity`
*   **Type:** Activity
*   **Purpose:** This screen displays the final result of adding the two waves. It shows a large, animated graph based on the parameters chosen in `JunctionActivity`.
*   **Interaction:** Receives data from `JunctionActivity` and uses `GraphView` to draw the result.

## 2. Variables (Class Fields)
| Name | Type | Purpose | Where is it used |
| :--- | :--- | :--- | :--- |
| `graphView` | `GraphView` | The main drawing area where the animation happens. | `onCreate` |

## 3. Class Methods

### Method name: `onCreate`
*   **Detailed Logic:**
    1.  Sets the layout to `activity_view_result.xml`.
    2.  Enables a "Back" button in the top bar.
    3.  Extracts the 6 wave parameters from the `Intent`.
    4.  Calls `graphView.setParameters()` to start the animation.

## 4. Lifecycle
*   **`onCreate()`:** Initializes the final graph.

## 5. Interface Interaction (UI)
*   **`GraphView`:** Occupies most of the screen to show the result.

## 6. Interaction with other components
*   **`Intent`:** Receives the "package" of data sent from `JunctionActivity`.

## 7. General Logic
It simply takes the "recipe" (parameters) it received and hands it to the "cook" (`GraphView`) to prepare the final "dish" (the animated graph).

## 8. Simplified Explanation
**Analogy:** Imagine you designed a custom car in a catalog (`JunctionActivity`). `ViewResultActivity` is the **Showroom** where you actually see the car being built and driving.
