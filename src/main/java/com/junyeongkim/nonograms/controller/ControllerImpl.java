package com.junyeongkim.nonograms.controller;

import com.junyeongkim.nonograms.model.Clues;
import com.junyeongkim.nonograms.model.Model;
import com.junyeongkim.nonograms.model.ModelImpl;

public class ControllerImpl implements Controller {
  private final Model model;

  public ControllerImpl(Model model) {
    this.model = model;
  }

  @Override
  public Clues getClues() {
    ModelImpl clues = (ModelImpl) model;
    return clues.getClues();
  }

  @Override
  public boolean isSolved() {
    return model.isSolved();
  }

  @Override
  public boolean isShaded(int row, int col) {
    return model.isShaded(row, col);
  }

  @Override
  public boolean isEliminated(int row, int col) {
    return model.isEliminated(row, col);
  }

  @Override
  public void toggleShaded(int row, int col) {
    model.toggleCellShaded(row, col);
  }

  @Override
  public void toggleEliminated(int row, int col) {
    model.toggleCellEliminated(row, col);
  }

  @Override
  public void nextPuzzle() {
    if (model.getPuzzleIndex() < model.getPuzzleCount() - 1) {
      model.setPuzzleIndex(model.getPuzzleIndex() + 1);
    } else {
      model.setPuzzleIndex(0);
    }
  }

  @Override
  public void prevPuzzle() {
    if (model.getPuzzleIndex() > 0) {
      model.setPuzzleIndex(model.getPuzzleIndex() - 1);
    } else {
      model.setPuzzleIndex(model.getPuzzleCount() - 1);
    }
  }

  @Override
  public void randPuzzle() {
    int randomize = (int) (Math.random() * model.getPuzzleCount());
    model.setPuzzleIndex(randomize);
  }

  @Override
  public void clearBoard() {
    model.clear();
  }

  @Override
  public int getPuzzleIndex() {
    return model.getPuzzleIndex();
  }

  @Override
  public int getPuzzleCount() {
    return model.getPuzzleCount();
  }
}
