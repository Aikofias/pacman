package pacman;

/**
 * Each instance of this class represents a dot (a piece of food for Pac-Man) in a Pac-Man maze.
 */
public class Dot {
	/**
	 * @immutable | isPassable(square.getRowIndex,square.getColumnIndex)
	 */
	private Square square;
	
	public Square getSquare() { 
		return square; }
	
	/**
	 * @post | getSquare() == square
	 */
	public Dot(Square square) { this.square = square; }

}
