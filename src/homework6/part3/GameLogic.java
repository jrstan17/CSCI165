package homework6.part3;

import java.util.regex.Pattern;

public class GameLogic {
    char whoWon = ' ';

    public char getWinner(Board board) {
	isWon(board);

	return whoWon;
    }

    public boolean isWon(Board board) {
	boolean isWon = false;

	if (board.getBoardValue(1) == board.getBoardValue(4)
		&& board.getBoardValue(4) == board.getBoardValue(7)) {
	    isWon = true;
	    whoWon = board.getBoardValue(1);
	} else if (board.getBoardValue(2) == board.getBoardValue(5)
		&& board.getBoardValue(5) == board.getBoardValue(8)) {
	    isWon = true;
	    whoWon = board.getBoardValue(2);
	} else if (board.getBoardValue(3) == board.getBoardValue(6)
		&& board.getBoardValue(6) == board.getBoardValue(9)) {
	    isWon = true;
	    whoWon = board.getBoardValue(3);
	} else if (board.getBoardValue(1) == board.getBoardValue(2)
		&& board.getBoardValue(2) == board.getBoardValue(3)) {
	    isWon = true;
	    whoWon = board.getBoardValue(1);
	} else if (board.getBoardValue(4) == board.getBoardValue(5)
		&& board.getBoardValue(5) == board.getBoardValue(6)) {
	    isWon = true;
	    whoWon = board.getBoardValue(4);
	} else if (board.getBoardValue(7) == board.getBoardValue(8)
		&& board.getBoardValue(8) == board.getBoardValue(9)) {
	    isWon = true;
	    whoWon = board.getBoardValue(7);
	} else if (board.getBoardValue(1) == board.getBoardValue(5)
		&& board.getBoardValue(5) == board.getBoardValue(9)) {
	    isWon = true;
	    whoWon = board.getBoardValue(1);
	} else if (board.getBoardValue(7) == board.getBoardValue(5)
		&& board.getBoardValue(5) == board.getBoardValue(3)) {
	    isWon = true;
	    whoWon = board.getBoardValue(7);
	} else
	    isWon = false;

	return isWon;
    }

    public boolean isStalemate(Board board) {
	for (int i = 1; i <= (board.NUM_OF_ROWCOL * board.NUM_OF_ROWCOL); i++) {
	    if (Pattern.matches("([1-9]){1}",
		    Character.toString(board.getBoardValue(i)))) {
		return false;
	    }
	}
	return true;
    }
}
