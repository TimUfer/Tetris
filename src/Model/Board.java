package Model;

import java.util.Arrays;

public class Board {
    private int[][] board = new int[25][10];
    /**
     * Getter-method for the game-board
     * @return Returns the game-board
     */
    public int[][] getBoard(){
        return board;
    }

    /*void testDraw(){
        for(int[] ia: board){
            for(int i : ia){
                System.out.print(i);
            }
            System.out.println("");
        }
        System.out.println("");

    }*/

    /**
     * Clears a row when it is filled with digits other than zero
     */
    void fullRow(){
        for(int i = 0; i <= checkFullRows(board); ++i){
            drop(rowCleared());
        }
    }
    int checkFullRows(int[][] board) {
        return (int) Arrays.stream(board).filter(r -> Arrays.stream(r).noneMatch(i -> i == 0)).count();
    }

    private int rowCleared(){
        boolean bool;

        int row = -1;
        for(int i = 0; i < board.length; ++i) {
            int count = 0;
            for (int j = 0; j < board[i].length; ++j) {
                System.out.print(board[i][j]);
                if (board[i][j] == 0) {
                    bool = false;

                    break;
                } else {
                    bool = true;
                    count++;
                }
            }
            if(count == 10){
                return i;
            }
            System.out.println("");
        }
        return row;
    }

    private void drop(int row){
        System.out.println(row);
        if(row > -1){
            // Vielleicht mit Streams
            for(int i:board[row]){
                i = 0;
            }
            for(int j = row; j > 0; --j){
                for(int k = 0; k < board[j].length; ++k){
                    board[j][k] = board[j-1][k];
                }
            }
        }
    }
}
