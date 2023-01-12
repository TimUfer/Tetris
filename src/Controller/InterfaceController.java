package Controller;

import Model.GameStatus;

public interface InterfaceController {
    void update();
    void move(String dir);
    void rotate();
    void startGame();
    GameStatus getGameState();
    //public void fullRow();
}
