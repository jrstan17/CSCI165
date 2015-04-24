package lab9;

public class Grid {
    protected Shape[][] grid;

    public Grid() {
	grid = new Shape[Properties.GRID_SIZE + 2][Properties.GRID_SIZE + 2];
    }

    public void draw() {
	for (int i = Properties.GRID_SIZE; i >= 0; i--) {
	    for (int j = 0; j <= Properties.GRID_SIZE; j++) {

		if (i == 0 || j == 0) {
		    if (grid[j][i] == null) {
			System.out.print(Properties.GRID_CHAR);
		    } else {
			grid[j][i].draw();
		    }
		} else {
		    if (grid[j][i] == null) {
			System.out.print(" ");
		    } else {
			grid[j][i].draw();
		    }
		}
		System.out.print(" ");
	    }
	    System.out.println("");
	}
	System.out.println("");
    }

    public void printStatus() {
	for (int i = 0; i <= Properties.GRID_SIZE; i++) {
	    for (int j = 0; j <= Properties.GRID_SIZE; j++) {
		if (grid[i][j] != null) {
		    System.out.println(grid[i][j]);
		}
	    }
	}
    }

    public Shape[][] getGrid() {
	return grid;
    }

    public void setGrid(Shape[][] grid) {
	this.grid = grid;
    }
}
