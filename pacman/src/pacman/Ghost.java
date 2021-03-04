package pacman;

import java.util.Random;

/**
 * Each instance of this class represents a ghost in a Pac-Man maze.
 */
public class Ghost {
	/**
	 * @immutable
	 */
	// hier moet volgens mij private voorstaan
	private Square square;
	private Direction direction;
	
	// niet zeker dat @basic
	public Square getSquare() { return square; }
	
	/**
	 * Returns the direction in which this ghost will preferably move next.
	 */
	// niet zeker dat @basic
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
	 * @throws IllegalArgumentException | !square.getMazeMap().isPassable(square.getRowIndex(),square.getColumnIndex())
	 * @post | getSquare() == square
	 */
	public void setSquare(Square square) {
		if (!square.getMazeMap().isPassable(square.getRowIndex(),square.getColumnIndex()))
			throw new IllegalArgumentException("The ghost can only be placed on passable places");
		this.square = square; }
	
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
