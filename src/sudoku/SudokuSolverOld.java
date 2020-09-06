package sudoku;
/**
 * @author Patrick Chan
 * @see GridOld
 */
//https://www.jbcnconf.com/2019/infoTalk.html?id=5c3b3e4538da16698cf41b0a

import java.util.ArrayList;
import java.util.List;

public class SudokuSolverOld {

    private List<GridOld> solutions = new ArrayList<GridOld>();

    public SudokuSolverOld(int[][] numbers) {
        solve(GridOld.create(numbers), solutions);
    }

    public boolean isSolveable() {
        return !solutions.isEmpty();
    }

    public boolean isUniqueSolution() {
        return solutions.size() == 1;
    }

    public int[][] getSolution() {
        int[] cells = solutions.get(0).getCells();
        int k = 0;
        int[][] numbers = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                numbers[i][j] = cells[k];
                k++;
            }
        }
        return numbers;
    }

    public List<GridOld> getSolutions() {
        return solutions;
    }

    // Recursive routine that implements the bifurcation algorithm
    private static void solve(GridOld GridOld, List<GridOld> solutions) {
        // Return if there is already a solution
        if (solutions.size() >= 2) {
            return;
        }

        // Find first empty cell
        int loc = GridOld.findEmptyCell();

        // If no empty cells are found, a solution is found
        if (loc < 0) {
            solutions.add(GridOld.clone());
            return;
        }

        // Try each of the 9 digits in this empty cell
        for (int n = 1; n < 10; n++) {
            if (GridOld.set(loc, n)) {
                // With this cell set, work on the next cell
                solve(GridOld, solutions);

                // Clear the cell so that it can be filled with another digit
                GridOld.clear(loc);
            }
        }
    }

}