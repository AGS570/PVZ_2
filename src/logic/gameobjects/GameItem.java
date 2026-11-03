
package logic.gameobjects;

import logic.Position;

public interface GameItem {

    boolean isInPosition(Position position);

    boolean isInRow(Position position);

    boolean attack(GameItem other);

    boolean receiveZombieAttack(int damage);

    boolean receivePeaAttack(int damage);
}
