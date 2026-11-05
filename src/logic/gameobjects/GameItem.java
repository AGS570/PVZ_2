
package logic.gameobjects;

import logic.Position;
import logic.gameobjects.plants.PeaShooter;
import logic.gameobjects.zombies.Zombie;

public interface GameItem {

    boolean isInPosition(Position position);

    boolean isInRow(Position position);

    boolean attack(GameItem other);

   

	boolean isInExplosionRange(GameItem other);

	boolean receiveAttack(GameObject obj,int damage);

	boolean receiveAttack(Zombie obj, int dmg);

	boolean receiveAttack(PeaShooter obj, int damage);
}
