package pacman;

/**
 * Each instance of this class represents a maze layout, specifying the width and height of the maze
 * and, for each position in the maze, whether it is passable or not.
 */
public class MazeMap {
	
	/**
	 * @invar | width > 0
	 * @invar | height > 0
	 * @invar | passable.length == width*height
	 */
	private int width;
	private int height;
	private boolean[] passable;

	/**
	 * Returns the width (i.e. the number of columns) of this maze map.
	 * @post | result > 0
	 */
	public int getWidth() { return width; }
	
	/**
	 * Returns the height (i.e. the number of rows) of this maze map.
	 * @post | result > 0
	 */
	public int getHeight() { return height; }
	
	/**
	 * Returns whether the square in this maze at row index {@code row} and column index {@code column} is passable.
	 * The square in the top-left corner of the maze has row index 0 and column index 0.
	 * @throws IllegalArgumentException | rowIndex < 0 || rowIndex >= getHeight()
	 * @throws IllegalArgumentException | columnIndex < 0 || rowIndex >= getWidth()
	 */
	public boolean isPassable(int rowIndex, int columnIndex) { 
		if (rowIndex < 0 || rowIndex >= height)
			throw new IllegalArgumentException();
		if (columnIndex < 0 || columnIndex >= width)
			throw new IllegalArgumentException();
		return passable[rowIndex*width+columnIndex]; 
		}
	
	/**
	 * Initializes this object so that it represents a maze layout with the given width, height, and
	 * passable positions. The passable positions are given in row-major order (i.e. the first {@code width} elements
	 * of {@code passable} specify the passability of the maze positions in the first row of the maze). 
	 * @trows IllegalArgumentException | width <= 0
	 * @trows IllegalArgumentException | heigth <= 0
	 * @trows IllegalArgumentException | passable.lenght != width*height
	 * @post | getWidth() == width
	 * @post | getHeight() == height
	 */
	// Ik denk dat er nog een postconditie toegevoegd moet worden over passable maar daar ben ik niet helemaal zeker van
	public MazeMap(int width, int height, boolean[] passable) {
		if (width <= 0)
			throw new IllegalArgumentException("the width must be a strictly positive number");
		if (height <= 0)
			throw new IllegalArgumentException("the height must be a strictly positive number");
		if (passable.length != width*height)
			throw new IllegalArgumentException("there must be as many arguments in the boolean[] passable as there are squares in the maze");
		this.width = width;
		this.height = height;
		this.passable = passable;
	}

}
