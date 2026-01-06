# GuestManager-Refactored: OOP Review

## Key Features

The GuestManager-Refactored is a sophisticated guest administration system developed as a high-level review of object-oriented principles and the Model-View-Controller (MVC) architecture. The application enables comprehensive guest management, including real-time registration, data modification, and automated demographic statistics. A standout feature of this refactored version is its dynamic memory management; the system utilizes a custom-built array resizing logic that expands the registry capacity on-demand, ensuring seamless performance without relying on standard Java collection libraries. By integrating a responsive Java Swing GUI, the platform provides organisers with an intuitive interface to manage attendance, track guest details, and maintain an organized database of event participants.

## Technical Implementation

This project is engineered using a clean, modular Java architecture that strictly enforces the separation of concerns. The technical implementation leverages the Model-View-Controller (MVC) pattern, where the `Controller` acts as a central hub between the `GuestManager` (data logic) and the `MainFrame` (visual representation). Data integrity is maintained through rigorous encapsulation within the `Guest` and `Address` entities, utilizing custom constructors and accessor methods to validate input such as age constraints and geographic data. Furthermore, this version introduces enhanced object communication, where the model and controller interact dynamically to synchronize the maximum guest capacity and registry state, demonstrating a deeper understanding of object relationships and event-driven programming.

## Challenges & Reflection

Returning to this project after a hiatus provided a unique opportunity to evaluate legacy logic and implement more robust programming practices. The primary challenge involved refactoring the communication between the `GuestManager` and the `Controller` to handle capacity scaling more effectively, moving away from static limits to a more fluid, state-aware system. This repetition served as a vital exercise in reinforcing fundamental OOP concepts—such as inheritance, composition, and manual array manipulation—after a period away from active coding. The reflection process highlighted that re-coding fundamental systems is not merely a task of duplication, but an essential practice for identifying edge cases and improving the overall semantic clarity of the codebase.

## Getting Started

To initialize the GuestManager-Refactored on your local machine, ensure you have the JDK installed and use the following terminal commands:

```bash
# Compile the package structure from the source root
javac partyController/*.java partyModel/*.java partyView/*.java

# Execute the application through the MainProgram entry point
java partyController.MainProgram
```
*Author: Alper Eken Course: Objectoriented programming (Repetition & Review) Summer 2024.*
