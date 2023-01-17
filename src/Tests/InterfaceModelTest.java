package Tests;

import Model.Model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    /*
    @Test
    void moveShape() {
        Model m = new Model();
        assertDoesNotThrow(() -> m.moveShape("down"));
    }
    */
    @Test
    void testGetBoard(){
        Model m = new Model();
        assertTrue(m.getGrid().getBoard().getClass() == int[][].class);
    }
}