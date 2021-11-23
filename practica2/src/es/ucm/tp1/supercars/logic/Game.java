package es.ucm.tp1.supercars.logic;



/** TODO :: Things we still have to do
 * 		· Grenade object and command is still to be done
 */

import es.ucm.tp1.supercars.logic.gameobjects.GameObjectContainer;
import es.ucm.tp1.supercars.logic.gameobjects.Player;

import java.util.Random;

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public class Game {

	// Constants ----------------------------------------------
	private static final int WAVE_PRICE = 5;
	
	
	Player player;
	GameObjectContainer container;
	Level level;
	boolean test;
	boolean playerExit;
	boolean newRecord;
	Long seed;
	Random rand;
	
	// Attributes that describe the game ---------------------------
	long elapsedTime; 
	long initialTime; 
	int cycle;
	int distance;
	
	
	public Game(Long seed, Level level) {
		init(seed, level);
	}
	
	public void init(Long seed, Level level) {
		this.seed = seed;
		this.level = level;
		rand = new Random(this.seed);
		container = new GameObjectContainer(this);
		GameObjectGenerator.generateGameObjects(this, level);
		player = new Player(this, 0, getRoadWidth()/2);
		// initialisation of description attributes
		distance = getRoadLength();
		cycle = 0;
		elapsedTime = 0;
		initialTime = System.currentTimeMillis();
		
	}
	
	
	
	public boolean isFinished() {
		return playerExit || hasArrived() || !player.isAlive();
	}

	public int getVisibility() {
		return level.getVisibility();
	}

	public int getRoadLength() {
		return level.getLength();
	}

	public int getRoadWidth() {
		return level.getWidth();
	}
	
	public boolean isWithinBounds(int row) {
		return (row < getRoadWidth() && row >= 0);
	}
	// Command calling methods -----------------------------------------------------------------
	
	public void update() {
		container.update();
		player.update();
		container.removeDead();
		cycle++;
		distance--;
		
		elapsedTime = System.currentTimeMillis() - initialTime;
	}
	
	public void clearContainer() {
		container.clearContainer();
	}

	public void reset(String[] params) {
		if(params.length == 0)
			init(seed, level);
		else
			init(Long.parseLong(params[0]), Level.valueOfIgnoreCase(params[1]));
	}
	
	public boolean doWaveAttack() {
		boolean couldPerform = false;
		if(player.getCoinsCollected() > WAVE_PRICE) {
			couldPerform = true;
			container.recieveWave();
		} 
		else
			System.out.println("Not enough coins to perform this action,");
		
		return couldPerform;
	}
	
	// Game object generation --------------------------------------------
	public int getRandomLane() {
		return rand.nextInt(this.getRoadWidth());
	}

	public void tryToAddObject(GameObject go, double frequency) {
			if(rand.nextDouble() < frequency) {
				container.addObject(go);
			}
	}
			
	
	// Player interaction methods -----------------------------------------

	public boolean moveUp() {
		return player.moveUp();
	}

	public boolean moveDown() {
		return player.moveDown();
	}
	
	// GamePrinter methods ------------------------------------------------
	public String positionToString(int x, int y) {
		
		if(player.isInPosition(x + player.getX(), y))
			return player.toString();
		else if(x + player.getX() == level.getLength() - 1)
			return "¦";
		else
			return container.getStringAtPos(x + player.getX(), y);
	}
	
	// Getters and setters ------------------------------------------------
	
	public int distanceToGoal() {
		return distance;
	}

	public int playerCoins() {
		return player.getCoinsCollected();
	}

	public int getCycle() {
		return cycle;
	}

	public Level getLevel() {
		return this.level;
	}

	public boolean isTestMode() {
		return test;
	}

	public long elapsedTime() {
		return elapsedTime;
	}

	public void toggleTest() {
		test = !test;
	}
	
	public void playerExitGame() {
		playerExit = true;
	}
	
	public boolean isUserExit() {
		return playerExit;
	}

	public boolean hasArrived() {
		return distance <= 0;
	}

	public boolean isNewRecord() {
		return newRecord;
	}

	public long getRecord() {
		// TODO will be the new record, in this case its the elapsed time
		return elapsedTime;
	}

	public Collider getObjectInPosition(int x, int y) {
		return container.getObjectInPosition(x, y);
	}	
	
	public int getPlayerX() {
		return player.getX();
	}
}
