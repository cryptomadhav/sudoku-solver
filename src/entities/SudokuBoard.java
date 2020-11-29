package entities;

public class SudokuBoard {
    private int[][] board;

    public SudokuBoard(int[][] board) {
        this.board = board;
    }

    public int[][] getBoard() {
        return board;
    }

    public int valAt(int row, int col) {
        return this.board[row][col];
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public void fillCell(int row, int col, int val) {
        this.board[row][col] = val;
    }
}
