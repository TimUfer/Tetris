package Controller;

import Model.Model;

import View.InterfaceView;
import Model.GameStatus;

/**
 * Every communication from Model to View goes through the controller.
 * Model and View don't know each other and never interact directly
 */

public class Controller implements InterfaceController{
    /**
     * Variable to store a Model object
     */
    Model model;
    /**
     * Variable to store a View Interface
     */
    InterfaceView view;

    public Controller(Model model){
        this.model = model;
    }

    /**
     * Setter-method for the View
     * @param view The Interface which is to be sat as the local view variable
     */
    public void setView(InterfaceView view){this.view = view;}

    /**
     * Getter-method for the game-board
     * @return Returns the game-board
     */
    public int[][] getBoard(){
        return model.getGrid().getBoard();
    }

    /**
     * The nextFrame-method decides based on the game-state, what screen to display
     */
    public void nextFrame(){
        if(model.getGameState() == GameStatus.MENU){
            view.startScreen();
        }
        else if(model.getGameState() == GameStatus.RUNNING){
            view.gameScreen();
            view.drawBoard();
        }else if(model.getGameState() == GameStatus.GAMEOVER){
            view.gameOverScreen();
        }
    }

    /**
     * The keyHandler-method decides what to do if a certain keyCode comes in through the parameter.
     * @param key Is the keyCode which resembles a key on the keyboard
     */
    public void keyHandler(int key){
        switch (key) {
            case 38 -> model.rotate();
            case 39 -> model.moveShape("right");
            case 37 -> model.moveShape("left");
            case 10 -> {
                if(model.getGameState() == GameStatus.MENU) model.startGame();
            }
            default -> System.out.println("No valid input. Valid inputs are UP, LEFT, RIGHT, ENTER");
        }
    }
}
