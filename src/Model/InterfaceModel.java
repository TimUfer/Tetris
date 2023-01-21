package Model;

/**
 * Interface for the model class.
 */
public interface InterfaceModel {
    void startGame();
    void moveShape(String dir);
    void rotate();
    Board getGrid();
    GameStatus getGameState();

}
