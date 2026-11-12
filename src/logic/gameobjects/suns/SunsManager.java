package logic.gameobjects.suns;

import java.util.Random;

import control.Level;
import logic.GameWorld;
import logic.Position;
import logic.gameobjects.zombies.Zombie;

public class SunsManager {
	private GameWorld game;

	private Level level;

	private Random rand;

	private int remainingZombies;
	private int totalZombies;
	private int deadZombies;

	private int sunFrequency;
	private int timer;

	

	public SunsManager(GameWorld game, Level level, Random rand) {
		this.game = game;
		this.level = level;
		this.rand = rand;
		this.remainingZombies = level.getNumberOfZombies();
		this.totalZombies = this.remainingZombies;
		this.deadZombies = 0;
		this.sunFrequency = 5;
		this.timer = this.sunFrequency-1;
		
	}
	
	public void update() {
		// TODO Auto-generated method stub
		if(this.timer == 0) {
			this.addSun();
			this.timer = this.sunFrequency-1;
		}else {
			this.timer--;
		}
		
	}

	/**
	 * Checks if the game should add (if possible) a zombie to the game.
	 * 
	 * @return <code>true</code> if a zombie should be added to the game.
	 */
	
	/**
	 * Return a random row within the board limits.
	 * 
	 * @return a random row.
	 */
	private int randomSunRow() {
		return rand.nextInt(game.NUM_ROWS);
	}
	
	private int randomSunCol() {
		return rand.nextInt(game.NUM_COLS);
	}
	
	public boolean addSun() {
		
		Position np = null;
		while(np == null ||!np.inBoard() ) {
			
			int row = randomSunRow();
			int col = randomSunCol();
			np = new Position(row,col);
		}
		
		return addSun(np);
	}

	public boolean addSun(Position np) {
		
		this.game.addSun(new Sun(game,np));
		return true;
	}


	/**
	 * Checks if the game should add (if possible) a zombie to the game.
	 * 
	 * @return <code>true</code> if a zombie should be added to the game.
	 */
	
	
	/**
	 * Return a random row within the board limits.
	 * 
	 * @return a random row.
	 */
	
}
