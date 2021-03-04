package pacman;

/**
 * Each instance of this class represents a dot (a piece of food for Pac-Man) in a Pac-Man maze.
 */

public class Dot {
	// er moet volgens mij niets staan achter immutable
	/**
	 * @immutable
	 */
	private Square square;
	/**
	 * @creates | result
	 * @post | result != null
	 */
	public Square getSquare() { 
		Square new_square = square;
		return new_square; }
	
	/**
	 * @post | getSquare() == square
	 */
	public Dot(Square square) { this.square = square ; }

}
