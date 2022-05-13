## Introduction

In this project, I utilized **model-view-controller** (MVC) design pattern together with the **JavaFX** User Interface (UI) library to design a complete, functioning Graphical User Interface (GUI) implementation of the single-player logic puzzle nonograms. **Maven**, a build automation tool for Java, was used as a build manager where JavaFX was added as a Maven dependency to the POM file. The project involves high usage of Object-Oriented Programming where the idea of encapsulation, composition over inheritance, and subtype polymorphism has been implemented.

## Running the application

To run the application with Maven in IntelliJ, follow these steps:

1. Click the vertical "Maven" expansion tab which is on the right side of the IntelliJ window.

2. Expand the "Plugins" folder.

3. Expand the "javafx" folder.

4. Double-click "javafx:run" to run the project.

### Clues Interface

Each `Clues` instance represents the clues for a single nonograms puzzle. In particular, a `Clues` instance encapsulates the following concepts:

1. The height of the puzzle (i.e. the number of rows in the puzzle)
2. The width of the puzzle (i.e. the number of columns in the puzzle)
3. An array of integers for each row in the puzzle, representing the clues for that row
4. An array of integers for each column in the puzzle, representing the clues for that column

`Clues` instances are intended to be *immutable*---that is, the fields of a `Clues` instance should not change after instantiation.


#### CluesImpl Class

The `CluesImpl` class exposes a constructor with the following signature:

```java
public CluesImpl(int[][] rowClues, int[][] colClues) {
  // Constructor code here
}
```

The `rowClues` parameter is a two-dimensional array containing the clues for each row of the puzzle (top-to-bottom), and the `colClues` parameter is a two-dimensional array containing the clues for the columns of the puzzle (left-to-right). Spaces can be represented by zeros in the clue arrays.


### Board Interface

A `Clues` instance represents the clues for a puzzle, but doesn't handle the state to track whether individual cells are "shaded" or "eliminated". The `Board` interface is intended to track the array of states for each cell in a puzzle. In other words, a nonogram puzzle is a combination of a `Clues` object, representing the clues for the puzzle, and a `Board` object, representing the states of the puzzle's cells.

Instances of `Board` are not intended to be immutable. As the user clicks on different cells of the puzzle, the internal fields in the `Board` instance should change to reflect the new state. For example, if the user clicks on a cell to change it to be shaded, a field modification must take place inside the `Board` instance to reflect that the cell is now shaded. This can be accomplished via the `toggleCellShaded()` and `toggleCellEliminated()` methods.


### Model Interface

The `Model` interface represents the model of MVC, and therefore contains all data necessary to display the current state of the application. In particular, a `Model` instance encapsulates the following concepts:

1. A library of available nonogram puzzles for the user to solve
2. A way to select which puzzle is currently active; for example, maybe an index into the puzzle library
3. The `Clues` and corresponding `Board` information for the currently active puzzle
4. A `List<ModelObserver>` of active model observers, represented by the `ModelObserver` interface (see below)

A `Model` represents the currently active  `Board` and `Clues` for the currently active puzzle.


#### ModelImpl Class

The `ModelImpl` class exposes a constructor with the following signature:

```java
public ModelImpl(List<Clues> clues) {
  // Constructor code here
}
```

The `clues` parameter is a list of `Clues` instances representing the library of available puzzles for the user to solve.


The `ModelImpl` class is a "subject" with respect to the observer design pattern.


### ModelObserver Interface

The `ModelObserver` interface defines a single method, `update()`, and is used together with the `ModelImpl` class to implement the observer design pattern.


## Controller

The controller package in MVC is intended to act as the "glue" between the model and the view.


## View

The `view` package in MVC is intended to hold all code related to the GUI.

The code in the `view` package will primarily create and manipulate JavaFX objects.


### AppLauncher

This class is the launching point of your application. The `Main` class is set up to forward to `AppLauncher`, which extends `Application` and therefore launches the JavaFX GUI.
