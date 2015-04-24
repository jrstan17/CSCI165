package lab8;

import java.util.ArrayList;
import java.util.Random;

public abstract class Organism {

    public static final int ARRAY_ROW = 0;
    public static final int ARRAY_COL = 1;

    protected char organismChar = ' ';
    protected ArrayList<Boolean> directionsFailed = new ArrayList<Boolean>();
    protected int breedIterations = 0;

    Random rnd = new Random();

    int row = 0;
    int col = 0;
    int nextRow = 0;
    int nextCol = 0;
    int randomDirection = 0;

    public Organism() {
	directionsFailed.add(0, false);
	directionsFailed.add(Direction.UP, false);
	directionsFailed.add(Direction.DOWN, false);
	directionsFailed.add(Direction.LEFT, false);
	directionsFailed.add(Direction.RIGHT, false);
    }

    public abstract void move(Board board, int row, int col);

    public abstract void breed(Board board);

    public String toString() {
	StringBuilder sb = new StringBuilder();

	sb.append(organismChar);

	return sb.toString();
    }

    public void clearDirectionsFailed() {
	directionsFailed.set(Direction.UP, false);
	directionsFailed.set(Direction.DOWN, false);
	directionsFailed.set(Direction.LEFT, false);
	directionsFailed.set(Direction.RIGHT, false);
    }

    public boolean areAllDirectionsFailed() {
	return ((directionsFailed.get(Direction.UP))
		&& (directionsFailed.get(Direction.DOWN))
		&& (directionsFailed.get(Direction.LEFT)) && (directionsFailed
		    .get(Direction.RIGHT)));
    }

    public int[] getCellUp() {
	int[] returnArray = new int[2];
	int i = 0;
	int j = 0;

	if (row == 1) {
	    i = Properties.BOARD_ROWS;
	} else {
	    i = row - 1;
	}

	j = col;

	returnArray[0] = i;
	returnArray[1] = j;

	return returnArray;
    }

    public int[] getCellDown() {
	int[] returnArray = new int[2];
	int i = 0;
	int j = 0;

	if (row == Properties.BOARD_ROWS) {
	    i = 1;
	} else {
	    i = row + 1;
	}

	j = col;

	returnArray[0] = i;
	returnArray[1] = j;

	return returnArray;
    }

    public int[] getCellLeft() {
	int[] returnArray = new int[2];
	int i = 0;
	int j = 0;

	if (col == 1) {
	    j = Properties.BOARD_COLS;
	} else {
	    j = col - 1;
	}

	i = row;

	returnArray[0] = i;
	returnArray[1] = j;

	return returnArray;
    }

    public int[] getCellRight() {
	int[] returnArray = new int[2];
	int i = 0;
	int j = 0;

	if (col == Properties.BOARD_COLS) {
	    j = 1;
	} else {
	    j = col + 1;
	}

	i = row;

	returnArray[0] = i;
	returnArray[1] = j;

	return returnArray;
    }

}
