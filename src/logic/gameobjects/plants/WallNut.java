package logic.gameobjects.plants;

import logic.GameWorld;
import logic.Position;
import utils.Utilidades;
import view.Messages;

public class WallNut extends Plant{
	public WallNut(GameWorld game, Position p) {
		super(game, p);
		// TODO Auto-generated constructor stub
		this.health = 8;
		this.name = Messages.WALL_NUT_NAME;
		this.description = Messages.WALL_NUT_DESCRIPTION;
		this.icon = Messages.WALL_NUT_SYMBOL;
		this.nameAndShortcut = Messages.WALL_NUT_NAME_SHORTCUT;
		this.cost = Utilidades.WALL_NUT_COST;
	}

	 public WallNut() {
	        super();
	        this.health = 8;
	        this.name = Messages.WALL_NUT_NAME;
	        this.description = Messages.WALL_NUT_DESCRIPTION;
	        this.icon = Messages.WALL_NUT_SYMBOL;
	        this.nameAndShortcut = Messages.WALL_NUT_NAME_SHORTCUT;
	        this.cost = Utilidades.PEASHOOTER_COST;
	    }

	    @Override
	    public void update() {
	        this.checkHealth();

	    }

}
