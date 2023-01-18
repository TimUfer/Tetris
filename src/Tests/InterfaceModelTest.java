package Tests;

import Model.Model;
import Model.GameStatus;
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
    void testStartGame() {
        Model m = new Model();
        assertDoesNotThrow(m::startGame);
    }
    @Test
    void testGetBoard(){
        Model m = new Model();
        assertTrue(m.getGrid().getBoard().getClass() == int[][].class);
    }

    @Test
    void testGetGamestate(){
        Model m = new Model();
        assertSame(m.getGameState(), GameStatus.MENU);
    }
}