package es.ucm.tp1.logic;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.view.GamePrinter;

public class Game {
	
	// Attributes --------------------------------------------------------
	Long seed;
	
	// Enum --------------------------------------------------------------
	Level level;
	
	// Classes -----------------------------------------------------------
	GamePrinter printer1;
	
	
	public Game(Long seed, Level level) {
		this.seed = seed;
		this.level = level;
		printer1 = new GamePrinter(this, level.getNumOfCols(), level.getNumOfRows());
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
		return printer1.toString();
	}
	

}
