package logic.gameobjects;

import logic.GameWorld;
import logic.Position;

public class Plant extends GameObject{
	
	private int coolDown = 3;
	Plant(GameWorld game, Position p) {
		super(game, p);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getIcon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
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
	
	public boolean receiveInteraction(Zombie obj, int dmg) {
		if(obj == null) return false;
		else {
			this.health -= dmg;
			return true;
		}
	}

}
