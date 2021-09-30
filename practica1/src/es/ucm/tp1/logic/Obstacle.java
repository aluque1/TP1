package es.ucm.tp1.logic;

public class Obstacle {
	//Attributes -----------------------
		private int posX;
		private int posY;
		private Game game;
		private static int numOfObstacles;
		
		
		//Constants ------------------------
		private final String SPRITE = "░";

		// Constructor ---------------------
		public Obstacle(int posX, int posY, Game game) {
			this.posX = posX;
			this.posY = posY;
			this.game = game;
			++numOfObstacles;
		}
		
		public String toString() {
			return SPRITE;
		}
}
