package Model;

public class GameLoop extends Thread {
    private Model m;
    private boolean running = true;
    public GameLoop(Model m){
        this.m = m;
    }

    @Override
    public void run() {

        while (running) {
            try {
                if(m.getCurrentShape() == null){
                    m.newTetrisPiece();
                    m.addShape(m.getCurrentShape());
                } else if (m.checkCollision2() || m.checkCollision() || m.checkCollision3()/*gegebenheiten (Kein Block in currentShapre oder boden erreicht*/) {
                    m.getGrid().fullRow();
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