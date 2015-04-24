package lab8;

import java.util.ArrayList;

public class Controller {
    private Board board = new Board();
    private View view = new View();

    public void updateView(int iterations, int hobbits, int nazguls) {
	view.printBoard(board.getBoard(), iterations, hobbits, nazguls);
    }

    public void run() {

	initBoardDisplay();

	for (int runNum = 1; runNum <= Properties.ITERATIONS; runNum++) {
	    for (int i = 1; i <= Properties.BOARD_ROWS; i++) {
		for (int j = 1; j <= Properties.BOARD_COLS; j++) {
		    if (!isNewlyMovedOrganism(i, j)) {
			if (!(board.getCellContents(i, j) == null)) {
			    board.getCellContents(i, j).move(board, i, j);
			}// end if
		    }// end isNewlyMovedOrganism if
		}// end j loop
	    }// end i loop

	    // clear recently moved organisms list since the current run is
	    // complete
	    board.getMovedOrganisms().clear();

	  this.updateView(runNum, board.getNumOfHobbits(), board.getNumOfNazguls());

	    try {
		Thread.sleep(Properties.SLEEP_VALUE);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }

	    view.clearScreen();
	}// end runNum loop
    }

    private boolean isNewlyMovedOrganism(int i, int j) {
	ArrayList<int[]> arrayList = board.getMovedOrganisms();

	for (int[] intArray : arrayList) {
	    if (intArray[0] == i && intArray[1] == j) {
		return true;
	    }
	}
	return false;
    }

    private void initBoardDisplay() {
	view.clearScreen();
	this.updateView(0, Properties.STARTING_HOBBITS, Properties.STARTING_NAZGULS);

	try {
	    Thread.sleep(Properties.SLEEP_VALUE);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	view.clearScreen();
    }

    public Board getBoard() {
        return board;
    }

    public View getView() {
        return view;
    }
    
    /*public void closeDebugFile(){
	view.getOut().close();
    }*/
}
