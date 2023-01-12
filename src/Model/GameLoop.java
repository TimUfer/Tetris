package Model;

/**
 * The GameLoop class represents the running game. Using Threads the game speed can be adjusted
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

               // m.getGrid().testDraw();
                //running = m.gameOver();
                sleep(500);
            } catch (InterruptedException e){
                e.printStackTrace();

            }
        }
    }
}