package View;
import Controller.InterfaceController;
import Controller.Controller;
import Model.GameStatus;
import processing.core.PApplet;
import processing.core.PGraphics;

public class View extends PApplet implements InterfaceView{
    public static void main(String[] args){
        String[] appArgs = {"Draw"};
        View view = new View();
        view.runSketch(appArgs, view);
    }
    private int[][] gameBoard;
    int boarderX = 50;
    int boarderY = 50;
    InterfaceController controller = new Controller(this);

    public void draw(){
        if (controller.getGameStateENUM() == GameStatus.RUNNING){
            controller.update();
            drawBoard();
        }
    }

    public void setup(){
        controller.startGame();
        background(color(107, 87, 158));
    }

    public void settings(){
        size(800, 800);

    }
    public void setGameBoard(int[][] board){
        this.gameBoard = board;
    }
    private void drawBoard(){
        int size = 35;
        for(int i = 4; i < gameBoard.length-1; ++i) {
            for (int j = 0; j < gameBoard[i].length; ++j) {
                if (gameBoard[i][j] == 0) {
                    fill(color(200));
                    rect(j * size + boarderX, (i - 4) * size + boarderY, size, size);
                } else if (gameBoard[i][j] == 1) {
                    fill(color(100));
                    rect(j * size + boarderX, (i - 4) * size+ boarderY, size, size);
                } else if (gameBoard[i][j] == 2) {
                    fill(color(50));
                    rect(j * size + boarderX, (i - 4) * size+ boarderY, size, size);
                } else if (gameBoard[i][j] == 3) {
                    fill(color(150));
                    rect(j * size + boarderX, (i - 4) * size+ boarderY, size, size);
                } else if (gameBoard[i][j] == 4) {
                    fill(color(75));
                    rect(j * size + boarderX, (i - 4) * size+ boarderY, size, size);
                } else if (gameBoard[i][j] == 5) {
                    fill(color(10));
                    rect(j * size + boarderX, (i - 4) * size+ boarderY, size, size);
                } else if (gameBoard[i][j] == 6) {
                    fill(color(30));
                    rect(j * size + boarderX, (i - 4) * size+ boarderY, size, size);
                } else if (gameBoard[i][j] == 7) {
                    fill(color(230));
                    rect(j * size + boarderX, (i - 4) * size+ boarderY, size, size);
                }

            }
        }
    }
    public void keyReleased(){
        if(keyCode == UP){
            controller.rotate();
        } else if(keyCode == RIGHT){
            controller.move("right");
        } else if(keyCode == LEFT){
            controller.move("left");
        }
    }
}
