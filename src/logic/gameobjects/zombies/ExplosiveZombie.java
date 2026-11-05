package logic.gameobjects.zombies;

import logic.GameWorld;
import logic.Position;
import view.Messages;

public class ExplosiveZombie extends Zombie{

	public ExplosiveZombie(GameWorld game, Position p) {
		super(game, p);
		// TODO Auto-generated constructor stub
		this.name = Messages.EXPLOSIVE_ZOMBIE_NAME;
		this.description = Messages.ZOMBIE_DESCRIPTION;
		this.icon = Messages.EXPLOSIVE_ZOMBIE_SYMBOL;
		this.nameAndShortcut = Messages.ZOMBIE_NAME_AND_SHORTCUT;
		
		this.damage = 10;
		this.health = 3;
	}

	public ExplosiveZombie() {
		// TODO Auto-generated constructor stub
		super();
		this.damage = 10;
		this.health = 3;
		this.name = Messages.EXPLOSIVE_ZOMBIE_NAME;
		this.description = Messages.ZOMBIE_DESCRIPTION;
		this.icon = Messages.EXPLOSIVE_ZOMBIE_SYMBOL;
		this.nameAndShortcut = Messages.ZOMBIE_NAME_AND_SHORTCUT;
	}

}
