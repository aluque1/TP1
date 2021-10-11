package es.ucm.tp1.logic;

public class Player {

	//Attributes -----------------------
		private int col;
		private int row;
		private Game game;
		private int numOfCoins;
		private boolean alive;
		
		//Constants ------------------------
		private final String ALIVE_SPRITE = ">";
		private final String DEAD_SPRITE = "@";

		// Constructor ---------------------
		public Player(int row, int col, Game game) {
			this.col = col;
			this.row = row;
			this.game = game;
			this.numOfCoins = 0;
			this.alive = true;
			
		}
		
		public void update() {
			// TODO 
		}
		
		public boolean isPosPlayer(int row, int col) {
			return (row == this.row && col == this.col);
		}
		
		public String toString() {
			if(alive)
				return ALIVE_SPRITE;
			else
				return DEAD_SPRITE;
		}

}