package es.ucm.tp1.supercars.logic;



/** TODO :: Things we still have to do
 * 		·ResetCommand is still not done.
 * 		·Create Game Constructor.
 */

import es.ucm.tp1.supercars.logic.gameobjects.GameObjectContainer;
import es.ucm.tp1.supercars.logic.gameobjects.Player;
import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public class Game {

	Player player;
	GameObjectContainer container;
	boolean test;
	boolean playerExit;
	boolean newRecord;
	Long elapsedTime;
	int cycle;
	
	public Game(Long seed, Level level) {
		
	}
	
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getVisibility() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getRoadLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getRoadWidth() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	// Command calling methods -------------------------------------------
	
	public void update() {
		container.update();
		player.update();
	}

	// Game object generation --------------------------------------------
	public int getRandomLane() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void tryToAddObject(GameObject go, double obstacleFrequency) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
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
