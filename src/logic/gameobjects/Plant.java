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

    @Override
    public boolean receiveZombieAttack(int damage) {
        if (!this.isAlive || damage <= 0) {
            return false;
        }

        this.health -= damage;
        this.checkHealth();
        return true;
    }

    @Override
    public boolean receivePeaAttack(int damage) {
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
}
