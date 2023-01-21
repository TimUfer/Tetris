package Controller;

/**
 * Interface for the Controller. It only contains methods important for the View.
 */
public interface InterfaceController {
    int[][] getBoard();
    void nextFrame();
    void keyHandler(int keyCode);
}
