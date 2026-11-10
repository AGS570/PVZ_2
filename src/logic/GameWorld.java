package logic;

import action.ExplosionAction;
import action.GameAction;
import logic.gameobjects.GameItem;
import logic.gameobjects.GameObject;
import logic.gameobjects.suns.Sun;

public interface GameWorld {

    public static final int NUM_ROWS = 4;
    public static final int NUM_COLS = 8;

    boolean isEmpty(Position position);
    boolean isInsideBoard(Position position);
    void getSun(int suns);
    void shoot();
    void doAttack(GameItem obj);
    void addZombie(GameObject zombie);
    void pWins();
    void zombieDied();
    void ZombiesWin();
	void pushAction(GameAction gameAction);
	void ReceiveDamage(Position nPos, int damage);
	void ReceivePlantDamage(Position nPos, int damage);
	void ReceiveZombieDamage(Position nPos, int damage);
	void addSun(GameObject go);
	void addSun();
}