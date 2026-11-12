package logic.gameobjects.zombies;







import java.util.Random;

import control.Level;
import logic.Game;
import logic.GameModel;
import logic.GameWorld;
import logic.Position;
import logic.gameobjects.GameObject;

/**
 * Manages the full lifecycle of zombies for a game session.
 *
 * <p>Responsibilities: deciding each cycle whether to spawn a new zombie
 * (probabilistically, subject to the remaining quota from {@link Level}),
 * delegating per-cycle updates and dead-removal to the underlying
 * {@link ZombieList}, and answering win/loss queries
 *
 */
public class ZombieManager {

	private GameWorld game;

	private Level level;

	private Random rand;

	private int remainingZombies;
	private int totalZombies;
	private int deadZombies;

	public ZombieManager(GameWorld game, Level level, Random rand) {
		this.game = game;
		this.level = level;
		this.rand = rand;
		this.remainingZombies = level.getNumberOfZombies();
		this.totalZombies = this.remainingZombies;
		this.deadZombies = 0;
	}

	/**
	 * Checks if the game should add (if possible) a zombie to the game.
	 * 
	 * @return <code>true</code> if a zombie should be added to the game.
	 */
	private boolean shouldAddZombie() {
		return rand.nextDouble() < level.getZombieFrequency();
	}
	
	/**
	 * Return a random row within the board limits.
	 * 
	 * @return a random row.
	 */
	private int randomZombieRow() {
		return rand.nextInt(game.NUM_ROWS);
	}
	
	public boolean addZombie() {
		if(this.remainingZombies > 0) {
			
			int row = randomZombieRow();
			
			return addZombie(row);
		}else return false;
	}

	public boolean addZombie(int row) {
		boolean canAdd = getRemainingZombies() > 0 && shouldAddZombie()
				&& isPositionEmpty(game.NUM_COLS, row);

		if(canAdd) {
			// TODO fill your code
			this.remainingZombies--;
			Position p = new Position( row,game.NUM_COLS-1);
			this.game.addZombie(this.spawnRandomTypeZombie(p));
		}
		return canAdd;
	}

	
	
	
	


	private GameObject spawnRandomTypeZombie(Position p) {
		// TODO Auto-generated method stub
		int r = rand.nextInt(100);
		
		if( 0 <= r && r<= 54) {
			return(new Zombie(this.game,p));
		}else if ( 55 <= r && r < 70){
			return(new BucketHeadZombie(this.game,p));
		}else if ( 70<= r && r < 85){
			return(new SportyZombie(this.game,p));
		}else {
			return new ExplosiveZombie(this.game,p);
		}
		
	}

	private boolean isPositionEmpty(int numCols, int row) {
		// TODO Auto-generated method stub
		Position np = new Position(row, numCols-1);
		return game.isEmpty(np);
	}

	// por hacer------------------------------------
	public int getRemainingZombies() {
		// TODO Auto-generated method stub
		return this.remainingZombies;
	}

	
	// TODO fill your code
	public boolean zombiesRemain() {
		return (this.remainingZombies > 0);
	}



	public void finishGame(boolean b, GameModel game) {
		// TODO Auto-generated method stub
		game.finishGame(b);
	}

	public void update() {
		// TODO Auto-generated method stub
		if(this.allZombiesDead())game.pWins();
		this.addZombie();
		
	}
	public void zombieDied() {
	    deadZombies++;
	}
	
	public boolean allZombiesDead() {
	    return deadZombies >= totalZombies;
	}

	public String list() {
		// TODO Auto-generated method stub
		return null;
	}
}