package es.ucm.tp1.supercars.logic;

import es.ucm.tp1.supercars.logic.gameobjects.GameObjectContainer;
import es.ucm.tp1.supercars.logic.gameobjects.Player;
import es.ucm.tp1.supercars.logic.instantAction.InstantAction;

import java.util.Random;
import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public class Game{

	// Constants ----------------------------------------------
	private static final String FINISH_LINE = "¦";
	
	
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
	
	public boolean isWithinVisibility(int col, int row) {
		return (row < getRoadWidth() && row >= 0) && (col >= getPlayerX() && col <= (getPlayerX() + getVisibility() - 1));
	}
	
	public boolean isAtTopOfRoad(int row) {
		return row == 0;
	}
	
	public boolean isAtBottomOfRoad(int row) {
		return row < getRoadWidth();
	}
	
	// Command calling methods -----------------------------------------------------------------
	
	public void update() {
		GameObjectGenerator.generateRuntimeObjects(this);
		container.update();
		player.update();
		checkCollision();
		container.removeDead();
		cycle++;
		distance = getRoadLength() - getPlayerX();
		if(cycle == 1)
			initialTime = System.currentTimeMillis();
		else
			elapsedTime = System.currentTimeMillis() - initialTime;
	}
	
	public void reset(String[] params) {
		if(params.length == 0)
			init(seed, level);
		else
			init(Long.parseLong(params[0]), Level.valueOfIgnoreCase(params[1]));
	}

	public void spendCoins(int price) {
		player.spendCoins(price);
	}
	
	public void recieveWave() {
		container.recieveWave();
	}

	public void recieveShot() {
		container.recieveShot(getPlayerY());
	}
	
	public void explode(int x, int y) {
		container.explode(x, y);	
	}
	
	public void recieveThunder() {
		StringBuilder str = new StringBuilder();
		String sprite = "";
		int col = getRandomColumn() + getPlayerX();
		int row = getRandomLane();
		str.append("Thunder hit position: (").append(col - getPlayerX()).append(", ").append(row).append(")");
		sprite = container.getStringAtPos(col, row);
		if(container.recieveThunder(col, row))
			str.append(" -> ").append(sprite).append("hit");
		System.out.println(str.toString());
	}
	
	public void placeGrenade(int x, int y) {
		GameObjectGenerator.placeGrenade(this, x + getPlayerX(), y);
		update();
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
	
	public void clearLastVisibleColumn() {
		container.clearLastVisibleColumn();
	}
	// Player interaction methods -----------------------------------------

	public boolean moveUp() {
		return player.moveUp();
	}

	public boolean moveDown() {
		return player.moveDown();
	}
	
	public void moveForward() {
		player.moveForward();
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
		str.append(" ").append(container.getStringAtPos(x + getPlayerX(), y));
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

	public boolean isNewRecord() {
		return newRecord;
	}

	public long getRecord() {
		return elapsedTime;
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
