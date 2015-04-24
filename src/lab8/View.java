package lab8;

import java.io.PrintWriter;

public class View {

    private final int BORDER_OVERLAP = 2;
    private final int DEBUG_STARTING_ROW = 1;

    private PrintWriter out;

    public View() {
	/*try {
	    out = new PrintWriter(new FileWriter("debug.txt"));
	} catch (IOException e) {
	    e.printStackTrace();
	}*/
    }

    public void printBoard(Organism[][] orgArray, int iterations, int hobbits,
	    int nazguls) {
	// print top border
	for (int i = 1; i <= Properties.BOARD_COLS + BORDER_OVERLAP; i++) {
	    System.out.print(Properties.BORDER_CHAR);
	}
	System.out.println("");

	// print middle part of board
	for (int i = 1; i < orgArray.length; i++) {
	    System.out.print(Properties.BORDER_CHAR);
	    for (int j = 1; j < orgArray[0].length; j++) {
		if (orgArray[i][j] == null) {
		    System.out.print(" ");
		} else {
		    System.out.print(orgArray[i][j]);
		}
	    }
	    System.out.print(Properties.BORDER_CHAR);

	    // print current iteration
	    if (i == DEBUG_STARTING_ROW) {
		System.out.print("  Iteration: " + iterations);
	    } else if (i == DEBUG_STARTING_ROW + 1) {
		System.out.print("    Hobbits: " + hobbits);
	    } else if (i == DEBUG_STARTING_ROW + 2) {
		System.out.print("    Nazguls: " + nazguls);
	    }

	    System.out.println("");
	}

	// print bottom border
	for (int i = 1; i <= Properties.BOARD_COLS + BORDER_OVERLAP; i++) {
	    System.out.print(Properties.BORDER_CHAR);
	}
	System.out.println("");
	
	if (hobbits == 0 || nazguls == 0){
	    out.close();
	    System.exit(0);
	}
	
	/*printDebugToFile(hobbits, nazguls);*/
    }

    /*private void printDebugToFile(int hobbits, int nazguls) {
	out.println(hobbits + " " + nazguls);
    }*/

    public void clearScreen() {
	for (int k = 1; k <= 50; k++) {
	    System.out.println("");
	}
    }

    /*public PrintWriter getOut() {
        return out;
    }*/
}
