package logic.gameobjects;

import logic.Position;

public interface GameItem {

	
	public boolean receiveInteraction(Zombie obj, int dmg);
	public boolean receiveInteraction(PeaShooter obj, int dmg);
	public boolean isInPosition(Position np);
	public boolean attack(GameObject o);
	public boolean receiveAttack(Zombie obj);
}
