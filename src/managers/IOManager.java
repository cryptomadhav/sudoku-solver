package managers;

import utils.Logger;

import java.util.Scanner;

public class IOManager {

    private Scanner scanner;

    public IOManager(){
        scanner = new Scanner(System.in);
    }

    public int[][] initGame() {
        int[][] inputBoard = new int[9][9];
        Logger.logSudokuInputRequest();
        for(int row = 0; row < 9; row ++) {
            char[] rowStream = scanner.next().toCharArray();
            for (int col = 0; col < 9; col++) {
                inputBoard[row][col] = rowStream[col] - '0';
            }
        }
        return inputBoard;
    }

    public void logStartSolving() {
        Logger.logSudokuSolveStarted();
    }

    public void logSudokuSolved(Long time, int[][] solvedBoard) {
        Logger.logSudokuSolved(time);
        for (int row = 0; row < 9; row++) {
            if(row % 3 == 0) {
                for (int i = 0; i < 17; i++) {
                    System.out.print(" ");
                }
                System.out.println();
            }
            for (int col = 0; col < 9; col++) {
                if(col % 3 == 0) {
                    System.out.print(" ");
                }
                System.out.print(solvedBoard[row][col]);
            }
            System.out.println();
        }
    }
}
