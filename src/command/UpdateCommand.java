package command;

import logic.GameModel;
import view.GameView;
import view.Messages;

public class UpdateCommand extends Command{

	public UpdateCommand() {
		this.name = Messages.COMMAND_UPDATE_NAME;
		this.shortcut = Messages.COMMAND_UPDATE_SHORTCUT;
		this.details = Messages.COMMAND_UPDATE_DETAILS;
		this.help = Messages.COMMAND_UPDATE_HELP;
	}
	
	@Override
	public boolean matchCommand(String s) {
		// TODO Auto-generated method stub
		return this.name.equals(s) || this.shortcut.equals(s) || s.equals("");
	}

	@Override
	public Command create(String[] commandWords) {
		// TODO Auto-generated method stub
		if(matchCommand(commandWords[0]))
			return new UpdateCommand();
		else return null;
	}

	@Override
	public void execute(GameModel game, GameView view) {
		// TODO Auto-generated method stub
	}
	
}
