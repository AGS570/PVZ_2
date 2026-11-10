package logic.gameobjects.suns;

import logic.GameWorld;
import logic.Position;
import logic.gameobjects.GameItem;
import logic.gameobjects.GameObject;
import logic.gameobjects.plants.PeaShooter;
import logic.gameobjects.zombies.Zombie;

public class Sun extends GameObject{

	private int timer;
	
	private int sunCoins;
	
	public Sun() {
		timer = 11;
		this.sunCoins = 10;
	}
	
	public Sun(GameWorld game, Position np) {
		super(game,np);
		// TODO Auto-generated constructor stub
		timer = 11;
		this.sunCoins = 10;
		
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveAttack(PeaShooter obj, int damage) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(this.timer == 0) {
			this.death();
		}
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
	public boolean getSuns() {
		this.game.getSun(sunCoins);
    	return true;
    }

}
