package com.junyeongkim.nonograms;

import static org.junit.Assert.assertTrue;

import com.comp301.a09nonograms.model.*;
import com.junyeongkim.nonograms.model.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/** Unit test for simple App. */
public class AppTest {
  /** Rigorous Test :-) */
  @Test
  public void shouldAnswerWithTrue() {
    assertTrue(true);
  }

  public void test() {
    int[][] rowClues =
            new int[][] {
                    new int[] {0, 2},
                    new int[] {1, 2},
                    new int[] {0, 3},
                    new int[] {0, 3},
                    new int[] {1, 1},
            };

    int[][] colClues =
            new int[][] {
                    new int[] {1, 1},
                    new int[] {0, 1},
                    new int[] {0, 3},
                    new int[] {0, 3},
                    new int[] {3, 1},
            };

    Clues clue1 = new CluesImpl(rowClues, colClues);
    List<Clues> clues = new ArrayList<>();
    clues.add(clue1);
    ModelImpl model = new ModelImpl(clues);

    ModelObserver observer = (Model m) -> {
      m.clear();
    };
    model.addObserver(observer);

  }
}
