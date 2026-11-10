package logic.gameobjects.zombies;

import action.ExplosionAction;
import action.ZombieExplosionAction;
import logic.GameWorld;
import logic.Position;
import view.Messages;

public class ExplosiveZombie extends Zombie{
	private int exDamage;
	public ExplosiveZombie(GameWorld game, Position p) {
		super(game, p);
		// TODO Auto-generated constructor stub
		this.name = Messages.EXPLOSIVE_ZOMBIE_NAME;
		this.description = Messages.ZOMBIE_DESCRIPTION;
		this.icon = Messages.EXPLOSIVE_ZOMBIE_SYMBOL;
		this.nameAndShortcut = Messages.ZOMBIE_NAME_AND_SHORTCUT;
		
		this.exDamage = 3;
	}

	public ExplosiveZombie() {
		// TODO Auto-generated constructor stub
		super();
		this.name = Messages.EXPLOSIVE_ZOMBIE_NAME;
		this.description = Messages.ZOMBIE_DESCRIPTION;
		this.icon = Messages.EXPLOSIVE_ZOMBIE_SYMBOL;
		this.nameAndShortcut = Messages.ZOMBIE_NAME_AND_SHORTCUT;
	}

	@Override
	 public void checkHealth() {
        if (this.health <= 0) {
            this.death();
            this.game.pushAction(new ZombieExplosionAction(this.position,this.exDamage)); 
        }
    }
}
