package Model;

import java.util.Arrays;

/**
 * Functional interface for lambda.
 */
interface Function{
    int countFullRow(int[][] board);
}

/**
 * The Board class resembles the game-board.
 * It has internal methods to check if a row is full of tetris blocks
 * and removes them.
 */
public class Board{
    /**
     * This array is the game-board. Every new tetris-shape will be put here when added to the game-board.
     */
    private int[][] board = new int[25][10];
    /**
     * This function counts how many full rows there are.
     */
    Function countFullRows = board -> (int) Arrays.stream(board).filter(r -> Arrays.stream(r).noneMatch(i -> i == 0)).count();
    /**
     * Getter-method for the game-board
     * @return Returns the game-board
     */
    public int[][] getBoard(){
        return board;
    }
/*
    void testDraw(){
        for(int[] ia: board){
            for(int i : ia){
                System.out.print(i);
            }
            System.out.println("");
        }
        System.out.println("");

    }
*/
    /**
     * Clears a row when it is filled with digits other than zero
     */
    void fullRow(){
        int c = countFullRows.countFullRow(board);
        for(int i = 0; i <= c; ++i){
            drop(rowToBeCleared());
        }
    }

    /**
     * This method detects which row is to be cleared
     * @return returns the index of the row that has to be cleared
     */
    private int rowToBeCleared(){
        int row = -1;
        for(int i = 0; i < board.length; ++i) {
            int count = 0;
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] == 0) {
                    break;
                } else {
                    count++;
                }
            }
            if(count == 10){
                return i;
            }
        }
        return row;
    }

    /**
     * the drop-method drops the rows above the one that has to be cleared
     * @param row The row that is full and has to be cleared
     */
    private void drop(int row){
        if(row > -1){
            for(int j = row; j > 0; --j){
                for(int k = 0; k < board[j].length; ++k){
                    board[j][k] = board[j-1][k];
                }
            }
        }
    }
}
