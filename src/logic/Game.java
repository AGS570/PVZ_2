package logic;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

import action.GameAction;
import control.Level;
import logic.gameobjects.GameItem;
import logic.gameobjects.GameObject;
import logic.gameobjects.factory.PlantFactory;
import logic.gameobjects.factory.ZombieFactory;
import logic.gameobjects.plants.Plant;
import logic.gameobjects.suns.SunsManager;
import logic.gameobjects.zombies.Zombie;
import logic.gameobjects.zombies.ZombieManager;
import view.Messages;

public class Game implements GameStatus, GameWorld, GameModel {

	  public static final int INITIAL_COINS = 50;
	  private int sunCoins;
	  private boolean playerQuits;	  
	  private int cycles;
	  private boolean isGameFinished;
	  private PlantFactory plantFactory;
	  private ZombieFactory zombieFactory;
	  private Random rand;
	  private Level level;
	  private Deque<GameAction> actions;
	  private GameObjectContainer ObjectContainer;
	  private ZombieManager zombieManager;
	  private boolean playerWins;
	  private boolean zombiesWin;
	  private SunsManager sunsManager;
	  private int generatedSuns;
	  private int caughtSuns;
	  private long seed;
	  
	  
	  ///------------
	  ///Revisar
	  private int lastTime;
	  //----------------
		
	  public Game(long seed, control.Level level) {
			// TODO Auto-generated constructor stub
			sunCoins = this.INITIAL_COINS;
			cycles = 0;
			this.ObjectContainer = new GameObjectContainer();
			this.isGameFinished = false;
			this.playerQuits = false;
			this.rand = new Random(seed);
			this.plantFactory = new PlantFactory();
			this.zombieFactory = new ZombieFactory();
			this.zombieManager = new ZombieManager(this,level,rand);
			this.playerWins = false;
			this.level = level;
			this.actions = new ArrayDeque<GameAction>();
			this.sunsManager = new SunsManager(null, level, rand);
			this.generatedSuns = 0;
			this.caughtSuns = 0;
			this.lastTime = -1;
			
			
			
		}
	  //...

	 

	  @Override
	  public void reset() {
		    reset(this.level.name(),this.seed);

		}
	  public void reset(String level, long seed) {
		// TODO Auto-generated method stub
		  
		Level newLevel = Level.valueOfIgnoreCase(level);
		
		this.level=newLevel;
		this.seed=seed; 
		this.rand=new Random(seed);
		this.sunCoins=INITIAL_COINS;
		this.cycles=0;
		this.isGameFinished = false;
	    this.playerQuits = false;
	    this.playerWins = false;
	    this.zombiesWin = false;
	    this.ObjectContainer=new GameObjectContainer();
	    this.actions=new ArrayDeque<GameAction>();
	    this.zombieManager=new ZombieManager(this,this.level,this.rand);
	    this.generatedSuns = 0;
	    this.caughtSuns = 0;

	    this.lastTime = -1;
	    
		  
	}
	  @Override
	  public void help() {
		// TODO Auto-generated method stub
		
	  }

	  ///ADDOBJECT
	  ///----------------------------------
	  //Preguntatr
	  @Override
	  public String addPlant(String[] commandWords) {
		// TODO Auto-generated method stub
		  Plant p = this.plantFactory.parse(commandWords, this);
		  if(p != null) {
			  if(!p.getPosition().inBoard() || !isEmpty(p.getPosition())) {
				    return Messages.INVALID_POSITION;
				}
			  if(canAfford(p.getCost())) {
				  this.ObjectContainer.addObject(p);
				  return "Ok";
			  }else return Messages.NOT_ENOUGH_COINS;
		  }
		  else return Messages.INVALID_GAME_OBJECT;
	  }
	  
	  @Override
	  public String addPlantCheat(String[] plantWords) {
		  Plant p = this.plantFactory.parse(plantWords, this);
		  if(p != null) {
			  if(!p.getPosition().inBoard() || !isEmpty(p.getPosition())) {
				    return Messages.INVALID_POSITION;
				}
				  this.ObjectContainer.addObject(p);
				  return "Ok";
		  }
		  else return Messages.INVALID_GAME_OBJECT;
	  }
	  //------------------------------------------
	  @Override
	  public void addZombie(GameObject zombie) {
		  // TODO Auto-generated method stub
		  this.ObjectContainer.addObject(zombie);
	  }
	  
