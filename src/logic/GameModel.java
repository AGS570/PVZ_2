package logic;

import logic.gameobjects.Zombie;

public interface GameModel {
	public void reset();
	public void help();
	public void addPlant(String[] commandWords);
	public void quit();
	public void finishGame(boolean b);
	public boolean hasGameFinished();
	public boolean playerQuits();
	public String listPlants();
	public boolean playerWins();
	public void update();

	
}
