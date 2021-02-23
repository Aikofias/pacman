package pacman;

/**
 * Each instance of this class represents the player-controlled Pac-Man character in a Pac-Man maze.
 */
public class PacMan {
	/**
	 * @invar | nbLives >= 0
	 */
	int nbLives;
	Square square;

	public Square getSquare() { return square; }
	
	public int getNbLives() { return nbLives; }

	public PacMan(int nbLives, Square square) {
		this.nbLives = nbLives;
		this.square = square;
	}
	
	/**
	 * @post | getSquare() == square
	 */
	public void setSquare(Square square) { this.square = square; }
	
	/**
	 * Decreases this Pac-Man character's number of lives by one.
	 * @throws IllegalStateException | getNbLives() <=0
	 */
	public void die() { 
		if (nbLives <= 0)
			throw new IllegalStateException("You are already dead");
		nbLives--; }

}
