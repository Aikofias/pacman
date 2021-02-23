package pacman.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pacman.Direction;
import pacman.MazeMap;
import pacman.Square;

class SquareTest {

	@Test
	void test() {
		MazeMap myMazeMap = new MazeMap(2,3,new boolean[] {true,false,true,true,true,false});
		Square mySquare = Square.of(myMazeMap, 1, 1);
		assert mySquare.getMazeMap() == myMazeMap;
		assert mySquare.getRowIndex() == 1;
		assert mySquare.getColumnIndex() == 1;
		assert mySquare.getNeighbor(Direction.LEFT).getColumnIndex() == Square.of(myMazeMap, 1, 0).getColumnIndex();
		assert mySquare.getNeighbor(Direction.LEFT).getRowIndex() == Square.of(myMazeMap, 1, 0).getRowIndex();
		assert mySquare.getNeighbor(Direction.RIGHT).getColumnIndex() == Square.of(myMazeMap, 1, 0).getColumnIndex();
		assert mySquare.getNeighbor(Direction.RIGHT).getRowIndex() == Square.of(myMazeMap, 1, 0).getRowIndex();
		assert mySquare.getNeighbor(Direction.UP).getColumnIndex() == Square.of(myMazeMap, 0, 1).getColumnIndex();
		assert mySquare.getNeighbor(Direction.UP).getRowIndex() == Square.of(myMazeMap, 0, 1).getRowIndex();	
		assert mySquare.getNeighbor(Direction.DOWN).getColumnIndex() == Square.of(myMazeMap, 2, 1).getColumnIndex();
		assert mySquare.getNeighbor(Direction.DOWN).getRowIndex() == Square.of(myMazeMap, 2, 1).getRowIndex();
		assert mySquare.canMove(Direction.LEFT) == true;
		assert mySquare.canMove(Direction.RIGHT) == true;
		assert mySquare.canMove(Direction.UP) == false;
		assert mySquare.canMove(Direction.DOWN) == false;
		
	}

}
