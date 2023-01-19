package View;
import Controller.InterfaceController;
import processing.core.PApplet;
import processing.core.PGraphics;

public class View extends PApplet implements InterfaceView{
    int boarderX = 50;
    int boarderY = 50;
    InterfaceController controller;

    public void setController(InterfaceController controller){this.controller = controller;}

    public void draw(){
        controller.nextFrame();
    }

    public void gameScreen(){
        background(color(26, 26, 26));
        fill(color(200));
        textSize(50);
        text("Controls", 500,200);
        textSize(30);
        text("Rotate: UP arrow", 500,250);
        text("Left: Left arrow", 500,300);
        text("Right: Right arrow", 500,350);
    }

    public void settings(){
        size(800, 800);
    }

    public void drawBoard(){
        int size = 35;
        for(int i = 4; i < controller.getBoard().length-1; ++i) {
            for (int j = 0; j < controller.getBoard()[i].length; ++j) {
                if (controller.getBoard()[i][j] == 0) {
                    fill(color(51, 51, 51));
                    rect(j * size + boarderX, (i - 4) * size + boarderY, size, size);
                } else if (controller.getBoard()[i][j] == 1) {
                    fill(color(204, 0, 153));
                    rect(j * size + boarderX, (i - 4) * size+ boarderY, size, size);
                } else if (controller.getBoard()[i][j] == 2) {
                    fill(color(51, 51, 255));
                    rect(j * size + boarderX, (i - 4) * size+ boarderY, size, size);
                } else if (controller.getBoard()[i][j] == 3) {
                    fill(color(255, 26, 26));
                    rect(j * size + boarderX, (i - 4) * size+ boarderY, size, size);
                } else if (controller.getBoard()[i][j] == 4) {
                    fill(color(255, 204, 0));
                    rect(j * size + boarderX, (i - 4) * size+ boarderY, size, size);
                } else if (controller.getBoard()[i][j] == 5) {
                    fill(color(51, 255, 51));
                    rect(j * size + boarderX, (i - 4) * size+ boarderY, size, size);
                } else if (controller.getBoard()[i][j] == 6) {
                    fill(color(255, 102, 0));
                    rect(j * size + boarderX, (i - 4) * size+ boarderY, size, size);
                } else if (controller.getBoard()[i][j] == 7) {
                    fill(color(255, 0, 102));
                    rect(j * size + boarderX, (i - 4) * size+ boarderY, size, size);
                }

            }
        }
    }
    public void startScreen(){
        background(color(30));
        textSize(100);
        text("TETRIS",250,200);
        fill(color(240));
        textSize(50);
        text("Press Enter to play",200,500);
        fill(color(230, 230, 0));
    }

    public void gameOverScreen(){
        background(color(30));
        textSize(100);
        text("GAMEOVER",150,200);
        fill(color(230, 230, 0));
    }
    public void keyReleased(){
        controller.keyHandler(keyCode);
    }
}
