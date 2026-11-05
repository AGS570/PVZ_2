package logic.gameobjects;

import logic.GameWorld;
import logic.Position;
import view.Messages;

public class Zombie extends GameObject{

	protected int fr;
	protected int dmg;
	
	
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
            return other.receiveAttack(this,this.dmg);
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
	
	protected boolean move(Position np) {
		if(game.isInsideBoard(np) && game.isEmpty(np)) {
			if(this.fr == 0) {
				this.position = np;
				this.fr = 2;
				return true;				
			}else {
				fr--;		
			}
			return false;
		}else return false;
	}


	
	@Override
	protected void death() {
	    super.death();
	    game.zombieDied();
	}	
	
	protected void win() {
		if(this.position.ReachedHome())this.game.ZombiesWin();
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
		 if (!this.isAlive || damage <= 0) {
	            return false;
	        }

	        this.health -= damage;
	        this.checkHealth();
	        return true;
	}

	

}
