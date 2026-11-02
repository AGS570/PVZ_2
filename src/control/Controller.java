package control;



import command.Command;
import logic.GameModel;
import logic.GameStatus;
import logic.GameWorld;
import logic.Game;
import view.GamePrinter;
import view.GameView;
import view.Messages;

/**
 * Input/output coordinator of the game (the C in MVC).
 *
 * <p>Owns the game loop: reads a line from stdin, parses it into a
 * command, validates parameters (plant type, position), delegates
 * state changes to {@link Game}, and triggers a board reprint via
 * {@link tp1.pvz.view.GameView>} when the cycle advances. It holds no game
 * state of its own; the source of truth is always {@link Game}.
 */
public class Controller {

	private final GameModel game;
	private final GameStatus gs;
	private final GamePrinter view;

	public Controller(GameModel game, GameStatus gs) {
		this.gs = gs;
		this.game = game;
		this.view = new GamePrinter(gs);
	}

	/**
	 * Runs the game logic.
	 */
	public void run() {
		view.showGame();
		while (!game.hasGameFinished() && !game.playerQuits()) {
			   // 2. Ask for user action
			    String[] words = view.getPrompt();
			    Command command = Command.parse(words);
			    if (command != null) {
			        // 3-4. Game Action & Update. Draw if required
			        command.execute(game, view);
			    } else {
			        view.showError(Messages.UNKNOWN_COMMAND);
			    }
			    this.view.showGame();
			}
		if (!game.hasGameFinished()) {
		    view.showMessage(Messages.PLAYER_QUITS);
		} else if (game.playerWins()) {
		    view.showMessage(Messages.PLAYER_WINS);
		} else {
		    view.showMessage(Messages.ZOMBIES_WIN);
		}
	}

}