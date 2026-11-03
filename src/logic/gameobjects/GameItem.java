package logic.gameobjects;

import logic.Position;

/**
 * Common contract for objects that can interact on the game board.
 * Damage is expressed as a value so implementations do not depend on
 * the concrete class of the attacker.
 */
public interface GameItem {

    boolean isInPosition(Position position);

    boolean isInRow(Position position);

    boolean attack(GameItem other);

    boolean receiveZombieAttack(int damage);

    boolean receivePeaAttack(int damage);
}
