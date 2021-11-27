package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Wall extends Obstacle{
	
	private static final int HP = 3;

	public Wall(Game game, int x, int randomLane) {
		super(game, x, randomLane);
	}

	@Override
	public void onDelete() {
		numOfObstacles--;
		// TODO, once the wall dies we need to give 5 coins to the player
	}
	
	@Override
	public String toString() {
		String sprite = null;
		switch (hp) {
		case 2:
			sprite = "▒";
			break;
		case 1:
			sprite = "░";
		default:
			sprite = "█";
			break;
		}
		return sprite;
	}
}
