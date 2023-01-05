package Model;

public interface InterfaceModel {
    void startGame();
    void moveShape(String dir);
    void rotate();
    Board getGrid();
}
