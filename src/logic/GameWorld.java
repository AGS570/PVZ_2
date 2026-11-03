package logic;

import logic.gameobjects.GameItem;
import logic.gameobjects.Plant;
import logic.gameobjects.Zombie;

public interface GameWorld {

	  public static final int NUM_ROWS = 4;
	  public static final int NUM_COLS = 8;

	  boolean isEmpty(Position position);
	  boolean isInsideBoard(Position position);
	  void getSun(int suns);
	  void shoot();
	  void doAttack(GameItem obj);
	  void addZombie(Zombie zombie);
	  Plant addSunflower(Position position);
	  Plant addPeashooter(Position position);
	  void pWins();
	  void zombieDied();
	  void ZombiesWin();
	  boolean canAfford(int cost);

	  // ...
	}
