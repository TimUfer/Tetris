package Model;

import java.util.Arrays;

/**
 * The Model class manipulates the game. With its Methods like moveShape or rotate,
 * it can influence the position and the orientation of the current Block on the game-board.
 * It also starts the game with the startGame Method.
 * Another purpose of this class is the collision-detection.
 * With the three collision-detection Methods its checking if the current Block has reached the Botton,
 * reached the side-borders or has collided with another Block.
 */
public class Model implements InterfaceModel {

    private GameStatus gameState = GameStatus.MENU;
    private Board grid = new Board();
    private GameLoop loop;
    private Shape currentShape = new Shape(3,0);

    void newTetrisPiece(){
        currentShape = new Shape(3,0);
    }
    boolean gameOver(){
        if(Arrays.stream(grid.getBoard()[4]).sum() != 0){
            System.out.println("Gameover");
            gameState = GameStatus.GAMEOVER;
            return false;
        }else {
            return true;
        }
    }

    /**
     * This method starts the game in the backend
     */
    public void startGame(){
        gameState = GameStatus.RUNNING;
        loop = new GameLoop(this);
        loop.start();
    }

    /**
     * This method returns the current game-state (In the MENU, game RUNNING or GAMEOVER)
     * @return returns the enum value of the game-state
     */
    public GameStatus getGameState(){
        return gameState;
    }

    /**
     * Get
     * @return
     */
    public Board getGrid() {
        return grid;
    }

    /**
     * Getter-method for the current shape
     * @return Returns the current shape
     */
    Shape getCurrentShape() {
        return currentShape;
    }

    boolean checkCollision3(){
        try {
            for (int i = 0; i < currentShape.getShape().length - 1; ++i) {
                for (int j = 0; j < currentShape.getShape()[i].length; ++j) {
                    if (currentShape.getShape()[i][j] != 0 && currentShape.getShape()[i + 1][j] == 0 && grid.getBoard()[currentShape.getY() + i + 1][currentShape.getX() + j] != 0) {
                        return true;
                    }
                }
            }
        }catch (IndexOutOfBoundsException e){
            eraseCurrent();
            currentShape.setX(currentShape.getX()-3);

        }
        return false;
    }

    /**
     * This method checks is the block has collided with another block
     * @return Returns wether the block has collided with another block or not
     */
    boolean checkCollision2() {
        int row = currentShape.getShape().length - 1;
        boolean bool = true;
        try {
            while (bool) {
                if (Arrays.stream(currentShape.getShape()[row]).sum() == 0) {
                    row -= 1;
                } else {
                    bool = false;
                    for (int j = 0; j < currentShape.getShape()[row].length; ++j) {
                        if (currentShape.getShape()[row][j] == 0) {
                            continue;
                        }
                        if (currentShape.getShape()[row][j] != 0 && grid.getBoard()[currentShape.getY() + row + 1][currentShape.getX() + j] != 0) {
                            return true;
                        }
                    }
                }
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.print("Right boarder reached");
            eraseCurrent();
            currentShape.setX(currentShape.getX()-3);
        }
        return false;
    }

    /**
     * This method adds a shape to the game-board
     * @param tetrisShape Determines what shape is to be added
     */
    void addShape(Shape tetrisShape){
        for (int i = 0; i < tetrisShape.getShape().length; ++i) {
            //System.out.println("");
            for (int j = 0; j < tetrisShape.getShape()[i].length; ++j) {
                int boardX = tetrisShape.getX() + j;
                int boardY = (tetrisShape.getY() + i) ;

                if (boardX >= 0 && boardX < grid.getBoard()[i].length && boardY >= 0 && boardY < grid.getBoard().length) {
                    //if(tetrisShape.getShape()[i][j] == 0){ continue;}
                    if (tetrisShape.getShape()[i][j] != 0 && grid.getBoard()[i + tetrisShape.getY()][j + tetrisShape.getX()] == 0) {
                        //System.out.print(tetrisShape.getShape()[i][j]);
                        grid.getBoard()[i + tetrisShape.getY()][j + tetrisShape.getX()] = tetrisShape.getShape()[i][j];
                    }
                }
            }
        }
    }

    /**
     * This method rotates the current shape by calling its own rotate-method, removes the shape and
     * adds it with the new rotated-shape
     */
    public void rotate(){
        eraseCurrent();
        currentShape.rotate();
        addShape(currentShape);
    }

    /**
     * This method checks if the current block has arrived at the bottom
     * If so the local boolean variable is changed to true
     * @return Returns if the block has reached the bottom of the game-board
     */
    boolean checkCollision(){
        boolean collided = false;
        if(currentShape.getY() + currentShape.getShape().length >= grid.getBoard().length -1){
            collided = true;
        }
        return collided;
    }

    /**
     * Removes the current block from the game-board, moves it and adds the block again with a new position
     * @param dir Determines the direction in which the block is going to be moved
     */
    public void moveShape(String dir){
        eraseCurrent();
        currentShape.move(dir,grid.getBoard()[0].length,grid.getBoard().length);
        addShape(currentShape);
    }

    private void eraseCurrent(){
        for (int i = 0; i < currentShape.getShape().length; i++) {
            for (int j = 0; j < currentShape.getShape()[i].length; j++) {
                try {
                    if (currentShape.getShape()[i][j] != 0) {
                        grid.getBoard()[i + currentShape.getY()][j + currentShape.getX()] = 0;
                    }
                }catch (ArrayIndexOutOfBoundsException e){

                }
            }
        }
    }
}

