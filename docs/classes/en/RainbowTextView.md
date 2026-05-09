# Class Description: RainbowTextView

## 1. General Information
*   **Class Name:** `RainbowTextView`
*   **Type:** Custom Class (Extends `AppCompatTextView`)
*   **Purpose:** A special type of text field that automatically colors its text with a rainbow gradient.
*   **Interaction:** Used in XML layouts just like a normal `TextView`.

## 2. Variables
No special class fields are defined; it uses internal logic during layout.

## 3. Class Methods

### Method name: `onLayout`
*   **Detailed Logic:**
    1.  Called when Android decides where to place the text on the screen.
    2.  It creates a `LinearGradient` (a smooth transition of colors: Red, Yellow, Green, Blue, Magenta).
    3.  Applies this gradient to the "paint" of the text.
*   **When called:** When the view is first displayed or resized.

## 4. Simplified Explanation
**Analogy:** It's like a **Magic Marker**. Instead of writing in one color, it automatically applies a rainbow pattern across every word you write with it.
