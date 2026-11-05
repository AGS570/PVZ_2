package logic.gameobjects;

import logic.GameWorld;
import logic.Position;

public class SportyZombie extends Zombie{

	SportyZombie(GameWorld game, Position p) {
		super(game, p);
		// TODO Auto-generated constructor stub
		this.health = 2;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.checkHealth();
		this.win();
		if(this.isAlive ) {
			Position np = this.position.newPosition();
			if(!move(np)) {
				if(!move(np)) {
					this.game.doAttack(this);
				}else {
					
					this.game.doAttack(this);
				}
			}
		}
	}
	
}
