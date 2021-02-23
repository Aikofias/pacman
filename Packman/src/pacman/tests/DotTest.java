package pacman.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pacman.Dot;
import pacman.MazeMap;
import pacman.Square;

class DotTest {

	@Test
	void test() {
		MazeMap myMazeMap = new MazeMap(2,3,new boolean[] {true,false,true,true,true,false});
		Square mySquare = Square.of(myMazeMap, 1, 1);
		Dot myDot = new Dot(mySquare);
		assert myDot.getSquare() == mySquare;		
	}

}
