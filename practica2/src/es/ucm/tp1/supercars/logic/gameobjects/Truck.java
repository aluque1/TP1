package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Truck extends Obstacle{

	public static final String INFO = "[TRUCK] moves towards the player";
	private static final String SPRITE = "←";
	private static final int HP = 1;
	
	public Truck(Game game, int x, int randomLane) {
		super(game, x, randomLane);
		this.hp = HP;
		symbol = SPRITE;
	}
	
	@Override
	public void update() {
		x--;
	}
	
}
