package pacman;

import java.util.Arrays;
import java.util.List;

/**
 * Each instance of this class represents a position in a maze, specified by a row index and a column index.
 * The top row and the leftmost column have index 0.
 */
public class Square {
	/**
	 * @invar | 0 <= rowIndex
	 * @invar | 0 <= columnIndex
	 * @invar | mazeMap != null
	 */
	private MazeMap mazeMap;
	private int rowIndex;
	private int columnIndex;
	
	/**
	 * @basic
	 */
	public MazeMap getMazeMap() { return mazeMap; }
	
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
	
	public boolean isPassable() { 
		return getMazeMap().isPassable(getRowIndex(), getColumnIndex());}
	
	/**
	 * @throws IllegalArugementException | mazeMap == null
	 * @creates | result
	 */
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
		int new_columnIndex = columnIndex;
		int new_rowIndex = rowIndex;
		if (direction == Direction.LEFT)
			if (columnIndex == 0)
				new_columnIndex = mazeMap.getWidth() - 1;
			else
				new_columnIndex--;		
			
		if (direction == Direction.RIGHT)
			if (columnIndex == mazeMap.getWidth() - 1)
				new_columnIndex = 0;
			else
				new_columnIndex++;
			
		if (direction == Direction.DOWN)
			if (rowIndex == mazeMap.getHeight() - 1)
				new_rowIndex = 0;
			else
				new_rowIndex++;
			
		if (direction == Direction.UP)
			if (rowIndex == 0)
				new_rowIndex = mazeMap.getHeight() - 1;
			else
				new_rowIndex--;
		return of(mazeMap, new_rowIndex, new_columnIndex);	
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
	public Direction[] getPassableDirectionsExcept(Direction excludedDirection) {
		Direction[] directions = new Direction[4];
		int elements = 0;
		for (int i = 0; i < Direction.values().length ; i++)
			if (canMove(Direction.values()[i]) && Direction.values()[i] != excludedDirection) { 
				directions[i] = Direction.values()[i];
				elements ++;
			}
				
		Direction[] result = new Direction[elements];				
		int k = 0;		
		for (int i = 0; i < directions.length; i++) {
			if (directions[i] == null) {
				k++;
			}
			else {
				result[i-k] = directions[i];
			}
		}
			
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
