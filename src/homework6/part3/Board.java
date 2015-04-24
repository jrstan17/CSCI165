package homework6.part3;

public class Board {
    public final int NUM_OF_ROWCOL = 3;

    private char[][] board = new char[NUM_OF_ROWCOL][NUM_OF_ROWCOL];

    public Board() {
	reset();
    }
    
    public Board(Board model) {
	if (model != null)
	    this.board = model.board;
    }

    public void reset(){
	board[0][0] = '1';
	board[0][1] = '2';
	board[0][2] = '3';
	board[1][0] = '4';
	board[1][1] = '5';
	board[1][2] = '6';
	board[2][0] = '7';
	board[2][1] = '8';
	board[2][2] = '9';
    }

    public char[][] getBoard() {
	return board;
    }

    public char getBoardValue(int index) {
	char value = ' ';

	switch (index) {
	case 1:
	    value = board[0][0];
	    break;
	case 2:
	    value = board[0][1];
	    break;
	case 3:
	    value = board[0][2];
	    break;
	case 4:
	    value = board[1][0];
	    break;
	case 5:
	    value = board[1][1];
	    break;
	case 6:
	    value = board[1][2];
	    break;
	case 7:
	    value = board[2][0];
	    break;
	case 8:
	    value = board[2][1];
	    break;
	case 9:
	    value = board[2][2];
	    break;
	}
	return value;
    }

    public void setBoardValue(int index, char value) {
	switch (index) {
	case 1:
	    board[0][0] = value;
	    break;
	case 2:
	    board[0][1] = value;
	    break;
	case 3:
	    board[0][2] = value;
	    break;
	case 4:
	    board[1][0] = value;
	    break;
	case 5:
	    board[1][1] = value;
	    break;
	case 6:
	    board[1][2] = value;
	    break;
	case 7:
	    board[2][0] = value;
	    break;
	case 8:
	    board[2][1] = value;
	    break;
	case 9:
	    board[2][2] = value;
	    break;
	}
    }
}
