package es.ucm.tp1.logic;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.view.GamePrinter;

public class Game {
	
	// Atriutes ----------------------------------------------------------
	Long seed;
	
	// Enum --------------------------------------------------------------
	Level level;
	
	// Classes -----------------------------------------------------------
	GamePrinter printer1;
	
	
	public Game(Long seed, Level level) {
		this.seed = seed;
		this.level = level;
	}

	public void toggleTest() {
		// TODO Auto-generated method stub
	}

	public Object getGameStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	// Game encoding methods --------------------------
	public String positionToString(int i, int j) {
		// TODO encode the game when
		return null;
	}

}
