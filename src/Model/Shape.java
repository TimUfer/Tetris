package Model;

import java.util.Arrays;
import java.util.Random;

/**
 * The shape class represents a Tetris block
 */
public class Shape {
    private int[][] shape;
    private int x,y;

    /**
     * The constructor creates a new random shape by calling the selectRandomShape method
     * @param x Initial X coordinate
     * @param y Initial Y coordinate
     */
    public Shape(int x, int y){
        this.shape = selectRandomShape();
        this.x = x;
        this.y = y;
    }
    public Shape(){
    }

    /**
     * Getter-method for the X coordinate
     * @return Returns the X coordinate
     */
    int getX() {
        return x;
    }

    /**
     * Setter-method for the X coordinate
     * @param x New X coordinate
     */
    void setX(int x) {
        this.x = x;
    }
    /**
     * Getter-method for the Y coordinate
     * @return Returns the Y coordinate
     */
    int getY() {
        return y;
    }
    /**
     * Setter-method for the Y coordinate
     * @param y New X coordinate
     */
    void setY(int y) {
        this.y = y;
    }

    /**
     * Getter-method for the shape
     * @return returns the shape
     */
    int[][] getShape() {
        return shape;
    }

    /**
     * Setter-method for the shape
     * @param shape The value, shape is set to
     */
    void setShape(int[][] shape) {
        this.shape = shape;
    }

    /**
     * This method has access to the X and Y coordinates and can manipulate them if wanted
     * @param input Determines in what direction the shape should move
     * @param gameBoardWidth The width also determines the right-hand boarder for the game-board
     * @param gameBoardHeight The height determines the bottom boarder for the game-board
     */
    void move(String input, int gameBoardWidth, int gameBoardHeight) {
        int oldX = x;
        int oldY = y;
        if (input.equals("left")) {
            x -= 1;
        } else if (input.equals("right")) {
            x += 1;
        } else if (input.equals("down")) {
            y += 1;
        }

        if (x < 0 || y + shape.length > gameBoardHeight) {
            x = oldX;
            y = oldY;
        }
        int count = 0;
        for(int col = shape[0].length-1; col > 0; --col){
            --count;
            for(int row = 0; row < shape.length; ++row){
                if(shape[row][col] != 0){
                    if(x + count + shape[0].length > gameBoardWidth){
                        x = oldX;
                    }
                }
            }
        }


    }

    /**
     * This method rotates the shape and makes sure that the bottom "line" is never filled with zeros
     */
    void rotate() {
        int[][] rotatedShape = new int[shape.length][shape[0].length];
        for (int i = 0; i < shape.length; ++i) {
            for (int j = 0; j < shape[i].length; ++j) {
                rotatedShape[j][shape.length - i - 1] = shape[i][j];
            }
        }
       if(Arrays.stream(rotatedShape[rotatedShape.length-1]).sum() == 0 && rotatedShape[0][1] != 4){
            for(int i = rotatedShape.length-1; i > 0 ; --i){
                for(int j = 0; j < rotatedShape[i].length; ++j){
                    rotatedShape[i][j] = rotatedShape[i-1][j];
                }
            }
            Arrays.fill(rotatedShape[0],0);
        }
        shape = rotatedShape;
    }

    private int[][] selectRandomShape(){
        Random rand = new Random();
        int[][] tempShape = {};
        int shapeNR = rand.nextInt(1,7);
        switch (shapeNR){
            case 1 -> tempShape = new int[][]{
                    {0,0,0},
                    {0,1,0},
                    {1,1,1}
            };
            case 2 -> tempShape = new int[][]{
                    {0,0,0},
                    {0,0,2},
                    {2,2,2}
            };
            case 3 -> tempShape = new int[][]{
                    {0,0,0},
                    {3,3,0},
                    {0,3,3}
            };
            case 4 -> tempShape = new int[][]{
                    {4,4},
                    {4,4}
            };
            case 5 -> tempShape = new int[][]{
                    {5,0,0,0},
                    {5,0,0,0},
                    {5,0,0,0},
                    {5,0,0,0}
            };
            case 6 -> tempShape = new int[][]{
                    {0,0,0},
                    {6,0,0},
                    {6,6,6}

            };
            case 7 -> tempShape = new int[][]{
                    {0,0,0},
                    {0,7,7},
                    {7,7,0}
            };
            default -> System.out.println("Unusable value (Random int)" + shapeNR);
        }
        return tempShape;
    }
}
