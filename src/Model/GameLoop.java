package Model;

/**
 * The GameLoop class represents the running game. Using Threads the game speed can be adjusted.
 * While the game is running, it checks for full rows, collided Blocks (adds a new Block to the game if so) and
 * makes the current Block fall.
 */
public class GameLoop extends Thread {
    private Model m;
    private boolean running = true;
    public GameLoop(Model m){
        this.m = m;
    }

    @Override
    /**
     * The run-method starts the game, while the while-loop keeps it running
     */
    public void run() {

        while (running) {
            try {
                if(m.getCurrentShape() == null){
                    m.newTetrisPiece();
                    m.addShape(m.getCurrentShape());
                } else if (m.checkCollision2() || m.checkCollision() || m.checkCollision3()/*gegebenheiten (Kein Block in currentShapre oder boden erreicht*/) {
                    m.getGrid().fullRow();
                    running = m.gameOver();
                    m.newTetrisPiece();
                    m.addShape(m.getCurrentShape());
                }
                    m.moveShape("down");
                    //m.getGrid().testDraw();
                sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}