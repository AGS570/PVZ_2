package command;

import logic.GameModel;
import view.GameView;
import view.Messages;

public class CatchCommand extends Command{

	private String[] commandWords;
	public CatchCommand() {
		this.name = Messages.COMMAND_CATCH_NAME;
		this.shortcut = Messages.COMMAND_CATCH_SHORTCUT;
		this.details = Messages.COMMAND_CATCH_DETAILS;
		this.help = Messages.COMMAND_CATCH_HELP;
	}
	public CatchCommand(String[] commandWords) {
		// TODO Auto-generated constructor stub
		this.name = Messages.COMMAND_CATCH_NAME;
		this.shortcut = Messages.COMMAND_ADD_PLANT_CHEAT_SHORTCUT;
		this.details = Messages.COMMAND_CATCH_DETAILS;
		this.help = Messages.COMMAND_CATCH_HELP;
		this.commandWords = commandWords;
	}
	@Override
	public boolean matchCommand(String s) {
		return this.name.equals(s) || this.shortcut.equals(s);
	}

	@Override
	public Command create(String[] commandWords) {
		// TODO Auto-generated method stub
		if(matchCommand(commandWords[0]))
			return new CatchCommand(commandWords);
		else return null;
	}

	@Override
	public void execute(GameModel game, GameView view) {

		// TODO Auto-generated method stub
		game.catchSun(Integer.parseInt(commandWords[1]),Integer.parseInt(commandWords[2]));
	}
	
}
