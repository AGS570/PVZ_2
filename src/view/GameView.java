package view;

public interface GameView {

	/**
	 * Prints the message to be printed once the game has finished.
	 */
	void showEndMessage();

	void showError(String message);

	void showMessage(String message);

	String[] getPrompt();

	/**
	 * Prints complete representation (status+board) of the game.
	 */
	void showGame();

}
