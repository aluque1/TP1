package es.ucm.tp1.logic;

public class Coin {
	
	//Attributes -----------------------
	private int row;
	private int col;
	private Game game;
	private static int numOfCoins = 0;
	
	
	//Constants ------------------------
	private final static String SPRITE = "¢";

	// Constructor ---------------------
	public Coin(int row, int col, Game game) {
		this.row = row;
		this.col = col;
		this.game = game;
		numOfCoins++;
	}
	

	public static String getString() {
		return SPRITE;
	}


	public boolean isInPosition(int row, int col) {
		return ((this.row == row) && (this.col == col));
	}


	public static int getNumOfCoins() {
		return numOfCoins;
	}
}
