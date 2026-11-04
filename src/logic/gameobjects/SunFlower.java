package logic.gameobjects;

import logic.GameWorld;
import logic.Position;
import utils.Utilidades;
import view.Messages;

public class SunFlower extends Plant{
	
	private static final int SOLES = 20;
	
	private int coolDown;
	
	public SunFlower(GameWorld game, Position p) {
		super(game, p);
		// TODO Auto-generated constructor stub
		this.coolDown = 3;
		this.health = 1;
		this.name = Messages.SUNFLOWER_NAME;
		this.description = Messages.SUNFLOWER_DESCRIPTION;
		this.icon = Messages.SUNFLOWER_ICON;
		this.nameAndShortcut = Messages.SUNFLOWER_NAME_AND_SHORTCUT;
		this.cost = Utilidades.SUNFLOWER_COST;
	}
	
	public SunFlower() {
		// TODO Auto-generated constructor stub
	}

	@Override 
	public void update() {
		this.checkHealth();
		if (this.coolDown <= 0 && this.isAlive) {
			
			this.getSun(SOLES);
			this.coolDown = 3;
		}else this.coolDown--;
	}

	private void getSun(int suns) {
		// TODO Auto-generated method stub
		this.game.getSun(suns);
	}
	
	

}
