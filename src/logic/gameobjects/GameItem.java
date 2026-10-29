package logic.gameobjects;

import logic.Position;

public interface GameItem {

	public boolean isInPosition(Position np);
	public boolean receiveAttack(Zombie obj);
	boolean attack(GameItem other);
}
