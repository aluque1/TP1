package es.ucm.tp1.logic;

public class Player {

	//Attributes -----------------------
		private int col;
		private int row;
		private Game game;
		public static int coinsCollected;
		private boolean alive;
		
		//Constants ------------------------
		private final String ALIVE_SPRITE = ">";
		private final String DEAD_SPRITE = "@";

		// Constructor ---------------------
		public Player(int row, int col, Game game) {
			this.col = col;
			this.row = row;
			this.game = game;
			Player.coinsCollected = 0;
			this.alive = true;
			
		}
		
		public void update() {
			col++;
		}
		
		// Check if the player can move up, if it can then we need to return true and move the player one position up.
		public boolean moveUp() {
			int futurePos = row - 1;
			boolean valid = false;
			if(game.isWithinBounds(futurePos)) {
				row--;
				valid = true;
			}
			return valid;
		}
		
		// Check if the player can move down, if it can then we need to return true and move the player one position down.
		public boolean moveDown() {
			int futurePos = row + 1;
			boolean valid = false;
			if(game.isWithinBounds(futurePos)) {
				row++;
				valid = true;
			}
			return valid;
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

		public boolean isAtEnd(int end) {
			return col == end;
		}
		
		// Collides with obstacle and set alive to false;
		public void collide() {
			alive = false;
		}
		
		// Passes over coin and collects it
		public void pickUpCoin() {
			coinsCollected++;
		}
		
		

}