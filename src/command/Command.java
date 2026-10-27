package command;

import java.util.Arrays;
import java.util.List;

import logic.GameModel;
import view.GameView;

public abstract class Command{

	private static final List<Command> AVAILABLE_COMMANDS = Arrays.asList(
	      new AddPlantCommand(),
	      new ListPlantsCommand(),
	      new ResetCommand(),
	      new HelpCommand()
	 );
	  
	  //...
	protected String name = "";
	protected String shortcut = "";
	protected String details = "";
	protected String help = "";
	  //...

	
	  public static Command parse(String[] commandWords) {
		  for( Command command : AVAILABLE_COMMANDS)
			  if (command.matchCommand(commandWords[0])) {
				  return command.create(commandWords);
			  }
		return null;
	  }

	  public abstract boolean matchCommand(String s);

	  public abstract Command create(String[] commandWords);

	  public abstract void execute(GameModel game, GameView view);
}


