package Model;

public class GameLoop extends Thread {
    Model m = new Model();
    private boolean running = true;

    @Override
    public void run() {
        while (running) {
            try {
                if (/*gegebenheiten (Kein Block in currentShapre oder boden erreicht*/) {
                    m.newTetrisPiece();
                } else {
                    m.moveShape("down");
                }
                sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();

        }
    }
}
}