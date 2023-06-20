package com.junyeongkim.nonograms.view;

import com.junyeongkim.nonograms.PuzzleLibrary;
import com.junyeongkim.nonograms.controller.Controller;
import com.junyeongkim.nonograms.controller.ControllerImpl;
import com.junyeongkim.nonograms.model.Clues;
import com.junyeongkim.nonograms.model.Model;
import com.junyeongkim.nonograms.model.ModelImpl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

public class AppLauncher extends Application {
  @Override
  public void start(Stage stage) {
    // TODO: Launch your GUI here
    List<Clues> clues = PuzzleLibrary.create();
    Model model = new ModelImpl(clues);

    // Controller
    Controller controller = new ControllerImpl(model);

    // View
    View view = new View(controller);

    // Make scene
    Scene scene = new Scene(view.render(), 600, 600);
    scene.getStylesheets().add("style/main.css");
    stage.setScene(scene);

    // Refresh view when model changes
    model.addObserver(
        (Model m) -> {
          scene.setRoot(view.render());
          stage.sizeToScene();
        });


    // Show the stage
    stage.setTitle("Play Nonograms!");
    stage.show();
  }
}
