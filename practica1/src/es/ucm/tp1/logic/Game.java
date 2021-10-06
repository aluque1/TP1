package es.ucm.tp1.logic;

import java.util.Random;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.view.GamePrinter;

public class Game {
	
	// Attributes --------------------------------------------------------
	Long seed;
	Random rand;
	
	// Enum --------------------------------------------------------------
	Level level;
	
	// Classes -----------------------------------------------------------
	GamePrinter printer;
	CoinList cl;
	ObstacleList ol;
	
	// Game initialising methods -----------------------------------------
	public Game(Long seed, Level level) {
		this.seed = seed;
		this.level = level;
		printer = new GamePrinter(this, level.getNumOfCols(), level.getNumOfRows());
	}

	// This method will be called when we call the reset command from Controller
	public void init(Long seed) {
		rand = new Random(seed);
	}
	
	private void coinPlacer() {
		// TODO We have to add all of the coins to the CoinList
	}
	
	private void obstaclePlacer() {
		// TODO We have to add all of the obstacles to the ObstacleList
	}
	
	public void toggleTest() {
		// TODO Auto-generated method stub
	}

	public Object getGameStatus() {
		// TODO We have to add the information of the game
		return "The info we still have to add";
	}

	// Game encoding methods --------------------------
	public String positionToString(int i, int j) {
		return " ";
	}
	
	public String ToString() {
		return printer.toString();
	}
	

}
