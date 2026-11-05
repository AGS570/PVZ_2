package logic.gameobjects.plants;

import action.ExplosionAction;
import action.GameAction;
import logic.GameWorld;
import logic.Position;
import logic.gameobjects.GameItem;
import utils.Utilidades;
import view.Messages;

public class CherryBomb extends Plant{
	private int timer;
	public CherryBomb(GameWorld game, Position p) {
		super(game, p);
		// TODO Auto-generated constructor stub
		this.health = 3;
		this.name = Messages.CHERRY_BOMB_NAME;
		this.description = Messages.CHERRY_BOMB_DESCRIPTION;
		this.icon = Messages.CHERRY_BOMB_SYMBOL;
		this.nameAndShortcut = Messages.CHERRY_BOMB_NAME_SHORTCUT;
		this.cost = Utilidades.CHERRY_BOMB_COST;
		this.timer = 3;
	}

	 public CherryBomb() {
	        super();
	        this.health = 2;
	        this.name = Messages.CHERRY_BOMB_NAME;
	        this.description = Messages.CHERRY_BOMB_DESCRIPTION;
	        this.icon = Messages.CHERRY_BOMB_SYMBOL;
	        this.nameAndShortcut = Messages.CHERRY_BOMB_NAME_SHORTCUT;
	        this.cost = Utilidades.PEASHOOTER_COST;
	        this.damage = 10;
	    }

	    @Override
	    public void update() {
	        this.checkHealth();

	        if (this.isAlive) {
	        	if(timer == 1) this.icon = "C";
	        	else if(this.timer == 0){
	        		
	        		this.explode();
	        	}
	        }
	    }

	    private void explode() {
			// TODO Auto-generated method stub
	    	this.isAlive = false;
	    	this.health = 0;
	    	this.game.pushAction(new ExplosionAction(this.position,this.damage)); 
			
		}

		@Override
	    public boolean attack(GameItem other) {
	        if (other == null) {
	            return false;
	        }

	        if (other.isInRow(this.position)) {
	            return other.receiveAttack(this,this.damage);
	        }

	        return false;
	    }

}
