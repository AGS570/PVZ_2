package logic.gameobjects;

import logic.GameWorld;
import logic.Position;

public abstract class GameObject implements GameItem {

	  protected GameWorld game;
	  protected Position position;
	  protected int health;
	  protected boolean isAlive;
	  
	  //...
	protected String name = "";
	protected String nameAndShortcut = "";
	protected String description = "";
	protected String icon = "";
	  //...

	  
	  GameObject(GameWorld game, Position p) {
	    this.game = game;
	    this.position = p;
	    this.isAlive = true;
	  }
	  
	  
	  GameObject() {
		    
		  }

	  public boolean isInPosition(Position other) {
	    return this.position.isEqual(other);
	  }

	  public boolean isInRow(Position other) {
		    return this.position.isInRow(other);
		  }
	  
	  public Position getPosition() { return this.position;}

	  public String getIcon() {
		  return this.icon.formatted(this.health);
	  }

	  public String getDescription() {
		  return this.description;
	  }

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
	  
		public String getNameAndShortcut() {
			// TODO Auto-generated method stub
			return this.nameAndShortcut;
		}

		

	
	  
	  
	  
	  
	  
}