package Model;

import java.util.Arrays;

public class Model {
    public static void main(String[] args){
        Model m = new Model();
        //m.startGame();
        m.newTetrisPiece();
        m.addShape(m.currentShape);
        m.grid.testDraw();
        m.rotate();
        m.rotate();
        m.grid.testDraw();

        System.out.println(m.currentShape.getY());

    }
    private Board grid = new Board();
    private GameLoop loop;
    private Shape currentShape;
    private Shape lastShape = new Shape();
    public void newTetrisPiece(){
        currentShape = new Shape(3,0);

    }
    public boolean gameOver(){
        if(Arrays.stream(grid.getBoard()[4]).sum() != 0){
            System.out.println("Gameover");
            return false;
        }else {
            return true;
        }
    }
    public void startGame(){
        loop = new GameLoop(this);
        loop.start();
    }

    public Board getGrid() {
        return grid;
    }

    public Shape getCurrentShape() {
        return currentShape;
    }

    public boolean checkCollision3(){
        for (int i = 0; i < currentShape.getShape().length-1; ++i) {
            for (int j = 0; j < currentShape.getShape()[i].length; ++j) {
                if (currentShape.getShape()[i][j] != 0) {
                    if (currentShape.getShape()[i + 1][j] == 0) {
                        if (grid.getBoard()[currentShape.getY() + i + 1][currentShape.getX() + j] != 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean checkCollision2() {
        int row = currentShape.getShape().length - 1;
        boolean bool = true;
        while(bool){
            if(Arrays.stream(currentShape.getShape()[row]).sum() == 0){
                row -= 1;
            } else{
                bool = false;
                for(int j = 0; j < currentShape.getShape()[row].length; ++j){
                    if(currentShape.getShape()[row][j] == 0){
                        continue;
                    }
                    if(currentShape.getShape()[row][j] != 0){
                        if(grid.getBoard()[currentShape.getY() + row + 1][currentShape.getX() + j] != 0){
                            return true;
                        }
                    }
                }
            }
        } return false;
    }

    public void addShape(Shape tetrisShape){
        for (int i = 0; i < tetrisShape.getShape().length; ++i) {
            for (int j = 0; j < tetrisShape.getShape()[i].length; ++j) {
                int boardX = tetrisShape.getX() + j;
                int boardY = (tetrisShape.getY() + i) ;

                if (boardX >= 0 && boardX < grid.getBoard()[i].length && boardY >= 0 && boardY < grid.getBoard().length) {
                    for (int n = 0; n < tetrisShape.getShape().length; n++) {
                        for (int k = 0; k < tetrisShape.getShape()[n].length; k++) {
                            if (tetrisShape.getShape()[n][k] != 0 && grid.getBoard()[n + tetrisShape.getY()][k + tetrisShape.getX()] == 0) {
                                grid.getBoard()[n + tetrisShape.getY()][k + tetrisShape.getX()] = tetrisShape.getShape()[n][k];
                            }
                        }
                    }
                }
            }
        }
    }
    public void rotate(){
        currentShape.rotate();
        eraseCurrent();
        addShape(currentShape);
    }
    public boolean checkCollision(){
        boolean collisided = false;
        if(currentShape.getY() + currentShape.getShape().length >= grid.getBoard().length -1 ||
                currentShape.getIsCollided()){
            collisided = true;
        }
        return collisided;
    }
    public void moveShape(String dir){
        eraseCurrent();
        currentShape.move(dir,grid.getBoard()[0].length,grid.getBoard().length,grid.getBoard());
        addShape(currentShape);
    }

    private void eraseCurrent(){
        lastShape.setShape(currentShape.getShape());
        lastShape.setX(currentShape.getX());
        lastShape.setY(currentShape.getY());

        for (int i = 0; i < lastShape.getShape().length; ++i) {
            for (int j = 0; j < lastShape.getShape()[i].length; ++j) {
                int boardX = lastShape.getX() + j;
                int boardY = (lastShape.getY() + i) ;
                if (boardX >= 0 && boardX < grid.getBoard()[i].length && boardY >= 0 && boardY < grid.getBoard().length) {
                    grid.getBoard()[boardY][boardX] = 0;
                }
            }
        }
    }
}
