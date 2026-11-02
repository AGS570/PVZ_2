package logic.gameobjects;

import logic.GameWorld;
import logic.Position;
import view.Messages;

public class PeaShooter extends Plant{

	public PeaShooter(GameWorld game, Position p) {
		super(game, p);
		// TODO Auto-generated constructor stub
		this.health = 3;
		this.name = Messages.PEASHOOTER_NAME;
		this.description = Messages.PEASHOOTER_DESCRIPTION;
		this.icon = Messages.PEASHOOTER_ICON;
		this.nameAndShortcut = Messages.PEASHOOTER_NAME_AND_SHORTCUT;
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

