package command;

import logic.GameModel;
import view.GameView;
import view.Messages;

public class ExitCommand extends Command{
	public ExitCommand() {
		this.name = Messages.COMMAND_EXIT_NAME;
		this.shortcut = Messages.COMMAND_EXIT_SHORTCUT;
		this.details = Messages.COMMAND_EXIT_DETAILS;
		this.help = Messages.COMMAND_EXIT_HELP;
	}
	@Override
	public boolean matchCommand(String s) {
		// TODO Auto-generated method stub
		return this.name.equals(s) || this.shortcut.equals(s);
	}

	@Override
	public Command create(String[] commandWords) {
		// TODO Auto-generated method stub
		if(matchCommand(commandWords[0]))
			return new ExitCommand();
		else return null;
	}

	@Override
	public void execute(GameModel game, GameView view) {
		// TODO Auto-generated method stub
		game.quit();
	}

}
