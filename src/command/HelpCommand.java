package command;

import logic.GameModel;
import view.GameView;
import view.Messages;

public class HelpCommand extends Command {
	
	  public HelpCommand() {
		this.name = Messages.COMMAND_HELP_NAME;
		this.shortcut = Messages.COMMAND_HELP_SHORTCUT;
		this.details = Messages.COMMAND_HELP_DETAILS;
		this.help =  Messages.COMMAND_HELP_HELP;
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
			return new HelpCommand();
		else return null;
	}
	@Override
	public void execute(GameModel game, GameView view) {
		// TODO Auto-generated method stub
		game.help();
	}
	}