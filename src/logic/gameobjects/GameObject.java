package logic.gameobjects;

import logic.GameWorld;
import logic.Position;

public abstract class GameObject implements GameItem {

	  protected GameWorld game;
	  protected Position position;
	  protected int health;
	  
	  GameObject(GameWorld game, Position p) {
	    this.game = game;
	    this.position = p;
	  }

	  public boolean isInPosition(Position other) {
	    return this.position.equals(other);
	  }

	  public Position getPosition() { return this.position;}

	  abstract public String getIcon();

	  abstract public String getDescription();

	  public boolean isAlive() {
		  if(health <= 0 ) {
			  return false;
		  }
		  return true;
	  };

	  abstract public void update();
	  
	  
	  abstract public void onEnter();

	  abstract public void onExit();

	  // ...
	}