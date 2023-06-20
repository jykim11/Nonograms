package com.junyeongkim.nonograms.model;

public class CluesImpl implements Clues {
  private final int[][] rowClues;
  private final int[][] colClues;

  public CluesImpl(int[][] rowClues, int[][] colClues) {
    if (rowClues.length <= 0 || colClues.length <= 0) {
      throw new IllegalArgumentException();
    } else {
      this.rowClues = rowClues;
      this.colClues = colClues;
    }
  }

  @Override
  public int getWidth() {
    return colClues.length;
  }

  @Override
  public int getHeight() {
    return rowClues.length;
  }

  @Override
  public int[] getRowClues(int index) {
    return rowClues[index];
  }

  @Override
  public int[] getColClues(int index) {
    return colClues[index];
  }

  @Override
  public int getRowCluesLength() {
    return getRowClues(0).length;
  }

  @Override
  public int getColCluesLength() {
    return getColClues(0).length;
  }
}
