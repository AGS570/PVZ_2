package logic.gameobjects.plants;

import logic.GameWorld;
import logic.Position;
import logic.gameobjects.GameItem;
import utils.Utilidades;
import view.Messages;

public class PeaShooter extends Plant{

	public PeaShooter(GameWorld game, Position p) {
		super(game, p);
		// TODO Auto-generated constructor stub
		this.health = 3;
		this.name = Messages.PEASHOOTER_NAME;
		this.description = Messages.PEASHOOTER_DESCRIPTION;
		this.icon = Messages.PEASHOOTER_ICON;
		this.nameAndShortcut = Messages.PEASHOOTER_NAME_AND_SHORTCUT;
		this.cost = Utilidades.PEASHOOTER_COST;
	}

	 public PeaShooter() {
	        super();
	        this.health = 3;
	        this.name = Messages.PEASHOOTER_NAME;
	        this.description = Messages.PEASHOOTER_DESCRIPTION;
	        this.icon = Messages.PEASHOOTER_ICON;
	        this.nameAndShortcut = Messages.PEASHOOTER_NAME_AND_SHORTCUT;
	        this.cost = Utilidades.PEASHOOTER_COST;
	        this.damage = 1;
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
	            return other.receiveAttack(this,this.damage);
	        }

	        return false;
	    }

}

