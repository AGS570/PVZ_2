package action;

import logic.GameWorld;
import logic.Position;
import utils.Utilidades.EQUIPOS;

public class PlantExplosionAction extends ExplosionAction{

	public PlantExplosionAction(Position position, int damage) {
		super(position, damage);
		// TODO Auto-generated constructor stub
	}
		@Override
		protected void doDamage(GameWorld game, Position nPos) {
			game.ReceivePlantDamage(nPos, damage);
		}
}
