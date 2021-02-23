package pacman.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pacman.Direction;
import pacman.Ghost;
import pacman.MazeMap;
import pacman.Square;

class GhostTest {

	@Test
	void test() {
		MazeMap myMazeMap = new MazeMap(2,3,new boolean[] {true,false,true,true,true,false});
		Square mySquare = Square.of(myMazeMap, 1, 1);
		Ghost myghost = new Ghost(mySquare, Direction.LEFT);
		assert myghost.getDirection() == Direction.LEFT;
		assert myghost.getSquare() == mySquare;
		myghost.setDirection(Direction.RIGHT);
		Square newSquare = Square.of(myMazeMap, 2, 0);
		myghost.setSquare(newSquare);
		assert myghost.getDirection() == Direction.RIGHT;
		assert myghost.getSquare() == newSquare;
	}

}
