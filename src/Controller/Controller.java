package Controller;

import Model.Model;
import View.View;
import View.InterfaceView;

public class Controller implements InterfaceController{
    Model model;
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
    public void fullRow(){
        model.getGrid().fullRow();
    }

}
