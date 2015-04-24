package lab8;

import java.util.ArrayList;
import java.util.Random;

public class Board {

    private ArrayList<int[]> movedOrganisms = new ArrayList<int[]>();

    private Random rnd = new Random();
    private Organism[][] board = new Organism[Properties.BOARD_ROWS + 1][Properties.BOARD_COLS + 1];

    public Board() {
	if (isTooMany()) {
	    System.out
		    .println("There are too many Hobbits and Nazguls to populate the board.");
	    System.exit(0);
	}
	initBoard();
    }

    public Organism[][] getBoard() {
	return board;
    }

    private void initBoard() {
	int numOfRemainingHobbits = Properties.STARTING_HOBBITS;
	int numOfRemainingNazguls = Properties.STARTING_NAZGULS;

	// randomize Hobbit locations
	if (numOfRemainingHobbits != 0) {
	    do {
		int rndRow = rnd.nextInt(Properties.BOARD_ROWS) + 1;
		int rndCol = rnd.nextInt(Properties.BOARD_COLS) + 1;

		if (board[rndRow][rndCol] == null) {
		    board[rndRow][rndCol] = new Hobbit();
		    numOfRemainingHobbits--;
		}

	    } while (numOfRemainingHobbits != 0);
	}// end if

	// randomize Nazgul locations
	if (numOfRemainingNazguls != 0) {
	    do {
		int rndRow = rnd.nextInt(Properties.BOARD_ROWS) + 1;
		int rndCol = rnd.nextInt(Properties.BOARD_COLS) + 1;

		if (board[rndRow][rndCol] == null) {
		    board[rndRow][rndCol] = new Nazgul();
		    numOfRemainingNazguls--;
		}

	    } while (numOfRemainingNazguls != 0);
	}// end if
    }

    private boolean isTooMany() {
	return ((Properties.STARTING_HOBBITS + Properties.STARTING_NAZGULS) > (Properties.BOARD_COLS * Properties.BOARD_ROWS));
    }

    public int getNumOfHobbits() {
	int hobbits = 0;

	for (Organism[] a : board) {
	    for (Organism o : a) {
		if (o != null) {
		    if (o instanceof Hobbit) {
			hobbits++;
		    }
		}
	    }
	}

	return hobbits;
    }

    public int getNumOfNazguls() {
	int nazguls = 0;

	for (Organism[] a : board) {
	    for (Organism o : a) {
		if (o != null) {
		    if (o instanceof Nazgul) {
			nazguls++;
		    }
		}
	    }
	}

	return nazguls;
    }

    public Organism getCellContents(int row, int col) {
	return board[row][col];
    }

    public void setCellContents(int row, int col, Organism organism) {
	board[row][col] = organism;
    }

    public ArrayList<int[]> getMovedOrganisms() {
	return movedOrganisms;
    }

    public void setMovedOrganisms(int[] input) {
	movedOrganisms.add(input);
    }
}