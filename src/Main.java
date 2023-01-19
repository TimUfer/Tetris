import processing.core.PApplet;
import Model.Model;
import Controller.Controller;
import View.View;

public abstract class Main {
    public static void main(String[] args) {
        var model = new Model();
        var controller = new Controller(model);
        var view = new View();
        controller.setView(view);
        view.setController(controller);
        PApplet.runSketch(new String[]{"View"}, view);
    }
}
