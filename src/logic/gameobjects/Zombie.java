package logic.gameobjects;

import logic.GameWorld;
import logic.Position;
import view.Messages;

public class Zombie extends GameObject{

	private int fr;
	private int dmg;
	
	
	
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
        if (other == null) {
            return false;
        }

        Position nextPosition = this.position.newPosition();

        if (other.isInPosition(nextPosition)) {
            return other.receiveZombieAttack(this.dmg);
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
    public boolean receiveZombieAttack(int damage) {
        return false;
    }

    @Override
    public boolean receivePeaAttack(int damage) {
        if (!this.isAlive || damage <= 0) {
            return false;
        }

        this.health -= damage;
        this.checkHealth();
        return true;
    }
	
	@Override
	protected void death() {
	    super.death();
	    game.zombieDied();
	}	
	
	private void win() {
		if(this.position.ReachedHome())this.game.ZombiesWin();
	}

	

}
