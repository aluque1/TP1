package es.ucm.tp1.supercars.logic;



/** TODO :: Things we still have to do
 * 		·ResetCommand is still not done.
 * 		·Create Game Constructor.
 * 		¿Es necesario que todos los metodos get de game sean publicos?
 */

import es.ucm.tp1.supercars.logic.gameobjects.GameObjectContainer;
import es.ucm.tp1.supercars.logic.gameobjects.Player;

import java.util.Random;

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public class Game {

	Player player;
	GameObjectContainer container;
	Level level;
	boolean test;
	boolean playerExit;
	boolean newRecord;
	long elapsedTime;
	int cycle;
	Long seed;
	Random rand;
	
	
	
	public Game(Long seed, Level level) {
		this.seed = seed;
		this.level = level;
	}
	
	public void init() {
		rand = new Random(this.seed);
	}
	
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
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
	
	// Command calling methods -------------------------------------------
	
	public void update() {
		container.update();
		player.update();
	}

	// Game object generation --------------------------------------------
	public int getRandomLane() {
		return rand.nextInt(this.getRoadLength());
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
	// Getters and Setters ------------------------------------------------
	// GamePrinter methods ------------------------------------------------
	public String positionToString(int x, int y) {
		return container.getStringAtPos(x, y);
	}
	
	public int distanceToGoal() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int playerCoins() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getCycle() {
		return cycle;
	}

	public Level getLevel() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO IF THE PLAYER HAS REACHED THE END LINE
		return false;
	}

	public boolean isNewRecord() {
		return newRecord;
	}

	public long getRecord() {
		// TODO will be the new record, in this case its the elapsed time
		return elapsedTime;
	}
	
	
}
