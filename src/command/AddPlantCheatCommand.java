package command;

import logic.GameModel;
import view.GameView;
import view.Messages;

public class AddPlantCheatCommand extends Command{
	String[] plantWords;
	public AddPlantCheatCommand() {
		this.name = Messages.COMMAND_CHEAT_PLANT_NAME;
		this.shortcut = Messages.COMMAND_ADD_PLANT_CHEAT_SHORTCUT;
		this.details = Messages.COMMAND_ADD_PLANT_CHEAT_DETAILS;
		this.help = Messages.COMMAND_CHEAT_PLANT_HELP;
	}
	
	public AddPlantCheatCommand(String[] commandWords) {
		this.name = Messages.COMMAND_ADD_PLANT_CHEAT_NAME;
		this.shortcut = Messages.COMMAND_ADD_PLANT_CHEAT_SHORTCUT;
		this.details = Messages.COMMAND_ADD_PLANT_CHEAT_DETAILS;
		this.help = Messages.COMMAND_ADD_PLANT_CHEAT_HELP;
		this.plantWords = commandWords;
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
			return new AddPlantCheatCommand(commandWords);
		else return null;
	}

	@Override
	public void execute(GameModel game, GameView view) {
		// TODO Auto-generated method stub
		
		String r = game.addPlantCheat(this.plantWords);
		if(!r.equalsIgnoreCase("ok"))view.showError(r);
	}
}
