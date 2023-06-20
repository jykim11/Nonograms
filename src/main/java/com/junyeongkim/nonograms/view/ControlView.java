package com.junyeongkim.nonograms.view;

import com.junyeongkim.nonograms.controller.Controller;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ControlView implements FXComponent {
  private final Controller controller;
  private HBox layout;

  public ControlView(Controller controller) {
    if (controller == null) {
      throw new IllegalArgumentException();
    }

    this.controller = controller;
  }

  @Override
  public Parent render() {
    if (layout != null) {
      return layout;
    }

    layout = new HBox();
    layout.getStyleClass().add("control-layout");

    // Previous Button
    Button previousButton = new Button("Previous");
    previousButton.getStyleClass().add("previous-button-style");
    previousButton.setOnAction(
        (ActionEvent event) -> {
          controller.prevPuzzle();
        });
    layout.getChildren().add(previousButton);

    // Next Button
    Button nextButton = new Button("Next");
    nextButton.getStyleClass().add("next-button-style");
    nextButton.setOnAction(
        (ActionEvent event) -> {
          controller.nextPuzzle();
        });
    layout.getChildren().add(nextButton);

    // Random Button
    Button randomButton = new Button("Random");
    randomButton.getStyleClass().add("random-button-style");
    randomButton.setOnAction(
        (ActionEvent event) -> {
          controller.randPuzzle();
        });
    layout.getChildren().add(randomButton);

    return layout;
  }
}
