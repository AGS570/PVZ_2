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
		this.health = 5;
		
		this.name = Messages.ZOMBIE_NAME;
		this.description = Messages.ZOMBIE_DESCRIPTION;
		this.icon = Messages.ZOMBIE_ICON;
		this.nameAndShortcut = Messages.ZOMBIE_NAME_AND_SHORTCUT;
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
		this.win();
		if(this.isAlive ) {
			Position np = this.position.newPosition();
			if(!move(np)) {
				this.game.doAttack(this);
			}
		}
	}
	
	
	@Override
	public boolean attack(GameItem other) {
		Position np = this.position.newPosition();
		if (other.isInPosition(np)) {
			other.receiveAttack(this);
			return true;
		}
		return false;
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
		if(game.isInsideBoard(np) && game.isEmpty(np)) {
			this.position = np;
			return true;
		}else return false;
	}

	@Override
	public boolean receiveAttack(Zombie obj) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean receiveAttack(PeaShooter obj) {
		if(obj == null || this.isAlive == false) return false;
		else {
			this.health -= 1; 
			this.checkHealth();
			return true;
		}
	}
	
	@Override
	public void death() {
	    super.death();
	    game.zombieDied();
	}
	
	private void win() {
		if(this.position.ReachedHome())this.game.ZombiesWin();
	}

	private void ZombiesWin() {
		// TODO Auto-generated method stub
		this.game.ZombiesWin();
	}

}
