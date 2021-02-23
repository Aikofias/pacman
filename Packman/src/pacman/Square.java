package pacman;

import java.util.Arrays;


/**
 * Each instance of this class represents a position in a maze, specified by a row index and a column index.
 * The top row and the leftmost column have index 0.
 */
public class Square {
	/**
	 */
	private MazeMap mazeMap;
	private int rowIndex;
	private int columnIndex;
	
	public MazeMap getMazeMap() {return mazeMap;}
	
	/**
	 * @basic
	 * @post | result >= 0
	 */
	public int getRowIndex() { return rowIndex; }
	
	/**
	 * @basic
	 * @post | result >= 0
	 */
	public int getColumnIndex() { return columnIndex; }
	
	public boolean isPassable() { return getMazeMap().isPassable(getRowIndex(), getColumnIndex());}
	

	/**
	 * @throws IllegalArugementException | mazeMap == null
	 * @creates
	 */
	//Ik ben niet echt zeker of dit is wat deze functie zou moeten doen
	public static Square of(MazeMap mazeMap, int rowIndex, int columnIndex) {
		if (mazeMap == null)
			throw new IllegalArgumentException("The MazeMap must not be null");
		Square result = new Square();
		result.mazeMap = mazeMap;
		result.rowIndex = rowIndex;
		result.columnIndex = columnIndex;
		return result;
	}
	
	/**
	 * Returns this square's neighbor in the given direction.
	 * If this square has no neigbor in the given direction, return the square that is furthest away in the opposite direction.
	 */
	// No formal documentation required
	public Square getNeighbor(Direction direction) {
		// Implementation hint: use method java.lang.Math.floorMod.
		if (direction == direction.RIGHT) {
			if (columnIndex < mazeMap.getWidth()-1)
				columnIndex ++;
			else
				columnIndex = 0;
		}
		if (direction == direction.LEFT) {
			if (columnIndex > 0)
				columnIndex--;
			else
				columnIndex = mazeMap.getWidth() - 1;
		}
		if (direction == direction.DOWN) {
			if (rowIndex < mazeMap.getHeight()-1)
				rowIndex ++;
			else
				rowIndex = 0;
		}
		if (direction == direction.UP) {
			if (rowIndex > 0)
				rowIndex--;
			else
				rowIndex = mazeMap.getHeight() - 1;
		}
		return of(mazeMap, rowIndex, columnIndex);
	}

	/**
	 * Returns whether this square's neighbor in the given direction is passable.
	 */
	// No formal documentation required
	public boolean canMove(Direction direction) {
		Square neighborSquare = getNeighbor(direction);
		return neighborSquare.isPassable();
	}

	/**
	 * Returns the directions that are different from the given excluded direction and such that the neighbor in that direction is passable.
	 * The returned array shall have no null elements and shall have no duplicates.
	 */
	// No formal documentation required
	// Veel te lange code geschreven die volgens mij wel werkt maar ik denk wel dat het korter kan
	public Direction[] getPassableDirectionsExcept(Direction excludedDirection) {
		Direction[] directions = new Direction[4];
		int nbArgs = 0;
		if (canMove(Direction.RIGHT) && Direction.RIGHT != excludedDirection) 
		directions[0] = Direction.RIGHT;	
		if (canMove(Direction.LEFT) && Direction.LEFT != excludedDirection) 
		directions[1] = Direction.LEFT;	
		if (canMove(Direction.UP) && Direction.UP != excludedDirection) 
		directions[2] = Direction.UP;	
		if (canMove(Direction.DOWN) && Direction.DOWN != excludedDirection) 
		directions[3] = Direction.DOWN;
		for (int i = 0; i<=3; i++) {
			if (directions[i] != null)
				nbArgs++;
		}
		Direction[] result = new Direction[nbArgs];
		if (canMove(Direction.RIGHT) && Direction.RIGHT != excludedDirection) { 
			result[0] = Direction.RIGHT;
			if (canMove(Direction.LEFT) && Direction.LEFT != excludedDirection) {
				result[1] = Direction.LEFT;
					if (canMove(Direction.UP) && Direction.UP != excludedDirection) {
						result[2] = Direction.UP;
						if (canMove(Direction.DOWN) && Direction.DOWN != excludedDirection)
							result[3] = Direction.DOWN;
					}
					else if (canMove(Direction.DOWN) && Direction.DOWN != excludedDirection)
						result[2] = Direction.DOWN;
				}
			else if (canMove(Direction.UP) && Direction.UP != excludedDirection) 
				result[1] = Direction.UP;
			else if (canMove(Direction.DOWN) && Direction.DOWN != excludedDirection) 
				result[1] = Direction.DOWN;
		}
		else if (canMove(Direction.LEFT) && Direction.LEFT != excludedDirection) {
			result[0] = Direction.LEFT;	
			if (canMove(Direction.UP) && Direction.UP != excludedDirection) { 
				result[1] = Direction.UP;
				if (canMove(Direction.DOWN) && Direction.DOWN != excludedDirection) 
					result[2] = Direction.DOWN; 
			}
			else if (canMove(Direction.DOWN) && Direction.DOWN != excludedDirection) 
				result[1] = Direction.DOWN; 
		}
		else if (canMove(Direction.UP) && Direction.UP != excludedDirection) {
			result[0] = Direction.UP;
			if (canMove(Direction.DOWN) && Direction.DOWN != excludedDirection) 
				result[1] = Direction.DOWN; 
		}
		else if (canMove(Direction.DOWN) && Direction.DOWN != excludedDirection) 
			result[0] = Direction.DOWN; 
		
		return result;
	}
	
	/**
	 * Returns whether the given square refers to the same {@code MazeMap} object and has the same row and column index as this square.  
	 */
	public boolean equals(Square other) {
		return getMazeMap() == other.getMazeMap() 
				&& getRowIndex() == other.getRowIndex()
				 && getColumnIndex() == other.getColumnIndex();
	}
}
