package es.ucm.tp1.logic;

import java.util.Random;
import es.ucm.tp1.control.Level;
import es.ucm.tp1.view.GamePrinter;


/**
 * @author aluqu
 *	 TODO:: 
 *		-PLAYER:
 *			(I think the movement should return a boolean, to display a message that tell you why you couldn't move
 *			 ie. the car is at the top of the road and the player tries to move up, it should display a message telling
 *			 the player why that movement can't be performed)
 *			· moveUp() -- Just needs to be implemented 
 *			· moveDown() -- Just needs to be implemented 
 *			· moveForward() 
 *			· Obstacle Collision -- not to sure if we do this in the player, or in the game.
 *			· Coin Collision
 *		-CONTROLLER
 *			x Finish all of the commands, can only be done once all the player methods are done
 *				(Only the test is left to be done.)
 *	
 *		-GAMEPRINTER
 *			· Print the board properly, once the player moves, we need to make the road fall behind by one
 *		-GAME 
 *			· Implement the appropriate calling methods to be able to implement the commands and the player movement
 *			· Add the game info to print
 */


public class Game {
	
	// Attributes --------------------------------------------------------
	private Long seed;
	private Random rand;
	private int maxItems;
	
	// Enum --------------------------------------------------------------
	private Level level;
	
	// Classes -----------------------------------------------------------
	private GamePrinter printer;
	private CoinList cl;
	private ObstacleList ol;
	private Player p;
	
	// Game initializers methods -----------------------------------------
	public Game(Long seed, Level level) {
		this.seed = seed;
		this.level = level;
		this.maxItems = level.getLength() - (level.getVisibility()/2);
		printer = new GamePrinter(this, level.getNumOfCols(), level.getNumOfRows());
		init(level);
	}

	// This method will be called when we call the reset command from Controller
	public void init(Level level) {
		rand = new Random(this.seed);
		ol = new ObstacleList(maxItems);
		obstaclePlacer();
		cl = new CoinList(maxItems);
		coinPlacer();
		p = new Player(level.getNumOfRows()/2, 0, this);
	}
	
	//From visibility/2 to the length, we look to check if we can place a coin
	// We place a coin if random generated is greater than the frequency of the placement for said level
	// and there isn't an obstacle in this position.
	private void coinPlacer() {
		int initialPoint = level.getVisibility()/2;
		
		for(int i = initialPoint; i < level.getLength(); i++) {
			if(level.getCoinFrequency() > rand.nextDouble()) {
				int auxRow = rand.nextInt(level.getWidth());
				if(!isPosObstacle(auxRow, i)) {
					Coin coin = new Coin(auxRow, i, this);
					cl.add(coin);
				}
			}
		}
	}
	
	//From visibility/2 to the length, we look to check if we can place an obstacle
	// We place an obstacle if random generated is greater than the frequency of the placement for said level
	private void obstaclePlacer() {
		int initialPoint = level.getVisibility()/2;
		for(int i = initialPoint; i < level.getLength(); i++) {
			if(level.getObstacleFrequency() < rand.nextDouble()) {
				Obstacle obs = new Obstacle(rand.nextInt(level.getWidth()), i, this);
				ol.add(obs);
			}
		}
	}
	
	public void toggleTest() {
		// TODO Auto-generated method stub
	}

	public Object getGameStatus() {
		// TODO We have to add the information of the game
		return "The info we still have to add";
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
	
	// Game encoding methods --------------------------
	public String positionToString(int i, int j) {
		String cell = " ";
		if (isPosPlayer(i, j))
			cell = p.toString();
		else if(isPosObstacle(i, j))
			cell = Obstacle.getString();
		else if(isPosCoin(i, j))
			cell = Coin.getString();
		return cell;
	}

	public String ToString() {
		return printer.toString();
	}

	
	// Game altering methods ----------------------------
	
	public boolean moveUp() {
		return p.moveUp();
	}
	
	public boolean moveDown() {
		return p.moveDown();
	}
	
	public void update() {
		/**
		 * TODO:: 
		 *  In the update we make the player move forward, always. If the user command is UP or DOWN
		 *  we also need to make the players position change accordingly. 
		 */
		p.update();
	}
	

}
