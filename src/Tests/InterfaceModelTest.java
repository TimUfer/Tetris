package Tests;

import Model.*;
import Model.GameStatus;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
    void testGetGrid(){
        Model m = new Model();
        Board b = new Board();
        assertTrue(m.getGrid().getClass() == b.getClass());
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
    void testEmptyBoard(){
        Board b = new Board();
        int[][] e = new int[25][10];
        for(int[] i: e){
            Arrays.fill(i,0);
        }

        for(int i = 0; i < b.getBoard().length; ++i) {
            for(int j = 0; j < b.getBoard()[0].length; ++j){
                assertTrue(b.getBoard()[i][j] == e[i][j]);
            }
        }
    }
}