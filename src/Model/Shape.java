package Model;

import java.util.Random;

public class Shape {
    private int[][] shape;
    private int x,y;
    public Shape(int x, int y){
        this.shape = selectRandomShape();
        this.x = x;
        this.y = y;
    }
    public Shape(){
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[][] getShape() {
        return shape;
    }

    public void setShape(int[][] shape) {
        this.shape = shape;
    }

    public void move(String input, int gameBoardWidth, int gameBoardHeight, int[][] gameBoard) {
        int oldX = x;
        int oldY = y;
        if (input.equals("left")) {
            x -= 1;
        } else if (input.equals("right")) {
            x += 1;
        } else if (input.equals("down")) {
            y += 1;
        }

        if (x < 0 || x + shape[0].length > gameBoardWidth || y + shape.length > gameBoardHeight) {
            x = oldX;
            y = oldY;
        }

        for (int i = 0; i < shape.length; ++i) {
            for (int j = 0; j < shape[i].length; ++j) {
                if (shape[i][j] != 0 && gameBoard[y + i][x + j] != 0) {
                    x = oldX;
                    y = oldY;
                    break;
                }
            }
        }
    }

    public void rotate() {
        int[][] rotatedShape = new int[shape.length][shape[0].length];
        for (int i = 0; i < shape.length; ++i) {
            for (int j = 0; j < shape[i].length; ++j) {
                rotatedShape[j][shape.length - i - 1] = shape[i][j];
            }
        }
        shape = rotatedShape;
    }

    int[][] selectRandomShape(){
        Random rand = new Random();
        int[][] tempShape = {};
        int shapeNR = rand.nextInt(1,7);
        switch (shapeNR){
            case 1 -> tempShape = new int[][]{
                    {0,1,0},
                    {1,1,1},
                    {0,0,0},
            };
            case 2 -> tempShape = new int[][]{
                    {0,0,2},
                    {2,2,2},
                    {0,0,0},
            };
            case 3 -> tempShape = new int[][]{
                    {3,3,0},
                    {0,3,3},
                    {0,0,0},
            };
            case 4 -> tempShape = new int[][]{
                    {4,4},
                    {4,4}
            };
            case 5 -> tempShape = new int[][]{
                    {0,5,0,0},
                    {0,5,0,0},
                    {0,5,0,0},
                    {0,5,0,0}
            };
            case 6 -> tempShape = new int[][]{
                    {6,0,0},
                    {6,6,6},
                    {0,0,0}
            };
            case 7 -> tempShape = new int[][]{
                    {0,7,7},
                    {7,7,},
                    {0,0,0}
            };
            default -> System.out.println("Unusable value (Random int)" + shapeNR);
        }
        return tempShape;
    }
}
