package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class MessageView implements FXComponent {
  private final Controller controller;

  public MessageView(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    StackPane layout = new StackPane();
    layout.getStyleClass().add("message-layout");
    Label correctMessageView = new Label("Puzzle Solved!");
    correctMessageView.setVisible(false);

    // Message view
    if (controller.isSolved()) {
      correctMessageView.setVisible(true);
    }

    layout.getChildren().add(correctMessageView);

    return layout;
  }
}
