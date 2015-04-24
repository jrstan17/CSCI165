package lab8;

import java.util.ArrayList;
import java.util.Random;

public class Nazgul extends Organism {

    private int starveIterations = 0;

    public Nazgul() {
	this.organismChar = Properties.NAZGUL_CHAR;
    }

    @Override
    public void move(Board board, int row, int col) {
	this.row = row;
	this.col = col;

	int[] locationOfAdjacentHobbit = locationOfHobbitToEat(board);

	if (locationOfAdjacentHobbit == null) {
	    getValidDirection(board);
	    starveIterations++;
	} else {
	    starveIterations = 0;
	    nextRow = locationOfAdjacentHobbit[0];
	    nextCol = locationOfAdjacentHobbit[1];
	}

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

	if (breedIterations == Properties.NAZGUL_BREED_ITERATIONS) {
	    this.row = nextRow;
	    this.col = nextCol;
	    breed(board);
	}

	if (starveIterations == Properties.NAZGUL_STARVE_ITERATIONS) {
	    starve(board);
	}

	nextRow = 0;
	nextCol = 0;

    }

    public void starve(Board board) {
	board.getBoard()[nextRow][nextCol] = null;
    }

    @Override
    public void breed(Board board) {
	breedIterations = 0;

	getValidDirection(board);

	if (!areAllDirectionsFailed()) {
	    board.getBoard()[nextRow][nextCol] = new Nazgul();

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

    private int[] locationOfHobbitToEat(Board board) {
	int randomArray = 0;
	ArrayList<int[]> hobbitLocationList = new ArrayList<int[]>();

	hobbitLocationList = getAllAdjacentHobbitLocations(board);

	if (hobbitLocationList != null) {
	    
	    if (hobbitLocationList.size() > 1) {
		Random rnd = new Random();
		randomArray = rnd.nextInt(hobbitLocationList.size() - 1) + 0;
	    }

	    return hobbitLocationList.get(randomArray);
	} else {
	    return null;
	}
    }

    private ArrayList<int[]> getAllAdjacentHobbitLocations(Board board) {
	ArrayList<int[]> list = new ArrayList<int[]>();

	int[] locationToCheck = getCellUp();
	if (board.getBoard()[locationToCheck[ARRAY_ROW]][locationToCheck[ARRAY_COL]] instanceof Hobbit) {
	    list.add(locationToCheck);
	}

	locationToCheck = getCellDown();
	if (board.getBoard()[locationToCheck[ARRAY_ROW]][locationToCheck[ARRAY_COL]] instanceof Hobbit) {
	    list.add(locationToCheck);
	}

	locationToCheck = getCellLeft();
	if (board.getBoard()[locationToCheck[ARRAY_ROW]][locationToCheck[ARRAY_COL]] instanceof Hobbit) {
	    list.add(locationToCheck);
	}

	locationToCheck = getCellRight();
	if (board.getBoard()[locationToCheck[ARRAY_ROW]][locationToCheck[ARRAY_COL]] instanceof Hobbit) {
	    list.add(locationToCheck);
	}

	if (!list.isEmpty()) {
	    return list;
	} else {
	    return null;
	}

    }

}
