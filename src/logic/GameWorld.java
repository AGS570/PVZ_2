package logic;

import logic.gameobjects.Zombie;

public interface GameWorld {

	  public static final int NUM_ROWS = 4;
	  public static final int NUM_COLS = 8;

	  boolean isEmpty(Position position);
	  boolean isInsideBoard(Position position);
	  void getSun(int suns);
	  void shoot();
	  void receiveAttack(Zombie obj);
	  void doAttack(Zombie zombie);

	  // ...
	}
