package logic;

import java.util.Random;

import control.Level;
import logic.gameobjects.GameItem;
import logic.gameobjects.GameObject;
import logic.gameobjects.Plant;
import logic.gameobjects.PlantFactory;
import logic.gameobjects.ZombieManager;

public class Game implements GameStatus, GameWorld, GameModel {

	  public static final int INITIAL_COINS = 50;
	  private int sunCoins;
	  private boolean playerQuits;	  
	  private int cycles;
	  private boolean isGameFinished;
	  private PlantFactory factory;
	  private Random rand;
	  private Level level;
	  
	  private GameObjectContainer ObjectContainer;
	  private ZombieManager zombieManager;
	  private boolean playerWins;
	  private boolean zombiesWin;
		
	  public Game(long seed, control.Level level) {
			// TODO Auto-generated constructor stub
			sunCoins = this.INITIAL_COINS;
			cycles = 0;
			this.ObjectContainer = new GameObjectContainer();
			this.isGameFinished = false;
			this.playerQuits = false;
			this.rand = new Random(seed);
			this.factory = new PlantFactory();
			this.zombieManager = new ZombieManager(this,level,rand);
			this.playerWins = false;
			this.level = level;
		}
	  //...

	 

	  @Override
	  public void reset() {
		    sunCoins = INITIAL_COINS;
		    cycles = 0;
		    isGameFinished = false;
		    playerQuits = false;
		    ObjectContainer = new GameObjectContainer();
		    this.zombieManager = new ZombieManager(this,level,rand);

		}
	  @Override
	  public void help() {
		// TODO Auto-generated method stub
		
	  }

	  @Override
	  public String addPlant(String[] commandWords) {
		// TODO Auto-generated method stub
		  Plant p = this.factory.parse(commandWords, this);
		  if(p != null) {
			  this.ObjectContainer.addObject(p);
			  return "Ok";
		  }
		  else return "Error";
	  }

	  @Override
	  public void quit() {
		// TODO Auto-generated method stub
		this.playerQuits = true;
	  }

	  @Override
	  public boolean isEmpty(Position position) {
		// TODO Auto-generated method stub
		return this.ObjectContainer.isPositionEmpty(position);
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
	  
	  @Override
	  public void update() {
		  this.cycles++;
		  this.ObjectContainer.update();
		  this.zombieManager.update();
	  }

	  @Override
	  public void getSun(int suns) {
		// TODO Auto-generated method stub
		this.sunCoins += suns;
	  }

	  @Override
	  public String positionToString(Position position) {
		// TODO Auto-generated method stub
		return this.ObjectContainer.positionToString(position);
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
	  public void addZombie(GameObject zombie) {
		// TODO Auto-generated method stub
		this.ObjectContainer.addObject(zombie);
	  }

	  



	  @Override
	  public boolean hasGameFinished() {
		// TODO Auto-generated method stub
		return this.isGameFinished;
	  }



	  @Override
	  public boolean playerQuits() {
		// TODO Auto-generated method stub
		return this.playerQuits;
	  }



	  @Override
	  public String listPlants() {
		// TODO Auto-generated method stub
		String s = this.factory.list();
		return s;
	  }



	  @Override
	  public boolean playerWins() {
		// TODO Auto-generated method stub
		return this.playerWins;
	  }



	  @Override
	  public int getSuncoins() {
		// TODO Auto-generated method stub
		return this.sunCoins;
	  }



	  @Override
	  public int getRemainingZombies() {
		// TODO Auto-generated method stub
		return this.zombieManager.getRemainingZombies();
	  }



	  @Override
	  public void pWins() {
		// TODO Auto-generated method stub
		this.playerWins = true;
		this.finishGame(true);
	  }



	  @Override
	  public void zombieDied() {
		// TODO Auto-generated method stub
		this.zombieManager.zombieDied();
	  }



	  @Override
	  public void ZombiesWin() {
		// TODO Auto-generated method stub
			this.finishGame(true);
	  }



	  @Override
	  public boolean canAfford(int cost) {
		// TODO Auto-generated method stub
		  if(this.sunCoins >= cost) {
			  this.sunCoins -= cost;
			  return true;
		  }
		return false;
	  }

	  
}