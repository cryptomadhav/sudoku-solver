package utils;

public class Logger {
    public static void logSudokuInputRequest() {
        System.out.println("Please enter an intial Sudoku pattern");
    }

    public static void logSudokuSolveStarted() {
        System.out.println("Started solving the sudoku");
    }

    public static void logSudokuSolved(Long time) {
        System.out.println(String.format("Solved Sudoku in time %s ns.", time));
    }
}
