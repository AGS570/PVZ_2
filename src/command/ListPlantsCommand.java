package command;

import logic.GameModel;
import view.GameView;
import view.Messages;

public class ListPlantsCommand extends Command{
	public ListPlantsCommand() {
		this.name = Messages.COMMAND_LIST_PLANTS_NAME;
		this.shortcut = Messages.COMMAND_LIST_PLANTS_SHORTCUT;
		this.details = Messages.COMMAND_LIST_PLANTS_DETAILS;
		this.help = Messages.COMMAND_LIST_PLANTS_HELP;
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
			return new ListPlantsCommand();
		else return null;
	}

	@Override
	public void execute(GameModel game, GameView view) {
		// TODO Auto-generated method stub
		
	}

}
