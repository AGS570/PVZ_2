package command;

import java.util.Arrays;
import java.util.List;

import logic.GameModel;
import logic.GameView;

public abstract class Command{

	protected static final List<Command> AVAILABLE_COMMANDS = Arrays.asList(
	      new AddPlantCommand(),
	      new ListPlantsCommand(),
	      new ResetCommand(),
	      new HelpCommand(),
	      new ExitCommand(),
	      new UpdateCommand()
	 );
	  
	  //...
	protected String name = "";
	protected String shortcut = "";
	protected String details = "";
	protected String help = "";
	  //...

	
	  public static Command parse(String[] commandWords) {
		  if (commandWords.length == 0) return null;
		  for( Command command : AVAILABLE_COMMANDS)
			  if (command.matchCommand(commandWords[0])) {
				  return command.create(commandWords);
			  }
		return null;
	  }

	  public abstract boolean matchCommand(String s);

	  public abstract Command create(String[] commandWords);

	  public abstract void execute(GameModel game, GameView view);

	  public Object getDetails() {
		// TODO Auto-generated method stub
		return details;
	  }

	  public Object getHelp() {
		// TODO Auto-generated method stub
		return help;
	  }
}


