package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class ResetView implements FXComponent {
  private final Controller controller;

  public ResetView(Controller controller) {
    if (controller == null) {
      throw new IllegalArgumentException();
    }

    this.controller = controller;
  }

  @Override
  public Parent render() {
    StackPane layout = new StackPane();
    layout.getStyleClass().add("clear-layout");

    Button resetButton = new Button("Clear");
    resetButton.setOnAction((ActionEvent event) -> controller.clearBoard());

    layout.getChildren().add(resetButton);

    return layout;
  }
}
