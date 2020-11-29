package managers;

import entities.SudokuBoard;

public class SudokuManager {
    private SudokuBoard sudokuBoard;

    public SudokuManager(int[][] initialBoard) {
        this.sudokuBoard = new SudokuBoard(initialBoard);
    }

    public int[][] getBoard() {
        return this.sudokuBoard.getBoard();
    }

    public boolean solve() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int lastValue = sudokuBoard.valAt(row, col);
                if(lastValue == 0) {
                    for (int val = 1; val < 9; val++) {
                        if(checkMoveValidity(row, col, val)) {
                            makeMove(row, col, val);
                            if(solve()) {
                                return true;
                            }
                            makeMove(row, col, 0);
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean checkMoveValidity(int row, int col, int val) {
        return validForRow(row, val)
                && validForCol(col, val)
                && validForBlock(row, col, val);
    }

    private boolean validForRow(int row, int val) {
        for(int col = 0; col < 9; col ++) {
            if(sudokuBoard.getBoard()[row][col] == val) {
                return false;
            }
        }
        return true;
    }

    private boolean validForCol(int col, int val) {
        for(int row = 0; row < 9; row ++) {
            if(sudokuBoard.getBoard()[row][col] == val) {
                return false;
            }
        }
        return true;
    }

    private boolean validForBlock(int row, int col, int val) {
        int lowestRow = (row / 3) * 3;
        int highestRow = ((row / 3) + 1) * 3 - 1;
        int lowestCol = (col / 3) * 3;
        int highestCol = ((col / 3) + 1) * 3 - 1;
        for (int iRow = lowestRow; iRow < highestRow; iRow++) {
            for (int iCol = lowestCol; iCol < highestCol; iCol++) {
                if(sudokuBoard.getBoard()[iRow][iCol] == val) {
                    return false;
                }
            }
        }
        return true;
    }

    public void makeMove(int row, int col, int val) {
        sudokuBoard.fillCell(row, col, val);
    }
}
