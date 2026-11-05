package action;

import logic.GameWorld;
import logic.Position;

public class ExplosionAction implements GameAction{

	private Position p ;
	private int damage;
	public ExplosionAction(Position position, int damage) {
		// TODO Auto-generated constructor stub
		p = position;
		this.damage = damage;
	}

	@Override
	public void execute(GameWorld game) {
		// TODO Auto-generated method stub
		
	}

}
