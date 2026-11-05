package logic.gameobjects.factory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import logic.GameWorld;
import logic.Position;
import logic.gameobjects.zombies.BucketHeadZombie;
import logic.gameobjects.zombies.ExplosiveZombie;
import logic.gameobjects.zombies.SportyZombie;
import logic.gameobjects.zombies.Zombie;
import view.Messages;

public class ZombieFactory {
	private static final List<Zombie> AVAILABLE_ZOMBIES = Arrays.asList(
		      new BucketHeadZombie(),
		      new ExplosiveZombie(),
		      new SportyZombie(),
		      new Zombie()
		  );


		  public static Zombie spawnZombie(String ZombieName, GameWorld game, Position position) {
			    if (ZombieName == null || game == null || position == null) {
			        return null;
			    }

			    switch (ZombieName.toLowerCase()) {
			        case "BucketHead":
			        case "bz":
			        	
			        	return new BucketHeadZombie(game, position);

			        case "sporty":
			        case "sz":
			        	
			        	return new SportyZombie(game, position);
			        
			        case "explosive":
			        case "ez":
			        	
			        	return new ExplosiveZombie(game, position);
			        	
			        case "zombie":
			        case "z":
			        	return new Zombie(game, position);
			    }

			    return null;
			}

		  public static List<Zombie> getAvailablePlants() {
		    return Collections.unmodifiableList(AVAILABLE_ZOMBIES);
		  }
		  // ...

		  
		  
		  public Zombie parse(String[] commandWords, GameWorld game) {
			  if(commandWords == null || commandWords.length != 4) return null;
			  int r = Integer.parseInt(commandWords[2]);
			  int c = Integer.parseInt(commandWords[3]);
			  
			  Position p = new Position(r,c);
			  
			  //if (!p.inBoard() ) return null;
	      	  //if(!game.isEmpty(p)) return null;
			  return spawnZombie(commandWords[1], game, p);
		  }

		  public String list() {
			// TODO Auto-generated method stub
			  
			   StringBuilder result = new StringBuilder();

			   for(int i =0;i<AVAILABLE_ZOMBIES.size();i++) {
				   Zombie p = AVAILABLE_ZOMBIES.get(i);
				  // result.append(p.getNameAndShortcut());
				   result.append(p.getDescription());
				   
				   result.append(Messages.LINE_SEPARATOR);
			   }
			   

			   return result.toString();
					   
		  }


}
