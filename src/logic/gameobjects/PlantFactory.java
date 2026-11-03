package logic.gameobjects;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import command.Command;
import logic.GameWorld;
import logic.Position;
import utils.Utilidades;
import view.Messages;

public class PlantFactory {

	  private static final List<Plant> AVAILABLE_PLANTS = Arrays.asList(
	      new SunFlower(),
	      new PeaShooter()
	  );


	  public static Plant spawnPlant(String plantName, GameWorld game, Position position) {
		  Plant result = null;
		  switch(plantName) {
		  	case "sunflower":
		  	case "s":
		  		if(game.canAfford(Utilidades.SUNFLOWER_COST))
		  			result = game.addSunflower(position);
		    break;

		  	case "peashooter":
		  	case "p":
		  		if(game.canAfford(Utilidades.PEASHOOTER_COST))
		  			result = game.addPeashooter(position);
		  		
		    break;
		  }
		  
		  return result;
	  }

	  public static List<Plant> getAvailablePlants() {
	    return Collections.unmodifiableList(AVAILABLE_PLANTS);
	  }
	  // ...

	  public Plant parse(String[] commandWords, GameWorld game) {
		  if(commandWords.length < 4) return null;
		  int r = Integer.parseInt(commandWords[2]);
		  int c = Integer.parseInt(commandWords[3]);
		  
		  Position p = new Position(r,c);
		  
		  return this.spawnPlant(commandWords[1], game, p);
	  }

	  public String list() {
		// TODO Auto-generated method stub
		   StringBuilder result = new StringBuilder();

		    for (Plant p : AVAILABLE_PLANTS) {
		        result.append(p.getNameAndShortcut())

		              .append(": ")
		              .append(p.getDescription())
		              .append(Messages.LINE_SEPARATOR);
		    }
		    return result.toString();
	  }



}



