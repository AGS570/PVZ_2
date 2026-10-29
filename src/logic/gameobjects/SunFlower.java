package logic.gameobjects;

import logic.GameWorld;
import logic.Position;

public class SunFlower extends Plant{
	
	private static final int SOLES = 20;
	
	private int coolDown;
	
	SunFlower(GameWorld game, Position p) {
		super(game, p);
		// TODO Auto-generated constructor stub
		this.coolDown = 3;
	}
	
	@Override 
	public void update() {
		if (this.coolDown <= 0) {
			this.getSun(SOLES);
			this.coolDown = 3;
		}else this.coolDown--;
	}

	private void getSun(int suns) {
		// TODO Auto-generated method stub
		this.game.getSun(suns);
	}
	
	

}
