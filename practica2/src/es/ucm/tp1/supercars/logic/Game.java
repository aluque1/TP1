package es.ucm.tp1.supercars.logic;

import es.ucm.tp1.supercars.logic.gameobjects.GameObjectContainer;
import es.ucm.tp1.supercars.logic.gameobjects.Player;
import es.ucm.tp1.supercars.logic.instantAction.InstantAction;
import es.ucm.tp1.supercars.view.GamePrinter;

import java.util.Random;

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.control.exceptions.InputOutputRecordException;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

/** TODO List
 * 
 * En todos los comandos lanzamos un try catch(); 
 * Hacer todos los throws desde el game. (Como is fuera un execute)
 * throw en los try catch salvo el def controller
 */
public class Game{

	// Constants ----------------------------------------------
	private static final String FINISH_LINE = "¦";
	
	Player player;
	Record record;
	GameObjectContainer container;
	Level level;
	boolean test;
	boolean playerExit;
	boolean newRecord;
	Long seed;
	Random rand;
	GamePrinter printer;
	
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
		if(level.name().equalsIgnoreCase("test"))
			test = true;
		else 
			test = false;
		rand = new Random(this.seed);
		container = new GameObjectContainer(this);
		record = new Record(this);
		GameObjectGenerator.reset();
		GameObjectGenerator.generateGameObjects(this, level);
		player = new Player(this, 0, getRoadWidth()/2);
		// initialization of description attributes
		distance = getRoadLength();
		cycle = 0;
		elapsedTime = 0;
	}
	
	public void execute(InstantAction action) {
		action.execute(this);
	}
	
	// Game state methods ------------------------------------------------------------
	public boolean isFinished() {
		return playerExit || hasArrived() || !player.isAlive();
	}

	public boolean isWithinBounds(int row) {
		return (row < getRoadWidth() && row >= 0);
	}
	
	public boolean isAtTopOfRoad(int row) {
		return row == 0;
	}
	
	public boolean isAtBottomOfRoad(int row) {
		return row < getRoadWidth();
	}
	
	
	public boolean isWithinVisibility(int col, int row) {
		return (row < getRoadWidth() && row >= 0) && (col >= 0 && col <= (getVisibility() - 1));
	}
	
	// Command calling methods -----------------------------------------------------------------
	
	public void update(boolean hasMovedSideways) {
		
		GameObjectGenerator.generateRuntimeObjects(this);
		
		if(!hasMovedSideways)
			checkCollision();
		
		if (player.isAlive()) {
			player.update();
			container.update();
		}
		
		removeDeadObjects();
		cycle++;
		distance = getRoadLength() - getPlayerX();
		if(cycle == 1)
			initialTime = System.currentTimeMillis();
		else
			elapsedTime = System.currentTimeMillis() - initialTime;
	}
	
	public void reset(String[] params) {
		if(params.length == 1)
			init(seed, level);
		else
			init(Long.parseLong(params[1]), Level.valueOfIgnoreCase(params[0]));
		
		printer.init();
	}

	public void spendCoins(int price) {
		player.spendCoins(price);
	}
	
	public boolean placeGrenade(int x, int y) {
		boolean placed = true;
		if(container.isPosEmpty(x, y))
			GameObjectGenerator.placeGrenade(this, x + getPlayerX(), y);
		else
			placed = false;
		return placed;
	}
	
	// Record checking methods -----------------------------------------------------
	public void updateRecord() throws InputOutputRecordException {
		record.updateRecord(this);
		
	}
	
	public boolean isNewRecord() {
		if(elapsedTime < record.getRecord(this)) {
			record.changeRecord(this);
			newRecord = true;
		}
		return newRecord;
	}

	public long getRecord() {
		return record.getRecord(this);
	}
	
	
	// Game object creation and deletion --------------------------------------------
	public void clearContainer() {
		container.clearContainer();
	}

	public void tryToAddObject(GameObject go, double frequency) {
			if(rand.nextDouble() < frequency) {
				container.addObject(go);
			}
	}
	
	public void forceAddObject(GameObject o) {
		container.addObject(o);
	}
	
	public void removeDeadObjects() {
		container.removeDead();
	}

	// Player interaction methods -----------------------------------------

	public void moveUp() {
		player.moveUp();
	}

	public void moveDown() {
		player.moveDown();
	}
	
	public boolean checkCollision() {
		return player.doCollision();
	}
	
	public void givePlayerCoins(int coins) {
		player.giveCoins(coins);
	}
	
	public void playerLoseCoins() {
		player.loseCoins();
	}
	
	// GamePrinter methods ------------------------------------------------
	public String positionToString(int x, int y) {
		StringBuilder str = new StringBuilder();
		if(player.isInPosition(x + getPlayerX(), y))
			str.append(player.toString());
		else if(x + getPlayerX() == level.getLength() - 1)
			str.append(FINISH_LINE);
		str.append(" ").append(getStringAtPos(x + getPlayerX(), y));
		return str.toString();
	}
	
	public String getStringAtPos(int x, int y) {
		return container.getStringAtPos(x, y);
	}
	
	public void recievePrinter(GamePrinter printer) {
		this.printer = printer;
	}
	// GameSeralizer methods ----------------------------------------------
	
	public String toSerialize() {
		StringBuilder str = new StringBuilder();
		str.append(player.toSerialize()).append('\n');
		str.append(container.toSerialize());
		return str.toString();
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

	public Collider getObjectInPosition(int x, int y) {
		return container.getObjectInPosition(x, y);
	}	
	
	public int getPlayerX() {
		return player.getX();
	}
	
	public int getPlayerY() {
		return player.getY();
	}
	
	public int getPlayerCoins() {
		return player.getCoinsCollected();
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
	
	public int getRandomLane() {
		return rand.nextInt(this.getRoadWidth());
	}
	
	public int getRandomColumn() {
		return rand.nextInt(this.getVisibility());
	}

	
}
