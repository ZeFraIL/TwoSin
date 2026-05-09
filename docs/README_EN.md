# 📱 Android Application Documentation: TwoSin
________________________________________
🧾 General Information
**Project Name:**
TwoSin
**Author(s):**
Zeev Fraiman
**Date:**
May 2024
**Language:**
Java
**Development Environment:**
Android Studio
**Android Version (minSdk / targetSdk):**
28 / 36
________________________________________
🎯 Project Purpose
•	The application visualizes the mathematical addition of two sinusoidal oscillations.
•	This is a crucial concept in physics and signal processing (superposition and Lissajous curves).
•	Target audience: Students, teachers, and science enthusiasts.
________________________________________
📌 Application Requirements
**Functional Requirements**
•	Animated splash screen with video.
•	Interactive adjustment of Sine Wave 1 and 2 (Amplitude, Frequency, Phase).
•	Real-time preview of individual waves.
•	Two visualization modes: Superposition (Same axis) and Lissajous figures (Perpendicular axes).
•	Smooth animation of the drawing process.

**Non-functional Requirements**
•	Performance: High-speed rendering on Canvas.
•	Usability: One-screen configuration for simplicity.
•	Reliability: Memory-safe handling of animations.
________________________________________
🧠 General Architecture
•	**Approach:**
–	MVC (Model-View-Controller).
•	**Why chosen:**
–	Provides a clear separation between mathematical logic (Model), Custom View (View), and Activity flow (Controller).
•	**Main components:**
–	`MainActivity`: Splash screen logic.
–	`JunctionActivity`: Parameter input and preview.
–	`ViewResultActivity`: Result visualization.
–	`GraphView`: Math engine and rendering.
________________________________________
🧩 UML Diagram
[MainActivity] –> [JunctionActivity]
[JunctionActivity] –> [ViewResultActivity]
[ViewResultActivity] –> [GraphView]
________________________________________
**Structure Explanation:**
- Logic is centralized in `GraphView` to ensure consistency between previews and final results.
- Separation of activities allows for clear state management using Intent extras.
________________________________________
🧩 Detailed Class Description
📌 **Class: MainActivity**
**Role:**
Entry point and brand presentation.
**Responsibility:**
Playing intro video and transitioning to the main UI.
**Main methods:**
- `onCreate()`: Video initialization.
- `startJunctionActivity()`: Controlled transition logic.

📌 **Class: JunctionActivity**
**Role:**
Configuration interface.
**Responsibility:**
Capturing user input via SeekBars and providing instant visual feedback.
**Main methods:**
- `setupListeners()`: Reactive UI updates.
- `updateTextViews()`: Data synchronization.

📌 **Class: GraphView**
**Role:**
Core rendering engine.
**Responsibility:**
Drawing coordinate systems, calculating sine functions, and animating paths.
**Main methods:**
- `setParameters()`: Configuration update and animator restart.
- `onDraw()`: Frame-by-frame rendering.
________________________________________
🔄 Application Flow
1. User sees the logo and intro video.
2. User manipulates sliders to change wave properties.
3. User selects the type of addition.
4. The app draws the resulting trajectory step-by-step.
________________________________________
🎨 UI/UX Analysis
•	The design prioritizes clarity and immediate feedback.
•	**Principles used:**
–	Simplicity: Essential controls only.
–	Logic: Top-to-bottom configuration flow.
–	Feedback: Real-time graph updates.
•	**Improvements:** Adding numeric input fields for precise values.
________________________________________
⚙️ Threading
**Used:**
- `ValueAnimator`: Handles timing for smooth UI updates.
- `Handler`: Used for delayed transition in splash screen.
•	**Prevention:**
–	No heavy operations on UI thread; math is optimized for O(1) per point.
–	Memory leaks prevented by cancelling animators on view detachment.
________________________________________
💾 Data Management
•	**Method:** Intent Extras.
•	**Why:** Efficient for passing small sets of primitive parameters between screens.
________________________________________
🌐 Networking
•	No internet connection required.
________________________________________
🔐 Security
•	No personal data collected.
________________________________________
🧪 Testing
•	Manual verification of mathematical accuracy against known Lissajous patterns.
•	Lifecycle testing (rotation, backgrounding).
________________________________________
🐞 Error Handling
•	Default parameter initialization to prevent crashes on null intents.
•	SeekBar bounds prevent invalid mathematical values.
________________________________________
⚡ Performance
•	Optimization: Points are calculated on-the-fly during `onDraw` to minimize memory footprint.
________________________________________
🚀 Extension Possibilities
•	Support for more than two waves.
•	Interactive "drag-to-modify" on the graph.
•	Color customization for each wave.
________________________________________
📊 Project Self-Assessment
| Criterion | Rating (1–10) |
| :--- | :--- |
| Architecture | 8 |
| Code | 9 |
| UI/UX | 8 |
| Reliability | 9 |
| Overall Level | 8.5 |
________________________________________
🏁 Conclusion
•	Best part: The fluid animation of the resulting graphs.
•	Challenge: Implementing the custom Canvas drawing logic for Lissajous figures.
•	Skills: Advanced Canvas API, Custom View life-cycle, Math in Android.
________________________________________
📎 Appendices
•	Screenshots: Located in `/screenshots`
•	Repo: https://github.com/zeevfraiman/TwoSin
