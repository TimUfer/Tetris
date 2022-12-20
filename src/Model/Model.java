package Model;

public class Model {
    public static void main(String[] args){
        Model m = new Model();
        m.newTetrisPiece();
        System.out.println(m.currentShape.getY());

        m.addShape(m.currentShape);
        m.grid.testDraw();
        //m.currentShape.rotate();
        m.currentShape.rotate();
        m.moveShape("left");

        m.grid.testDraw();
        System.out.println(m.currentShape.getY());

    }
    private Board grid = new Board();
    private Shape currentShape;
    private Shape lastShape = new Shape();
    public void newTetrisPiece(){
        currentShape = new Shape(3,0);

    }
    public void addShape(Shape tetrisShape){
        for (int i = 0; i < tetrisShape.getShape().length; ++i) {
            for (int j = 0; j < tetrisShape.getShape()[i].length; ++j) {
                int boardX = tetrisShape.getX() + j;
                int boardY = (tetrisShape.getY() + i) ;
                if (boardX >= 0 && boardX < grid.getBoard()[i].length && boardY >= 0 && boardY < grid.getBoard().length) {
                    grid.getBoard()[boardY][boardX] = tetrisShape.getShape()[i][j];
                }
            }
        }
    }
    public void moveShape(String dir){
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
        currentShape.move(dir,grid.getBoard()[0].length,grid.getBoard().length,grid.getBoard());
        addShape(currentShape);
    }
}
