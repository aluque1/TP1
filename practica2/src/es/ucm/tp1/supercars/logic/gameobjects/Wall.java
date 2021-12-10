package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Wall extends Obstacle{
	
	private static final int HP = 3;
	private static final int VALUE = 5;
	public static final String INFO = "[WALL] hard obstacle";

	public Wall(Game game, int x, int randomLane) {
		super(game, x, randomLane);
		this.hp = HP;
	}

	@Override
	public void onDelete() {
		numOfObstacles--;
		game.givePlayerCoins(VALUE);
	}
	
	@Override
	public boolean receiveShot() {
		this.hp--;
		return true;
	}
	
	@Override
	public boolean receiveWave() {
		x++;
		return true;
	}
	
	@Override
	public String toString() {
		String sprite = null;
		switch (hp) {
		case 3:
			sprite = "█";
			break;
		case 2:
			sprite = "▒";
			break;
		case 1:
			sprite = "░";
		}
		return sprite;
	}
	
	@Override
	public String toSerialize() {
		StringBuilder str = new StringBuilder();
		str.append(super.toSerialize());
		str.append(" ").append(this.hp);
		
		return str.toString();
	}
}
