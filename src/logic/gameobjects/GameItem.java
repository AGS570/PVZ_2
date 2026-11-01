package logic.gameobjects;

import logic.Position;

public interface GameItem {

	public boolean isInPosition(Position np);
	boolean attack(GameItem other);
	public boolean isInRow(Position position);
	public boolean receiveAttack(PeaShooter obj);
	public boolean receiveAttack(Zombie obj);
}
