package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class PuzzleView implements FXComponent {
  private final Controller controller;

  public PuzzleView(Controller controller) {
    if (controller == null) {
      throw new IllegalArgumentException();
    }

    this.controller = controller;
  }

  @Override
  public Parent render() {
    GridPane board = new GridPane();
    board.getStyleClass().add("puzzle-layout");

    board.setHgap(6);
    board.setVgap(6);

    int rowLength = controller.getClues().getColCluesLength();
    int colLength = controller.getClues().getRowCluesLength();

    int boardHeight = controller.getClues().getHeight();
    int boardWidth = controller.getClues().getWidth();

    for (int i = 0; i < boardHeight; i++) {
      for (int j = 0; j < boardWidth; j++) {

        Button tiles = new Button();
        tiles.getStyleClass().add("default-puzzle-layout");

        if (controller.isShaded(i, j)) {
          tiles.getStyleClass().add("shaded-cell");
        } else if (controller.isEliminated(i, j)) {
          tiles.getStyleClass().add("eliminated-cell");
        } else {
          tiles.getStyleClass().add("blank-puzzle-layout");
        }

        int finalI = i;
        int finalJ = j;

        tiles.setOnMouseClicked(
            mouseEvent -> {
              if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                controller.toggleShaded(finalI, finalJ);
              } else if (mouseEvent.getButton().equals(MouseButton.SECONDARY)) {
                controller.toggleEliminated(finalI, finalJ);
              }
            });

        board.add(tiles, j + rowLength, i + colLength, 1, 1);
      }
    }

    // Clue for Width (Column clues)
    for (int i = 0; i < controller.getClues().getWidth(); i++) {
      int[] widthClues = controller.getClues().getColClues(i);
      Label width = new Label();
      StringBuilder column = new StringBuilder();

      for (int clue : widthClues) {
        if (clue != 0) {
          column.append(clue).append(" ");
        } else {
          column.append("  ");
        }
      }
      width.setMaxWidth(10);
      width.getStyleClass().add("width-layout");
      width.setText(column.toString());
      width.setWrapText(true);

      board.add(width, i + widthClues.length, 1);
    }

    // Clue for Height (Row clues)
    for (int i = 0; i < controller.getClues().getHeight(); i++) {
      int[] heightClues = controller.getClues().getRowClues(i);
      Label height = new Label();
      StringBuilder row = new StringBuilder();

      for (int clue : heightClues) {
        if (clue != 0) {
          row.append(clue).append(" ");
        } else {
          row.append("   ");
        }
      }

      height.setMaxHeight(10);
      height.getStyleClass().add("height-layout");
      height.setText(row.toString());

      board.add(height, 1, i + heightClues.length);
    }

    return board;
  }
}
