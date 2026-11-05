package logic.gameobjects;

import logic.GameWorld;
import logic.Position;
import view.Messages;

public class Plant extends GameObject{
	
	protected int cost;
	private int coolDown = 3;
	public Plant(GameWorld game, Position p) {
		super(game, p);
		// TODO Auto-generated constructor stub
		cost =0;
		this.damage =0;
	}

	
	public Plant() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onExit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public boolean attack(GameItem other) {
		// TODO Auto-generated method stub
		return false;
	}

   


///--------------------------------------------
/// 
/// REVISAR
/// 
/// --------------------------------------------

	public int getCost() {
		return cost;
	}


public boolean isInValidPosition() {
	// TODO Auto-generated method stub
	return this.position.inBoard();
}


public boolean isInPosition(GameObject go) {
	// TODO Auto-generated method stub
	return go.isInPosition(position);
}

@Override
public String getDescription() {
    return this.description.formatted(this.cost,this.damage,this.health);
}


@Override
public boolean isInExplosionRange(GameItem other) {
	// TODO Auto-generated method stub
	return false;
}


@Override
public boolean receiveAttack(GameObject obj, int damage) {
	// TODO Auto-generated method stub
	return false;
}


@Override
public boolean receiveAttack(Zombie obj, int dmg) {
	 if (!this.isAlive || damage <= 0) {
         return false;
     }

     this.health -= damage;
     this.checkHealth();
     return true;
}


@Override
public boolean receiveAttack(PeaShooter obj, int damage) {
	// TODO Auto-generated method stub
	return false;
}

}
