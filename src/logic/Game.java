package logic;

import logic.gameobjects.GameItem;
import logic.gameobjects.PeaShooter;
import logic.gameobjects.Plant;
import logic.gameobjects.PlantFactory;
import logic.gameobjects.SunFlower;
import logic.gameobjects.Zombie;

public class Game implements GameStatus, GameWorld, GameModel {

	  public static final int INITIAL_COINS = 50;
	  private int sunCoins;
	  private boolean playerQuits;	  
	  private int cycles;
	  private boolean isGameFinished;
	  private PlantFactory factory;
		
	  private GameObjectContainer ObjectContainer;
		
	  public Game(long seed, Level level) {
			// TODO Auto-generated constructor stub
			sunCoins = this.INITIAL_COINS;
			cycles = 0;
			this.ObjectContainer = new GameObjectContainer();
			this.isGameFinished = false;
			this.playerQuits = false;
			this.factory = new PlantFactory();
		}
	  //...

	  @Override
	  public void reset() {
		// TODO Auto-generated method stub
		
	  }

	  @Override
	  public void help() {
		// TODO Auto-generated method stub
		
	  }

	  @Override
	  public void addPlant(String[] commandWords) {
		// TODO Auto-generated method stub
		  this.factory.parse(commandWords, this);
	  }

	  @Override
	  public void quit() {
		// TODO Auto-generated method stub
		this.playerQuits = true;
	  }

	  @Override
	  public boolean isEmpty(Position position) {
		// TODO Auto-generated method stub
		return position.isEmpty();
	  }

	  @Override
	  public boolean isInsideBoard(Position position) {
		// TODO Auto-generated method stub
		return position.inBoard();
	  }		

	  @Override
	  public int getCycles() {
		// TODO Auto-generated method stub
		return this.cycles;
	  }
	  
	  public void update() {
		  this.ObjectContainer.update();
	  }

	  @Override
	  public void getSun(int suns) {
		// TODO Auto-generated method stub
		this.sunCoins += suns;
	  }

	  @Override
	  public String positionToString(Position position) {
		// TODO Auto-generated method stub
		return null;
	  }

	  @Override
	  public void shoot() {
		// TODO Auto-generated method stub
		//this.ObjectContainer.shoot();
	  }

	  @Override
	  public void doAttack(GameItem obj) {
		// TODO Auto-generated method stub
		this.ObjectContainer.doAttack(obj);
	  }

	  
	  @Override
	  public void finishGame(boolean b) {
		// TODO Auto-generated method stub
		this.isGameFinished = true;
	  }

	  @Override
	  public void addZombie(Zombie zombie) {
		// TODO Auto-generated method stub
		this.ObjectContainer.addObject(zombie);
	  }

	  @Override
	  public Plant addSunflower(Position position) {
		// TODO Auto-generated method stub
		return new SunFlower(this,position) ;
	  }

	  @Override
	  public Plant addPeashooter(Position position) {
		// TODO Auto-generated method stub
		return new PeaShooter(this,position) ;
	  }

	  
}