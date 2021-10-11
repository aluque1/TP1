package es.ucm.tp1.logic;

public class Obstacle {
	//Attributes -----------------------
		private int row;
		private int col;
		private Game game;
		static int numOfObstacles = 0;
		
		
		//Constants ------------------------
		private final static String SPRITE = "░";

		// Constructor ---------------------
		public Obstacle(int row, int col, Game game) {
			this.row = row;
			this.col = col;
			this.game = game;
			numOfObstacles++;
		}
		
		public static String getString() {
			return SPRITE;
		}

		public static int getNumOfObstacles() {
			return numOfObstacles;
		}

		public boolean isInPosition(int row, int col) {
			return ((this.row == row) && (this.col == col));
		}
}
