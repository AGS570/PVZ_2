package command;

import logic.GameModel;
import view.GameView;
import view.Messages;

public class AddZombieCommand extends Command{

	String[] ZombieWords;
	public AddZombieCommand() {
		this.name = Messages.COMMAND_ADD_ZOMBIE_NAME;
		this.shortcut = Messages.COMMAND_ADD_ZOMBIE_SHORTCUT;
		this.details = Messages.COMMAND_ADD_ZOMBIE_DETAILS;
		this.help = Messages.COMMAND_ADD_ZOMBIE_HELP;
	}
	
	public AddZombieCommand(String[] commandWords) {
		// TODO Auto-generated constructor stub
		this.name = Messages.COMMAND_ADD_ZOMBIE_NAME;
		this.shortcut = Messages.COMMAND_ADD_ZOMBIE_SHORTCUT;
		this.details = Messages.COMMAND_ADD_ZOMBIE_DETAILS;
		this.help = Messages.COMMAND_ADD_ZOMBIE_HELP;
		
		this.ZombieWords = commandWords;
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
			return new AddZombieCommand(commandWords);
		else return null;
	}

	@Override
	public void execute(GameModel game, GameView view) {
		// TODO Auto-generated method stub
		
		String r = game.addZombie(this.ZombieWords);
		if(!r.equalsIgnoreCase("ok"))view.showError(r);
	}

}
