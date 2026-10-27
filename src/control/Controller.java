package control;

package pvz.control;

import command.Command;
import logic.GameModel;
import pvz.logic.Game;
import pvz.view.GamePrinter;
import pvz.view.GameView;
import pvz.view.Messages;

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
	private final GameView view;

	public Controller(GameModel game) {
		this.game = game;
		this.view = new GamePrinter(game);
	}

	/**
	 * Runs the game logic.
	 */
	public void run() {
		while (!game.hasGameFinished() && !game.playerQuits()) {
			   // 2. Ask for user action
			    String[] words = prompt();
			    Command command = Command.parse(words);
			    if (command != null) {
			        // 3-4. Game Action & Update. Draw if required
			        command.execute(game, view);
			    } else {
			        view.showError(Messages.UNKNOWN_COMMAND));
			    }
			}
	}
}