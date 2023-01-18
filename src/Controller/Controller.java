package Controller;

import Model.Model;
import Model.InterfaceModel;
import View.View;
import View.InterfaceView;
import Model.GameStatus;

public class Controller implements InterfaceController{
    Model model;
    InterfaceView view;

    public Controller(Model model){
        this.model = model;
    }
    public void setView(InterfaceView view){this.view = view;}
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
