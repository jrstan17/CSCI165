package lab8;

public class Hobbit extends Organism {
    
    public Hobbit() {
	this.organismChar = Properties.HOBBIT_CHAR;
    }

    @Override
    public void move(Board board, int row, int col) {
	
	this.row = row;
	this.col = col;
	
	getValidDirection(board);

	if (!areAllDirectionsFailed()) {
	    board.getBoard()[nextRow][nextCol] = this;
	    board.getBoard()[row][col] = null;

	    int[] newPosition = new int[2];
	    newPosition[0] = nextRow;
	    newPosition[1] = nextCol;

	    board.setMovedOrganisms(newPosition);
	}
	
	randomDirection = 0;
	clearDirectionsFailed();

	breedIterations++;

	if (breedIterations == Properties.HOBBIT_BREED_ITERATIONS) {
	    this.row = nextRow;
	    this.col = nextCol;
	    breed(board);
	}
	
	nextRow = 0;
	nextCol = 0;
    }

    @Override
    public void breed(Board board) {
	breedIterations = 0;

	getValidDirection(board);

	if (!areAllDirectionsFailed()) {
	    board.getBoard()[nextRow][nextCol] = new Hobbit();

	    int[] newPosition = new int[2];
	    newPosition[0] = nextRow;
	    newPosition[1] = nextCol;

	    board.setMovedOrganisms(newPosition);
	}

	nextRow = 0;
	nextCol = 0;
	randomDirection = 0;
	clearDirectionsFailed();
    }
    
    public void getValidDirection(Board board) {
	do {
	    randomDirection = rnd.nextInt(Direction.RIGHT) + Direction.UP;
	    nextRow = 0;
	    nextCol = 0;

	    if (randomDirection == Direction.UP) {
		if (row == 1) {
		    nextRow = Properties.BOARD_ROWS;
		} else {
		    nextRow = row - 1;

		}
		nextCol = col;

		if (board.getBoard()[nextRow][nextCol] != null) {
		    directionsFailed.set(Direction.UP, true);
		}
	    }

	    else if (randomDirection == Direction.DOWN) {
		if (row == Properties.BOARD_ROWS) {
		    nextRow = 1;
		} else {
		    nextRow = row + 1;

		}
		nextCol = col;

		if (board.getBoard()[nextRow][nextCol] != null) {
		    directionsFailed.set(Direction.DOWN, true);
		}
	    }

	    else if (randomDirection == Direction.LEFT) {
		if (col == 1) {
		    nextCol = Properties.BOARD_COLS;
		} else {

		    nextCol = col - 1;
		}
		nextRow = row;

		if (board.getBoard()[nextRow][nextCol] != null) {
		    directionsFailed.set(Direction.LEFT, true);
		}
	    }

	    else {
		if (col == Properties.BOARD_COLS) {
		    nextCol = 1;
		} else {

		    nextCol = col + 1;
		}
		nextRow = row;

		if (board.getBoard()[nextRow][nextCol] != null) {
		    directionsFailed.set(Direction.RIGHT, true);
		}
	    }

	} while (board.getBoard()[nextRow][nextCol] != null
		&& areAllDirectionsFailed() == false);
    }

}
