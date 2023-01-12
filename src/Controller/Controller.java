package Controller;

import Model.Model;
import Model.InterfaceModel;
import View.View;
import View.InterfaceView;
import Model.GameStatus;

public class Controller implements InterfaceController{
    InterfaceModel model;
    InterfaceView view;

    public Controller(InterfaceView view){
        this.view = view;
        model = new Model();
    }
    public void update(){
        view.setGameBoard(model.getGrid().getBoard());
    }
    public void move(String dir){
        model.moveShape(dir);
    }
    public void rotate(){
        model.rotate();
    }
    public void startGame(){
        model.startGame();
    }
    public GameStatus getGameStateENUM(){
        return model.getGameState();
    }

}
