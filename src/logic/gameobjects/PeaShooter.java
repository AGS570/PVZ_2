package logic.gameobjects;

import logic.GameWorld;
import logic.Position;

public class PeaShooter extends Plant{

	public PeaShooter(GameWorld game, Position p) {
		super(game, p);
		// TODO Auto-generated constructor stub
	}

	public  PeaShooter() {
		// TODO Auto-generated constructor stub
		
	}

	@Override 
	public void update() {
		this.checkHealth();
		if(this.isAlive)
			this.game.doAttack(this);
	}

	private void shoot() {
		// TODO Auto-generated method stub
		this.game.shoot();
	}
	
	@Override
	public boolean attack(GameItem other) {
		// TODO Auto-generated method stub
		if(other.isInRow(position)) {
			return other.receiveAttack(this);
			
		}
		return false;
	}

}

