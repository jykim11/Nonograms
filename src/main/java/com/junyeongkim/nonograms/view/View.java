package com.junyeongkim.nonograms.view;

import com.junyeongkim.nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

public class View implements FXComponent {
  private final Controller controller;

  public View(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    VBox layout = new VBox();
    layout.getStyleClass().add("layout");

    // Controls view
    ControlView controlView = new ControlView(controller);
    layout.getChildren().add(controlView.render());

    // Reset view
    ResetView resetView = new ResetView(controller);
    layout.getChildren().add(resetView.render());

    // Number of Puzzles view
    NumberOfPuzzles numberOfPuzzles = new NumberOfPuzzles(controller);
    layout.getChildren().add(numberOfPuzzles.render());

    // Puzzle view
    PuzzleView puzzleView = new PuzzleView(controller);
    layout.getChildren().add(puzzleView.render());

    // Message view
    MessageView messageView = new MessageView(controller);
    layout.getChildren().add(messageView.render());

    return layout;
  }
}
