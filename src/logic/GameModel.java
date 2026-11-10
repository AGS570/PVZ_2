package logic;

import logic.gameobjects.zombies.Zombie;

public interface GameModel {
	public void reset();
	public void help();
	public String addPlant(String[] commandWords);
	public String addZombie(String[] zombieWords);
	public void quit();
	public void finishGame(boolean b);
	public boolean hasGameFinished();
	public boolean playerQuits();
	public String listPlants();
	public boolean playerWins();
	public void update();
	void zombieDied();
	void ZombiesWin();
	public String listZombies();
	public String addPlantCheat(String[] plantWords);
	public void catchSun(String[] commandWords);

	
}
