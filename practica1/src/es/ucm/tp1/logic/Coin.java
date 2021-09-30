package es.ucm.tp1.logic;

public class Coin {
	
	//Attributes -----------------------
	private int posX;
	private int posY;
	private Game game;
	private static int numOfCoins;
	
	
	//Constants ------------------------
	private final String SPRITE = "¢";

	// Constructor ---------------------
	public Coin(int posX, int posY, Game game) {
		this.posX = posX;
		this.posY = posY;
		this.game = game;
		++numOfCoins;
	}
	
	
	public String toString() {
		return SPRITE;
	}
}