	  @Override
	  public String addZombie(String[] zombieWords) {
		  Zombie p = this.zombieFactory.parse(zombieWords, this);
		  if(p != null) {
			  if(!p.getPosition().inBoard() || !isEmpty(p.getPosition())) {
				    return Messages.INVALID_POSITION;
				}
				  this.ObjectContainer.addObject(p);
				  return "Ok";
		  }
		  else return Messages.INVALID_GAME_OBJECT;
	  }
	  
	  ///---------------------------------------------------------------
	  

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
	  
	 /* @Override
	  public void update() {
		  this.cycles++;
		 
		  this.zombieManager.update();
	  }*/

	 public void update() {

		  // 1. Execute pending actions
		  executePendingActions();

		  // 2. Execute game Actions
		  
		  // 3. Game object updates
		  this.ObjectContainer.update();
		  this.zombieManager.update();

		  // 4. & 5. Remove dead and execute pending actions
		  boolean deadRemoved = true;
		  deadRemoved = this.ObjectContainer.clean();
		  while (deadRemoved || arePendingActionsLeft()) {
		    // 4. Remove dead
		    deadRemoved = this.ObjectContainer.clean();

		    // 5. execute pending actions
		    executePendingActions();
		  }

		  this.cycles++;
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
	  public boolean playerWins() {
		// TODO Auto-generated method stub
		return this.playerWins;
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



	 private boolean canAfford(int cost) {
		 if(this.sunCoins >= cost) {
			 this.sunCoins -= cost;
			 return true;
		 }else return false;
	 }

	 
	 ///---------------------------------------------------
	 /// SOLES
	 ///------------------------------------------------------ 
	 @Override
	 public void getSun(int suns) {
		 // TODO Auto-generated method stub
		 this.sunCoins += suns;
		 this.caughtSuns++;
	 }


	 @Override
	 public int getGeneratedCoins() {
		// TODO Auto-generated method stub
		return this.generatedSuns;
	 }



	 @Override
	 public int getCaughtCoins() {
		// TODO Auto-generated method stub
		return this.caughtSuns;
	 }

	 @Override
	 public int getSuncoins() {
		 // TODO Auto-generated method stub
		 return this.sunCoins;
	 }
	 @Override
	 public void catchSun(int r, int c) {
		 // TODO Auto-generated method stub
		 Position nPos = new Position(r,c);
		 if(this.cycles != this.lastTime ) {
			this.ObjectContainer.catchSuns(nPos);
		 }
	 }
	 
	 @Override
	 public void addSun(GameObject go) {
		 // TODO Auto-generated method stub
		 this.ObjectContainer.addObject(go);
	 }
	 
	 
	 @Override
	 public void addSun() {
		 // TODO Auto-generated method stub
		 this.sunsManager.addSun();
	 }
	///-------------------------------------------------------  


	///---------------------------------------------------
	 //LISTAR
	 
	 @Override
	 public String listPlants() {
		 // TODO Auto-generated method stub
		 String s = this.plantFactory.list();
		 return s;
	 }

	 @Override
	 public String listZombies() {
		// TODO Auto-generated method stub
		return this.zombieFactory.list();
	 }





	 ///---------------------------------------
	 
	 
	 
	 ///----------------------------------------
	 /// ACTIONS
	 /// --------------------------------------
	 
	 @Override
	 public void pushAction(GameAction gameAction) {
		  this.actions.addLast(gameAction);
		}

		private void executePendingActions() {
		  while (!this.actions.isEmpty()) {
		    GameAction action = this.actions.removeFirst();
		    action.execute(this);
		  }
		}

		private boolean arePendingActionsLeft() {
		  return !this.actions.isEmpty();
		}



		@Override
		public void ReceiveDamage(Position nPos, int damage) {
			// TODO Auto-generated method stub
			this.ObjectContainer.receiveDamage(nPos,damage);
		}



		@Override
		public void ReceivePlantDamage(Position nPos, int damage) {
			// TODO Auto-generated method stub
			this.ObjectContainer.receivePlantDamage(nPos, damage);
		}



		@Override
		public void ReceiveZombieDamage(Position nPos, int damage) {
			// TODO Auto-generated method stub
			this.ObjectContainer.receiveZombieDamage(nPos, damage);
		}









	}