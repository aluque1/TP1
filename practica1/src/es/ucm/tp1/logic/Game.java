package es.ucm.tp1.logic;

import java.util.Random;
import es.ucm.tp1.control.Level;
import es.ucm.tp1.view.GamePrinter;

public class Game {
	
	// Attributes --------------------------------------------------------
	private Long seed;
	private Random rand;
	private int maxItems;
	private GamePrinter printer;
	private CoinList cl;
	private ObstacleList ol;
	private Player p;
	private Level level;
	
	private boolean test;
	private int cycles;
	private int distance;
	
	private double ellapsedTime;
	private double initialTime;
	private double prettyTime;
	
	
	// Game initializers methods -----------------------------------------
	public Game(Long seed, Level level) {
		this.seed = seed;
		this.level = level;
		this.maxItems = level.getLength() - (level.getVisibility()/2);
		printer = new GamePrinter(this, level.getNumOfCols(), level.getNumOfRows());
		init();
	}

	// This method will be called when we call the reset command from Controller
	public void init() {
		rand = new Random(this.seed);
		test = false;
		cycles = 0;
		distance = this.level.getLength();
		ellapsedTime = 0;
		ol = new ObstacleList(maxItems);
		obstaclePlacer();
		cl = new CoinList(maxItems);
		coinPlacer();
		p = new Player(this.level.getNumOfRows()/2, 0, this);
	}
	
	//From visibility/2 to the length, we look to check if we can place an obstacle
		// We place an obstacle if random generated is greater than the frequency of the placement for said level
		private void obstaclePlacer() {
			int initialPoint = level.getVisibility()/2;
			for(int i = initialPoint; i < level.getLength() - 1; i++) {
				int auxRow = rand.nextInt(level.getWidth());
				if(rand.nextDouble() < level.getObstacleFrequency()) {
					Obstacle obs = new Obstacle(auxRow, i, this);
					ol.add(obs);
				}
			}
		}
	
	//From visibility/2 to the length, we look to check if we can place a coin
	// We place a coin if random generated is greater than the frequency of the placement for said level
	// and there isn't an obstacle in this position.
	private void coinPlacer() {
		int initialPoint = level.getVisibility()/2;
		for(int i = initialPoint; i < level.getLength() - 1; i++) {
			int auxRow = rand.nextInt(level.getWidth());
			if(rand.nextDouble() < level.getCoinFrequency()) {
				if(!isPosObstacle(auxRow, i)) {
					Coin coin = new Coin(auxRow, i, this);
					cl.add(coin);
				}
			}
		}
	}
	
	public void toggleTest() {
		test = !test;
	}

	public String getGameStatus() {
		StringBuilder str = new StringBuilder();
		str.append("Distance: " + distance + '\n');
		str.append("Coins: " + p.getCoinsCollected() + '\n');
		str.append("Cycles: " + cycles + '\n');
		str.append("Total obstacles: " + Obstacle.numOfObstacles + '\n');
		str.append("Total coins: " + Coin.numOfCoins + '\n');
		prettyTime = Math.round((ellapsedTime/1000) * 100.0) / 100.0;
		if(!test)
			str.append("Ellapsed Time: " + prettyTime + '\n');
		return str.toString();
	}
	
	private boolean isPosPlayer(int row, int col) {
		return p.isPosPlayer(row, col);
	}
	
	public boolean isPosObstacle(int row, int col) {
		return ol.isPosObstacle(row, col);
	}
	
	public boolean isPosCoin(int row, int col) {
		return cl.isPosCoin(row, col);
	}
	
	public int visibility() {
		return level.getVisibility();
	}
	
	public boolean isWithinBounds(int row) {
		return (row < (level.getWidth()) && row >= 0);
	}
	
	
	// Checks whether the player has collided with an obstacle or needs to pick up a coin
	public boolean checkCollision() {
		boolean collision = false;
		int row = 0;
		while(!collision && row < level.getNumOfRows()) {
			if(isPosPlayer(row, cycles) && isPosObstacle(row, cycles)) {
				p.collide();
				collision = true;
			}
			else if(isPosPlayer(row, cycles) && isPosCoin(row, cycles)) {
				p.pickUpCoin();
				cl.pickCoinInPos(row, cycles);
			}
			row++;
		}
		return collision;
	}
	
	// Game encoding methods --------------------------
	public String positionToString(int i, int j) {
		String cell = " ";
		if (isPosPlayer(i, (j + cycles)))
			cell = p.toString();
		else if(isPosObstacle(i, (j + cycles)))
			cell = Obstacle.getString();
		else if(isPosCoin(i, (j + cycles)))
			cell = Coin.getString();
		else if (j + cycles == level.getLength() - 1)
			cell = "¦";
		return cell;
	}

	public String ToString() {
		return printer.toString();
	}

	// Game state methods -------------------------------
	public boolean isAtEnd() {
		if(p.isAtEnd(level.getLength()))
			return true;
		else
			return false;
	}
	
	
	// Game altering methods ----------------------------
	
	public boolean moveUp() {
		return p.moveUp();
	}
	
	public boolean moveDown() {
		return p.moveDown();
	}
	
	public boolean update() {
		cycles++;
		if(cycles == 0) 
			ellapsedTime = 0;
		else if(cycles == 1)
			initialTime = System.currentTimeMillis();
		else
			ellapsedTime = System.currentTimeMillis() - initialTime;
		distance--; 
		p.update();
		return hasEnded();
	}
	
	
	
	public boolean hasEnded() {
		boolean hasEnded = false;
		if(checkCollision()) {
			System.out.println(this.ToString());
			System.out.println("[GAME OVER] Player crashed!");
			hasEnded = true;
		}
		else if(isAtEnd()) {
			System.out.println(this.ToString());
			System.out.println("[GAME OVER] Player wins!");
			if(!test)
				System.out.println("New record!: " + prettyTime + " s");
			hasEnded = true;
		}
		
		return hasEnded;
	}
	

}