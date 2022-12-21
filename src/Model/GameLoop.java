package Model;

public class GameLoop extends Thread {
    private Model m;
    private boolean running = true;
    public GameLoop(Model m){
        this.m = m;
    }

    @Override
    public void run() {
        m.newTetrisPiece();
        m.addShape(m.getCurrentShape());
        while (running) {
            try {
                if (m.checkCollision() || m.getCurrentShape() == null/*gegebenheiten (Kein Block in currentShapre oder boden erreicht*/) {
                    m.newTetrisPiece();
                    m.addShape(m.getCurrentShape());
                } else {
                    m.moveShape("down");
                }
                m.getGrid().testDraw();
                //running = m.gameOver();
                sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();

            }
        }
    }
}