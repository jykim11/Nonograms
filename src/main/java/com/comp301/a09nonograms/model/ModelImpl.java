package com.comp301.a09nonograms.model;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {
  private final List<Clues> clues; // available puzzles for the user to solve.
  private int puzzleIndex; // index into the puzzle library.
  private final List<ModelObserver> modelObservers; // active model observers.
  private Clues activePuzzle; // active puzzle.
  private boolean[][] shadedCell;
  private boolean[][] eliminatedCell;
  private Board board;

  public ModelImpl(List<Clues> clues) {

    this.clues = new ArrayList<>(clues);

    this.puzzleIndex = 0;
    this.modelObservers = new ArrayList<>();
    this.activePuzzle =
        clues.get(puzzleIndex); // available puzzle at the current puzzleIndex library.
    this.board = new BoardImpl(activePuzzle, shadedCell, eliminatedCell);
    clear();
  }

  @Override
  public boolean isShaded(int row, int col) {
    if (row < 0 || col < 0 || row > activePuzzle.getHeight() || col > activePuzzle.getWidth()) {
      throw new RuntimeException();
    }

    return board.isShaded(row, col);
  }

  @Override
  public boolean isEliminated(int row, int col) {
    if (row < 0 || col < 0 || row > activePuzzle.getHeight() || col > activePuzzle.getWidth()) {
      throw new RuntimeException();
    }

    return board.isEliminated(row, col);
  }

  @Override
  public boolean isSpace(int row, int col) {
    if (row < 0 || col < 0 || row > activePuzzle.getHeight() || col > activePuzzle.getWidth()) {
      throw new RuntimeException();
    }

    return board.isSpace(row, col);
  }

  @Override
  public void toggleCellShaded(int row, int col) {
    if (row < 0 || col < 0 || row > activePuzzle.getHeight() || col > activePuzzle.getWidth()) {
      throw new RuntimeException();
    }

    board.toggleCellShaded(row, col);
    notifyObservers();
  }

  @Override
  public void toggleCellEliminated(int row, int col) {
    if (row < 0 || col < 0 || row > activePuzzle.getHeight() || col > activePuzzle.getWidth()) {
      throw new RuntimeException();
    }

    board.toggleCellEliminated(row, col);
    notifyObservers();
  }

  @Override
  public void clear() {
    board.clear();
    notifyObservers();
  }

  @Override
  public int getWidth() {
    return activePuzzle.getWidth();
  }

  @Override
  public int getHeight() {
    return activePuzzle.getHeight();
  }

  @Override
  public int[] getRowClues(int index) {
    return activePuzzle.getRowClues(index);
  }

  @Override
  public int[] getColClues(int index) {
    return activePuzzle.getColClues(index);
  }

  @Override
  public int getRowCluesLength() {
    return activePuzzle.getRowCluesLength();
  }

  @Override
  public int getColCluesLength() {
    return activePuzzle.getColCluesLength();
  }

  @Override
  public int getPuzzleCount() {
    return clues.size();
  }

  @Override
  public int getPuzzleIndex() {
    return puzzleIndex;
  }

  @Override
  public void setPuzzleIndex(int index) {
    puzzleIndex = index;
    activePuzzle = clues.get(puzzleIndex);
    board = new BoardImpl(activePuzzle, shadedCell, eliminatedCell);

    notifyObservers();
  }

  @Override
  public void addObserver(ModelObserver observer) {
    modelObservers.add(observer);
  }

  @Override
  public void removeObserver(ModelObserver observer) {
    modelObservers.remove(observer);
  }

  @Override
  public boolean isSolved() {
    int shaded = 0;
    int solved = 0;

    for (int i = 0; i < this.getHeight(); i++) {
      for (int j = 0; j < this.getWidth(); j++) {
        if (this.isShaded(i, j)) {
          shaded++;
        }
      }

      for (int j = 0; j < this.getRowClues(i).length; j++) {
        solved = solved + this.getRowClues(i)[j];
      }
    }

    return solved == shaded;
  }

  public Clues getClues() {
    return activePuzzle;
  }

  private void notifyObservers() {
    for (ModelObserver modelObserver : modelObservers) {
      modelObserver.update(this);
    }
  }
}
