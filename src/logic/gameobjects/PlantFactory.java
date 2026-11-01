package logic.gameobjects;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import logic.GameWorld;
import logic.Position;

public class PlantFactory {

	  private static final List<Plant> AVAILABLE_PLANTS = Arrays.asList(
	      new SunFlower(),
	      new PeaShooter()
	  );


	  public static Plant spawnPlant(String plantName, GameWorld game, Position position) {
		  int result;
		  switch(plantName) {
		  	case "sunflower":
		  	case "s":
		  		result = game.addSunflower(position);
		    break;

		  	case "peashooter":
		  	case "p":
		  		result = game.addPeashooter(position);
		    break;
		  }
	  }

	  public static List<Plant> getAvailablePlants() {
	    return Collections.unmodifiableList(AVAILABLE_PLANTS);
	  }
	  // ...
	}