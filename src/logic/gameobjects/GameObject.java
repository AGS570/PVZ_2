
package logic.gameobjects;

import logic.GameWorld;
import logic.Position;

public abstract class GameObject implements GameItem {

    protected GameWorld game;
    protected Position position;
    protected int health;
    protected int damage;
    protected boolean isAlive;

    protected String name = "";
    protected String nameAndShortcut = "";
    protected String description = "";
    protected String icon = "";

    protected GameObject(GameWorld game, Position position) {
        this.game = game;
        this.position = position;
        this.isAlive = true;
    }

    protected GameObject() {
        this.isAlive = true;
    }

    @Override
    public boolean isInPosition(Position other) {
        return this.position != null
                && this.position.isEqual(other);
    }

    @Override
    public boolean isInRow(Position other) {
        return this.position != null
                && this.position.isInRow(other);
    }

    public Position getPosition() {
        return this.position;
    }

    public String getIcon() {
        return this.icon.formatted(this.health);
    }

    public String getDescription() {
        return this.description;
    }

    public String getNameAndShortcut() {
        return this.nameAndShortcut;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public abstract void update();

    public abstract void onEnter();

    public abstract void onExit();

    public void checkHealth() {
        if (this.health <= 0) {
            this.death();
        }
    }

    protected void death() {
        this.isAlive = false;
    }


    @Override
    public boolean attack(GameItem other) {
		// TODO Auto-generated method stub
		return false;
	}
    
    public boolean receiveDamage(int damage) {
    	this.health -= damage;
    	this.checkHealth();
    	return true;
    }
    
    public boolean receiveZombieDamage(int damage) {
    	return false;
    }
    
    public boolean receivePlantDamage(int damage) {
    	return false;
    }
    
    public boolean getSuns() {
    	return false;
    }
    
    
    ///---------------------------------
    // Exolosion --- MAL ----- CORREGIR
    
    /*
    
    public boolean explode(GameItem other) {
    	if(other.isInExplosionRange(other)) other.receiveAttack(this, damage);
		return isAlive;
    }
    
    @Override
    public boolean isInExplosionRange(GameItem other) {
    	if(other.isInPosition(this.position.getleftPosition(position))) return true;
		if(other.isInPosition(this.position.getAboveLeftPosition(position))) return true;
		if(other.isInPosition(this.position.getAbovePosition(position))) return true;
		if(other.isInPosition(this.position.getAboveRightPosition(position))) return true;
		if(other.isInPosition(this.position.getleftPosition(position))) return true;
		if(other.isInPosition(this.position.getBelowLeftPosition(position))) return true;
		if(other.isInPosition(this.position.getRightPosition(position))) return true;
		if(other.isInPosition(this.position.getBelowPosition(position))) return true;
		return false;
    }*/
}
