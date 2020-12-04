package test.java.sudoku;

import org.junit.jupiter.api.Test;
import sudoku.SudokuSolver;
import sudoku.SudokuSolverOld;

import static org.junit.jupiter.api.Assertions.*;

class SudokuSolverTest {

    @Test
    void checkThatRefactoredCodeReturnsSameResultAsOriginalCode() {
        int[][] grid = {
                {1, 0, 3, 9, 0, 0, 7, 0, 0},
                {4, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 1, 0, 8},
                {0, 1, 0, 0, 0, 4, 0, 0, 0},
                {0, 2, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 5, 0, 0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 6, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1}};

        var comparer = new SudokuSolverOld(grid);
        var refactored = new SudokuSolver(grid);

        assertEquals(comparer.isSolveable(),refactored.isSolvable());
        assertEquals(comparer.isUniqueSolution(),refactored.isUniqueSolution());
        assertArrayEquals(comparer.getSolution(), refactored.getSolution());
    }
}