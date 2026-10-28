package logic;


public class Game implements GameStatus, GameWorld, GameModel {

	  public static final int INITIAL_COINS = 50;
	  private int sunCoins;
	  private boolean playerQuits;	  
	  private int cycles;
	  private boolean isGameFinished;
		
	  private GameObjectContainer ObjectContainer;
		
	  public Game(long seed, Level level) {
			// TODO Auto-generated constructor stub
			sunCoins = this.INITIAL_COINS;
			cycles = 0;
			this.ObjectContainer = new GameObjectContainer();
			this.isGameFinished = false;
			this.playerQuits = false;
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
}