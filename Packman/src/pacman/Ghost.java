package pacman;

import java.util.Random;

/**
 * Each instance of this class represents a ghost in a Pac-Man maze.
 */
public class Ghost {
	/**
	 * @immutable | isPassable(square.getRowIndex,square.getColumnIndex)
	 */
	Square square;
	Direction direction;
	
	public Square getSquare() { return square; }
	
	/**
	 * Returns the direction in which this ghost will preferably move next.
	 */
	public Direction getDirection() { return direction; }
	
	/**
	 * @post | getSquare() == square
	 * @post | getDirection() == direction
	 */
	public Ghost(Square square, Direction direction) {
		this.square = square; 
		this.direction = direction; 
		}
	
	/**
	 * @post | getSquare() == square
	 */
	 // @throws IllegalArgumentException | MazeMap.isPassable(Square.getRowIndex(),Square.getColumnIndex())
	public void setSquare(Square square) { this.square = square; }
	
	/**
	 * @post | getDirection() == direction
	 */
	public void setDirection(Direction direction) { this.direction = direction; }
	
	private static int MOVE_FORWARD_PREFERENCE = 10;
	
	// No formal document required
	public Direction chooseNextMoveDirection(Random random) {
		int moveForwardPreference = getSquare().canMove(getDirection()) ? MOVE_FORWARD_PREFERENCE : 0;
		Direction[] passableDirections = getSquare().getPassableDirectionsExcept(getDirection().getOpposite());
		if (passableDirections.length == 0)
			return getDirection().getOpposite();
		int result = random.nextInt(moveForwardPreference + passableDirections.length);
		if (result < moveForwardPreference)
			return getDirection();
		return passableDirections[result - moveForwardPreference];
	}
	
	// No formal document required
	public void move(Random random) {
		setDirection(chooseNextMoveDirection(random));
		setSquare(getSquare().getNeighbor(getDirection()));
	}
}
