package pacman.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pacman.MazeMap;
import pacman.PacMan;
import pacman.Square;

class PacManTest {

	@Test
	void test() {
		MazeMap myMazeMap = new MazeMap(2,3,new boolean[] {true,false,true,true,true,false});
		Square mySquare = Square.of(myMazeMap, 1, 1);
		PacMan myPacMan = new PacMan(3,mySquare);
		assert myPacMan.getNbLives() == 3;
		assert myPacMan.getSquare() == mySquare;
		myPacMan.die();
		myPacMan.die();
		myPacMan.die();
		assert myPacMan.getNbLives() == 0;
		Square newSquare = Square.of(myMazeMap, 2, 0);
		myPacMan.setSquare(newSquare);
		assert myPacMan.getSquare() == newSquare;
	}

}
