package logic.gameobjects;

import logic.GameWorld;
import logic.Position;

public class PeaShooter extends Plant{

	PeaShooter(GameWorld game, Position p) {
		super(game, p);
		// TODO Auto-generated constructor stub
	}

	@Override 
	public void update() {
		this.checkHealth();
		if(this.isAlive)
			this.shoot();
	}

	private void shoot() {
		// TODO Auto-generated method stub
		
	}
}
