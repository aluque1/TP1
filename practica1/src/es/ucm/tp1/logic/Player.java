package es.ucm.tp1.logic;

public class Player {

	//Attributes -----------------------
		private int posX;
		private int posY;
		private Game game;
		private int numOfCoins;
		private boolean alive;
		
		//Constants ------------------------
		private final String ALIVE_SPRITE = ">";
		private final String DEAD_SPRITE = "@";

		// Constructor ---------------------
		public Player(int posX, int posY, Game game) {
			this.posX = posX;
			this.posY = posY;
			this.game = game;
			this.numOfCoins = 0;
			this.alive = true;
			
		}
		
		public void update() {
			// TODO 
		}
		
		public String toString() {
			if(alive)
				return ALIVE_SPRITE;
			else
				return DEAD_SPRITE;
		}
}
