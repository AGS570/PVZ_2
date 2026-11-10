package action;

import logic.GameWorld;
import logic.Position;

public class ZombieExplosionAction extends ExplosionAction{
	public ZombieExplosionAction(Position position, int damage) {
		super(position, damage);
		// TODO Auto-generated constructor stub
	}
		@Override
		protected void doDamage(GameWorld game, Position nPos) {
			game.ReceiveZombieDamage(nPos, damage);
		}
}
