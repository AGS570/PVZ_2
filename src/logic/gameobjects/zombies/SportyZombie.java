package logic.gameobjects.zombies;

import logic.GameWorld;
import logic.Position;
import view.Messages;

public class SportyZombie extends Zombie{

	public SportyZombie(GameWorld game, Position p) {
		super(game, p);
		// TODO Auto-generated constructor stub
		this.health = 2;
		this.fr = 1;
		this.name = Messages.SPORTY_ZOMBIE_NAME;
		this.description = Messages.ZOMBIE_DESCRIPTION;
		this.icon = Messages.SPORTY_ZOMBIE_SYMBOL;
		this.nameAndShortcut = Messages.ZOMBIE_NAME_AND_SHORTCUT;
	}
	
	public SportyZombie() {
		// TODO Auto-generated constructor stub
		super();
		this.name = Messages.SPORTY_ZOMBIE_NAME;
		this.description = Messages.ZOMBIE_DESCRIPTION;
		this.icon = Messages.SPORTY_ZOMBIE_SYMBOL;
		this.nameAndShortcut = Messages.ZOMBIE_NAME_AND_SHORTCUT;
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
	
}
