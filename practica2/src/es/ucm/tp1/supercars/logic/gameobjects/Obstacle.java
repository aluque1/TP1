package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Obstacle extends GameObject{
	
	public static final String INFO = "[Obstacle] hits car";
	private static int numOfObstacles = 0;
	
	public Obstacle(Game game, int x, int randomLane){
		super(game, x, randomLane);
		numOfObstacles++;
	}

	@Override
	public boolean receiveCollision(Player player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean doCollision() {
		// TODO Auto-generated method stub
		return false;
	}

	public static int getObstaclesCount() {
		return numOfObstacles;
	}

}
