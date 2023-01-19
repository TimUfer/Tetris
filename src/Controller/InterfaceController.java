package Controller;

import Model.GameStatus;

public interface InterfaceController {
    int[][] getBoard();
    void nextFrame();
    void keyHandler(int keyCode);
}
