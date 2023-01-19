package Tests;

import Model.*;
import Model.GameStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    @Test
    void moveShape() {
        Model m = new Model();
        assertDoesNotThrow(() -> m.moveShape("down"));
    }

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
    @Test
    void testBoardSize(){
        Model m = new Model();
        assertEquals(25, m.getGrid().getBoard().length);
        assertEquals(10, m.getGrid().getBoard()[0].length);
    }

    @Test
    void testRotate(){
        Model m = new Model();
        assertDoesNotThrow(m::rotate);
    }

    @Test
    void testGameState(){
        Model m = new Model();
        assertDoesNotThrow(m::getGameState);
    }

    @Test
    void testShape(){
        Shape s = new Shape(3,0);
    }
}