package View;
import Controller.InterfaceController;
import Controller.Controller;
import Model.GameStatus;
import processing.core.PApplet;
import processing.core.PGraphics;

public class View extends PApplet implements InterfaceView{
    private int[][] gameBoard;
    boolean gamerunning = false;
    int boarderX = 50;
    int boarderY = 50;
    InterfaceController controller;

    public void setController(InterfaceController controller){this.controller = controller;}

    public void draw(){
        //System.out.println(controller.getGameStateENUM());
        if(gamerunning == false){
            startScreen();
        }
        else if(controller.getGameStateENUM() == GameStatus.RUNNING){
            gameScreenSettings();
            controller.update();
            drawBoard();
        }else if(controller.getGameStateENUM() == GameStatus.GAMEOVER){
            gameOverScreen();
        }
    }

    public void gameScreenSettings(){
        background(color(26, 26, 26));
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
                    fill(color(51, 51, 51));
                    rect(j * size + boarderX, (i - 4) * size + boarderY, size, size);
                } else if (gameBoard[i][j] == 1) {
                    fill(color(204, 0, 153));
                    rect(j * size + boarderX, (i - 4) * size+ boarderY, size, size);
                } else if (gameBoard[i][j] == 2) {
                    fill(color(51, 51, 255));
                    rect(j * size + boarderX, (i - 4) * size+ boarderY, size, size);
                } else if (gameBoard[i][j] == 3) {
                    fill(color(255, 26, 26));
                    rect(j * size + boarderX, (i - 4) * size+ boarderY, size, size);
                } else if (gameBoard[i][j] == 4) {
                    fill(color(255, 204, 0));
                    rect(j * size + boarderX, (i - 4) * size+ boarderY, size, size);
                } else if (gameBoard[i][j] == 5) {
                    fill(color(51, 255, 51));
                    rect(j * size + boarderX, (i - 4) * size+ boarderY, size, size);
                } else if (gameBoard[i][j] == 6) {
                    fill(color(255, 102, 0));
                    rect(j * size + boarderX, (i - 4) * size+ boarderY, size, size);
                } else if (gameBoard[i][j] == 7) {
                    fill(color(255, 0, 102));
                    rect(j * size + boarderX, (i - 4) * size+ boarderY, size, size);
                }

            }
        }
    }
    void startScreen(){
        background(color(20));
        textSize(100);
        text("TETRIS",250,200);
        fill(color(240));
        textSize(50);
        text("Press Enter to play",200,500);
        fill(color(230, 230, 0));
    }

    void gameOverScreen(){
        background(color(20));
        textSize(100);
        text("GAMEOVER",150,200);
        fill(color(230, 230, 0));
    }
    public void keyReleased(){
        if(keyCode == UP){
            controller.rotate();
        } else if(keyCode == RIGHT){
            controller.move("right");
        } else if(keyCode == LEFT){
            controller.move("left");
        }
        if(controller.getGameStateENUM() == GameStatus.MENU && keyCode == ENTER){
            gamerunning = true;
            controller.startGame();
        }
    }
}
