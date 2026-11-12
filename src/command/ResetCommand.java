package command;

import logic.GameModel;
import view.GameView;
import view.Messages;


public class ResetCommand extends Command{
	
	private String level;
	private long seed;
	private boolean tieneParametros;
	
	public ResetCommand() {
		this.name = Messages.COMMAND_RESET_NAME;
		this.shortcut = Messages.COMMAND_RESET_SHORTCUT;
		this.details = Messages.COMMAND_RESET_DETAILS;
		this.help = Messages.COMMAND_RESET_HELP;
		this.tieneParametros=false;
	}
	
    public ResetCommand(String level, long seed) {
        super();
        this.level = level;
        this.seed = seed;
        this.tieneParametros = true;
    }

	@Override
	public boolean matchCommand(String s) {
		// TODO Auto-generated method stub
		return this.name.equals(s) || this.shortcut.equals(s);
	}

	@Override
	public Command create(String[] commandWords) {
		// TODO Auto-generated method stub
		if(!matchCommand(commandWords[0]))
			return null;
		if(commandWords.length==1) {
			return new ResetCommand();
		}
		if(commandWords.length!=3) {
			return null;
		}
		
		
		long seed = Long.parseLong(commandWords[2]);
		
		return new ResetCommand(commandWords[1],seed);
	}

	@Override
	public void execute(GameModel game, GameView view) {
		// TODO Auto-generated method stub

		if(tieneParametros) {
			game.reset(level,seed);
		}
		
		else {
			game.reset();
		}
		
	}
}
