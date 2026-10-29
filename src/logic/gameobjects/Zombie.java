package logic.gameobjects;

import logic.GameWorld;
import logic.Position;
import view.Messages;

public class Zombie extends GameObject{

	private int fr;
	private int dmg;
	private ZombieManager zmn;
	Zombie(GameWorld game, Position p) {
		super(game, p);
		// TODO Auto-generated constructor stub
		this.fr = 2;
		this.dmg =1;
	}
	@Override
	public String getIcon() {
		// TODO Auto-generated method stub
		return Messages.ZOMBIE_ICON;
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return Messages.ZOMBIE_DESCRIPTION;
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.checkHealth();
		if(this.isAlive) {
			Position np = this.position.newPosition();
			if(!move(np)) {
				attack(np);
			}
		}
	}
	
	private void attack(Position np) {
		// TODO Auto-generated method stub
		this.zmn.attack(np, dmg);
	}
	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onExit() {
		// TODO Auto-generated method stub
		
	}
	
	private boolean move(Position np) {
				if(np.isEmpty()) {
			this.position = np;
			return true;
		}else return false;
	}

}
