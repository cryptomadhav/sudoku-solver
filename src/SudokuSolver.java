import entities.SudokuBoard;
import managers.IOManager;
import managers.SudokuManager;
import utils.Logger;

import java.util.Date;

public class SudokuSolver {
    public static void main(String[] args) {
        IOManager ioManager = new IOManager();
        int[][] initialBoard = ioManager.initGame();
        SudokuManager sudokuManager = new SudokuManager(initialBoard);
        ioManager.logStartSolving();
        long startTime = System.nanoTime();
        sudokuManager.solve();
        long endTime = System.nanoTime();
        ioManager.logSudokuSolved(endTime - startTime, sudokuManager.getBoard());
    }
}
