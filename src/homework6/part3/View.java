package homework6.part3;

public class View {

    public void printBoard(GameController controller) {
	System.out.println("");
	System.out.println("     |     |");
	System.out.println("  " + controller.getModel().getBoardValue(1) + "  |  "
		+ controller.getModel().getBoardValue(2) + "  |  " + controller.getModel().getBoardValue(3));
	System.out.println("     |     |");
	System.out.println("-----------------");
	System.out.println("     |     |");
	System.out.println("  " + controller.getModel().getBoardValue(4) + "  |  "
		+ controller.getModel().getBoardValue(5) + "  |  " + controller.getModel().getBoardValue(6));
	System.out.println("     |     |");
	System.out.println("-----------------");
	System.out.println("     |     |");
	System.out.println("  " + controller.getModel().getBoardValue(7) + "  |  "
		+ controller.getModel().getBoardValue(8) + "  |  " + controller.getModel().getBoardValue(9));
	System.out.println("     |     |");
	System.out.println("");
    }

    public void printWinningMessage(GameController controller) {
	if (controller.isWon()) {
	    System.out.println("Player " + controller.getWinner()
		    + " wins the game!");
	}

	if (controller.isStalemate()) {
	    System.out.println("Stalemate!");
	}
    }

    public static void printWrongCellInputMessage() {
	System.out.println("");
	System.out.println("You entered an incorrect cell! Try again.");
    }
    
    public static void printWelcomeMessage(){
	System.out.println("Welcome to Tic Tac Toe!");
    }
}
