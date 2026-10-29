package logic.gameobjects;

import logic.GameWorld;
import logic.Position;

public abstract class GameObject implements GameItem {

	  protected GameWorld game;
	  protected Position position;
	  protected int health;
	  protected boolean isAlive;
	  
	  GameObject(GameWorld game, Position p) {
	    this.game = game;
	    this.position = p;
	    this.isAlive = true;
	  }

	  public boolean isInPosition(Position other) {
	    return this.position.equals(other);
	  }

	  public Position getPosition() { return this.position;}

	  abstract public String getIcon();

	  abstract public String getDescription();

	  public boolean isAlive() {
		  return this.isAlive;
	  };

	  abstract public void update();
	  
	  
	  abstract public void onEnter();

	  abstract public void onExit();

	  public void checkHealth() {
		  if(this.health <= 0) this.death();
	  }

	  private void death() {
		// TODO Auto-generated method stub
		this.isAlive = false;
	  }
	  
	  public boolean receiveInteraction(Zombie obj,int dmf) {
		  return false;
	  }
	  
	  public boolean receiveInteraction(PeaShooter obj, int dmg) {
		  return false;
	  }
	  

	  
	  
	  
	  
	  
	  
}