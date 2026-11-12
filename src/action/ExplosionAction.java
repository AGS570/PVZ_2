package action;

import logic.GameWorld;
import logic.Position;
import utils.Utilidades;
import utils.Utilidades.EQUIPOS;

public class ExplosionAction implements GameAction{

	private Position p ;
	protected int damage;
	public ExplosionAction(Position position, int damage) {
		// TODO Auto-generated constructor stub
		p = position;
		this.damage = damage;
	}

	@Override
	public void execute(GameWorld game) {
		// TODO Auto-generated method stub
		this.attackExplosionRange(game, p);
	}

	protected void attackExplosionRange(GameWorld game, Position pos) {
		Position nPos;
	    for (int i = -1; i <= 1; i++) {
	        for (int j = -1; j <= 1; j++) {

	            if (i != 0 || j != 0) {
	                 nPos = pos.targetPosition(i, j);

	                if (nPos.isValid()) {
	                    this.doDamage(game,nPos);
	                }
	            }
	        }
	    }
	}
	
	protected void doDamage(GameWorld game, Position nPos) {
		// TODO Auto-generated method stub
		game.ReceiveDamage(nPos, damage);
	}

	
}

