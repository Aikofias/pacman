package pacman.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pacman.MazeMap;

class MazeMapTest {

	@Test
	void test() {
		MazeMap myMazeMap = new MazeMap(2,3,new boolean[] {true,false,true,true,true,false});
		assert myMazeMap.getWidth() == 2;
		assert myMazeMap.getHeight() == 3;
		assert myMazeMap.isPassable(0, 0) == true;
		assert myMazeMap.isPassable(0, 1) == false;
		assert myMazeMap.isPassable(1, 1) == true;
		assert myMazeMap.isPassable(2, 1) == false;
	}
}