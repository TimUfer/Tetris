package Controller;

import Model.Model;

import View.InterfaceView;
import Model.GameStatus;

public class Controller implements InterfaceController{
    Model model;
    InterfaceView view;

    public Controller(Model model){
        this.model = model;
    }
    public void setView(InterfaceView view){this.view = view;}
    public int[][] getBoard(){
        return model.getGrid().getBoard();
    }

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

    public void keyHandler(int key){
        switch (key) {
            case 38 -> model.rotate();
            case 39 -> model.moveShape("right");
            case 37 -> model.moveShape("left");
            case 10 -> {
                if(model.getGameState() == GameStatus.MENU) model.startGame();
            }
            default -> System.out.println("No valid input");
        }
    }
}
