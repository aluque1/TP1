package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Obstacle extends GameObject{
	
	public static final String INFO = "[Obstacle] hits car";
	protected static int numOfObstacles = 0;
	private static final String SPRITE = "░";
	private static final int HP = 1;
	
	public Obstacle(Game game, int x, int randomLane){
		super(game, x, randomLane);
		this.hp = HP;
		symbol = SPRITE;
	}

	@Override
	public boolean receiveCollision(Player player) {
		player.decreaseHP();
		return true;
	}
	
	@Override
	public boolean receiveShot() {
		this.hp--;
		return true;
	}
	
	@Override
	public boolean recieveThunder() {
		this.hp = 0;
		return true;
	}	
	
	@Override
	public void instaKill() {
		hp = 0;
	}
	
	@Override
	public void onEnter() {
		numOfObstacles++;
	}

	@Override
	public void update() {
		// Doesn't do anything
		
	}
	
	@Override
	public void onDelete() {
		numOfObstacles--;
	}

	public static int getObstaclesCount() {
		return numOfObstacles;
	}
	

	
}
