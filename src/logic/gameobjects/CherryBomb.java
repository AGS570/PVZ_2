package logic.gameobjects;

import logic.GameWorld;
import logic.Position;
import utils.Utilidades;
import view.Messages;

public class CherryBomb extends Plant{
	public CherryBomb(GameWorld game, Position p) {
		super(game, p);
		// TODO Auto-generated constructor stub
		this.health = 3;
		this.name = Messages.CHERRY_BOMB_NAME;
		this.description = Messages.CHERRY_BOMB_DESCRIPTION;
		this.icon = Messages.CHERRY_BOMB_SYMBOL;
		this.nameAndShortcut = Messages.CHERRY_BOMB_NAME_SHORTCUT;
		this.cost = Utilidades.CHERRY_BOMB_COST;
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
	            this.game.doAttack(this);
	        }
	    }

	    @Override
	    public boolean attack(GameItem other) {
	        if (other == null) {
	            return false;
	        }

	        if (other.isInRow(this.position)) {
	            return other.receivePeaAttack(this.damage);
	        }

	        return false;
	    }

}
