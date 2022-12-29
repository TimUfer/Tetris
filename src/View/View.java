package View;
import Controller.Controller;
import processing.core.PApplet;
import processing.core.PGraphics;

public class View extends PApplet implements InterfaceView{
    public static void main(String[] args){
        String[] appArgs = {"Draw"};
        View view = new View();
        view.runSketch(appArgs, view);
    }
    private int[][] gameBoard;
    int boaderX = 50;
    int boarderY = 50;
    Controller controller = new Controller(this);

    public void draw(){
        controller.update();
        drawBoard();
    }

    public void setup(){
        background(color(255));
    }

    public void settings(){
        size(800, 800);

    }
    public void setGameBoard(int[][] board){
        this.gameBoard = board;
    }
    private void drawBoard(){
        int size = 30;
        for(int i = 3; i < gameBoard.length; ++i){
            for(int j = 0; j < gameBoard[i].length; ++j){
                if(gameBoard[i][j] == 0){
                    fill(color(200));
                    rect(j * size, i * size,size,size);
                } else if(gameBoard[i][j] == 1){
                    fill(color(100));
                    rect(i * size, j * size,size,size);
                }
            }
        }
    }
}
