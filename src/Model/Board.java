package Model;

import java.util.Arrays;

public class Board {

    public static void main(String[] args){
        Board b = new Board();
        b.board[12] = new int[]{2,0,2,2,6,2,4,2,2,2};

        b.board[14] = new int[]{2,0,2,2,6,2,4,2,2,2};

        b.board[15] = new int[]{2,2,2,2,2,2,2,2,2,2};
        b.board[16] = new int[]{2,2,2,2,2,2,2,2,2,2};
        b.board[18] = new int[]{0,0,2,2,6,2,4,2,2,2};
        b.drop(b.rowCleared());
        b.iterateZero();


        b.testDraw();
        //System.out.println(b.rowCleared());
    }
    private int[][] board = new int[24][10];
    Board(){
        //board[21] = new int[]{2,2,2,2,2,2,2,2,2,2};

    }
    public int[][] getBoard(){
        return board;
    }

    public void testDraw(){
        for(int[] ia: board){
            for(int i : ia){
                System.out.print(i);
            }
            System.out.println("");
        }
        System.out.println("");

    }
    void iterateZero(){
        for(int i = (board.length - 1) - 4; i > 0; --i){
            if(Arrays.stream(board[i]).sum() == 0){
                dropZeroRow(i);
            }
        }
    }
    public void dropZeroRow(int rowIndex) {
        boolean isFilledWithZeros = true;
        for (int j = 0; j < board[rowIndex].length; ++j) {
            if (board[rowIndex][j] != 0) {
                isFilledWithZeros = false;
                break;
            }
        }
        if (isFilledWithZeros) {
            for (int i = rowIndex; i > 0; --i) {
                for (int j = 0; j < board[rowIndex].length; ++j) {
                    board[i][j] = board[i - 1][j];
                }
            }
            Arrays.fill(board[0], 0);
        }
    }
    public int rowCleared(){
        boolean bool;
        int row = -1;
        for(int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                System.out.print(board[i][j]);
                if (board[i][j] == 0) {
                    bool = false;

                    break;
                } else {
                    bool = true;
                    row = i;
                }
            }
            System.out.println("");
        }
        return row;
    }

    public void drop(int row){
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
