package logic;

import logic.gameobjects.Zombie;

public interface GameModel {
	public void reset();
	public void help();
	public void addPlant(String[] commandWords);
	public void quit();
	public void addZombie(Position p);
	public void finishGame(boolean b);
	
}
