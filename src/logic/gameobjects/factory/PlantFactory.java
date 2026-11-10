package logic.gameobjects.factory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import logic.GameWorld;
import logic.Position;
import logic.gameobjects.plants.CherryBomb;
import logic.gameobjects.plants.PeaShooter;
import logic.gameobjects.plants.Plant;
import logic.gameobjects.plants.SunFlower;
import logic.gameobjects.plants.WallNut;
import utils.Utilidades;
import view.Messages;

public class PlantFactory {

	  private static final List<Plant> AVAILABLE_PLANTS = Arrays.asList(
	      new SunFlower(),
	      new PeaShooter(),
	      new WallNut(),
	      new CherryBomb()
	  );


	  public static Plant spawnPlant(String plantName, GameWorld game, Position position) {
		    if (plantName == null || game == null || position == null) {
		        return null;
		    }

		    switch (plantName.toLowerCase()) {
		        case "sunflower":
		        case "s":
		        	
		        	return new SunFlower(game, position);
		            
		            

		        case "peashooter":
		        case "p":
		        	
		        	return new PeaShooter(game, position);
		            
		        case "wallnut":
		        case "wn":
		        	
		        	return new WallNut(game, position);
		            
		            

		        case "cherrybomb":
		        case "c":
		        	
		        	return new CherryBomb(game, position);
		            
		            
		    }

		    return null;
		}

	  public static List<Plant> getAvailablePlants() {
	    return Collections.unmodifiableList(AVAILABLE_PLANTS);
	  }
	  // ...

	  
	  
	  public Plant parse(String[] commandWords, GameWorld game) {
		  if(commandWords == null || commandWords.length != 4) return null;
		  int r = Integer.parseInt(commandWords[2]);
		  int c = Integer.parseInt(commandWords[3]);
		  
		  Position p = new Position(r,c);
		  
		  //if (!p.inBoard() ) return null;
      	  //if(!game.isEmpty(p)) return null;
		  return spawnPlant(commandWords[1], game, p);
	  }

	  public String list() {
		// TODO Auto-generated method stub
		  
		   StringBuilder result = new StringBuilder();

		   for(int i =0;i<AVAILABLE_PLANTS.size();i++) {
			   Plant p = AVAILABLE_PLANTS.get(i);
			   
			   result.append(p.getDescription());
			   
			   result.append(Messages.LINE_SEPARATOR);
		   }
		   

		   return result.toString();
				   
	  }



}



