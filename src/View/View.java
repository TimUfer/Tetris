package View;
import Controller.InterfaceController;
import processing.core.PApplet;
import processing.core.PGraphics;

/**
 * The View class is the UI of this program. It provides a good user interaction by displaying not only numbers in an array,
 * but interpreting them to colorful rectangles which then sum up to a recognizable tetrisShape.
 * It also makes the interaction with the game easy by recognizing the pressed keys and sending them to the controller for further
 * interpretation, which makes it possible to control the game.
 */

public class View extends PApplet implements InterfaceView{
    /**
     * Stores the distance between the left window border and the drawn game-board
     */
    private int boarderX = 50;
    /**
     * Stores the distance between the upper window border and the drawn game-board
     */
    private int boarderY = 50;
    /**
     * Variable to store a controller interface.
     */
    InterfaceController controller;

    /**
     * Setter-method for the Controller
     * @param controller The Interface that will be sat as the global controller variable.
     */
    public void setController(InterfaceController controller){this.controller = controller;}

    /**
     * The draw-method draws everything in its body 60 times in a second.
     * It calls the nextFrame-method of the controller which decides what is to draw.
     */
    public void draw(){
        controller.nextFrame();
    }

    /**
     * This method sets the background color of the game-screen and displays a short explanation of the controls
     */
    public void gameScreen(){
        background(color(26, 26, 26));
        fill(color(200));
        textSize(50);
        text("Controls", 450,200);
        textSize(30);
        text("Rotate: UP arrow", 450,250);
        text("Move Left: Left arrow", 450,300);
        text("Move Right: Right arrow", 450,350);
    }

    /**
     * The settings-method sets the window size of the game.
     */
    public void settings(){
        size(800, 800);
    }

    /**
     * This method draws the game-board. Every tetris-shape has its own color, which are resembled by the numbers inside the gameboard array
     */
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

    /**
     * This method draws the menu screen
     */
    public void startScreen(){
        background(color(30));
        textSize(100);
        text("TETRIS",250,200);
        fill(color(240));
        textSize(50);
        text("Press Enter to play",200,500);
        fill(color(230, 230, 0));
    }

    /**
     * This method draws the game-over screen
     */
    public void gameOverScreen(){
        background(color(30));
        textSize(100);
        text("GAMEOVER",150,200);
        fill(color(230, 230, 0));
    }

    /**
     * this method calls the keyHandler-method of the controller with the keyCode of the key that had been pressed.
     */
    public void keyReleased(){
        controller.keyHandler(keyCode);
    }
}
