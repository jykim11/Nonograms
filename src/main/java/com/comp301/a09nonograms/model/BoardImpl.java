package com.comp301.a09nonograms.model;

public class BoardImpl implements Board {
  private final Clues clues;
  private final boolean[][] shadedCell;
  private final boolean[][] eliminatedCell;

  public BoardImpl(Clues clues, boolean[][] shadedCell, boolean[][] eliminatedCell) {
    this.clues = clues;
    this.shadedCell = new boolean[clues.getWidth()][clues.getHeight()];
    this.eliminatedCell = new boolean[clues.getWidth()][clues.getHeight()];
  }

  @Override
  public boolean isShaded(int row, int col) {

    return shadedCell[col][row];
  }

  @Override
  public boolean isEliminated(int row, int col) {

    return eliminatedCell[col][row];
  }

  @Override
  public boolean isSpace(int row, int col) {

    return (!shadedCell[col][row] && !eliminatedCell[col][row]);
  }

  @Override
  public void toggleCellShaded(int row, int col) {

    if (isEliminated(row, col)) {
      toggleCellEliminated(row, col);
    }

    shadedCell[col][row] = !shadedCell[col][row];
  }

  @Override
  public void toggleCellEliminated(int row, int col) {

    if (isShaded(row, col)) {
      toggleCellShaded(row, col);
    }

    eliminatedCell[col][row] = !eliminatedCell[col][row];
  }

  @Override
  public void clear() {
    for (int i = 0; i < clues.getWidth(); i++) {
      for (int j = 0; j < clues.getHeight(); j++) {
        shadedCell[i][j] = false;
        eliminatedCell[i][j] = false;
      }
    }
  }
}
