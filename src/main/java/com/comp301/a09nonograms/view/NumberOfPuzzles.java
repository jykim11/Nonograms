package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.util.Stack;

public class NumberOfPuzzles implements FXComponent {
  private final Controller controller;

  public NumberOfPuzzles(Controller controller) {
    if (controller == null) {
      throw new IllegalArgumentException();
    }

    this.controller = controller;
  }

  @Override
  public Parent render() {
    StackPane layout = new StackPane();
    layout.getStyleClass().add("number-of-puzzles-layout");

    Label puzzleNumber =
        new Label(
            "Puzzle "
                + (controller.getPuzzleIndex() + 1)
                + " of "
                + (controller.getPuzzleCount())
                + ".");

    layout.getChildren().add(puzzleNumber);

    return layout;
  }
}
