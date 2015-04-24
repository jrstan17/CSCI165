package homework6.part3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameController {
    private Board model;
    private View view;
    private GameLogic logic;
    private char currentPlayer = 'X';
    private int chosenCell = 0;
    private Scanner scr = new Scanner(System.in);

    public GameController() {
	this.model = new Board();
	this.view = new View();
	this.logic = new GameLogic();
    }

    public void start() {
	String playAgain = "";
	
	View.printWelcomeMessage();
	
	do{
	play();
	System.out.println("");
	System.out.print("Would you like to play again? (Y/N) ");
	playAgain = scr.nextLine();
	playAgain = scr.nextLine();
	playAgain.toUpperCase();
	
	} while (playAgain.equals("Y"));
	
	scr.close();	
    }

    private void play() {
	model.reset();
	this.updateView();

	System.out.print("Player " + this.getCurrentPlayer()
		+ ": What cell would you like? ");

	getCellInput();

	this.updateView();

	do {
	    this.setToNextPlayer();

	    System.out.print("Player " + this.getCurrentPlayer()
		    + ": What cell would you like? ");
	    getCellInput();

	    this.updateView();
	} while (!this.isWon() && !this.isStalemate());

	this.printWinningMessage();
    }

    public void getCellInput() {
	try {
	    this.setChosenCell(scr.nextInt());
	} catch (InputMismatchException e) {
	    scr = new Scanner(System.in);
	    this.setChosenCell(-1);
	}
    }

    public void setBoardValue(int index, char value) {
	model.setBoardValue(index, value);
    }

    public void getBoardValue(int index) {
	model.getBoardValue(index);
    }

    public char[][] getBoard() {
	return model.getBoard();
    }

    public void updateView() {
	view.printBoard(this);
    }

    public boolean isWon() {
	return logic.isWon(model);
    }

    public boolean isStalemate() {
	return logic.isStalemate(model);
    }

    public char getWinner() {
	return logic.getWinner(model);
    }

    public char getCurrentPlayer() {
	return currentPlayer;
    }

    public void setToNextPlayer() {
	if (currentPlayer == 'X')
	    currentPlayer = 'O';
	else
	    currentPlayer = 'X';
    }

    public int getChosenCell() {
	return chosenCell;
    }

    public void setChosenCell(int chosenCell) {
	if (chosenCell >= 1 && chosenCell <= 9
		&& model.getBoardValue(chosenCell) != 'X'
		&& model.getBoardValue(chosenCell) != 'O') {
	    this.chosenCell = chosenCell;
	    model.setBoardValue(chosenCell, currentPlayer);
	} else {
	    View.printWrongCellInputMessage();
	    setToNextPlayer();
	}
    }

    public void printWinningMessage() {
	view.printWinningMessage(this);
    }

    public Board getModel() {
        return new Board(model);
    }

    public void setModel(Board model) {
        this.model = model;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public GameLogic getLogic() {
        return logic;
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

}
