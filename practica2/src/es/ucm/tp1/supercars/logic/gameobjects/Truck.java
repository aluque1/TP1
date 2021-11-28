package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

public class Truck extends GameObject{

	public static final String INFO = "[TRUCK] moves towards the player";
	private static final String SPRITE = "←";
	private static final int HP = 1;
	
	public Truck(Game game, int x, int randomLane) {
		super(game, x, randomLane);
		this.hp = HP;
		symbol = SPRITE;
	}

	@Override
	public boolean doCollision() {
		Collider obj = game.getObjectInPosition(x, y);
		if (obj != null) {
			return obj.receiveCollision(this);
		}
		return false;
	}
	
	@Override
	public boolean receiveCollision(Player player) {
		player.decreaseHP();
		return true;
	}
	
	@Override
	public void onEnter() {
		// Empty
	}
	
	@Override
	public void update() {
		x--;
	}

	@Override
	public void onDelete() {
		// Empty
	}
}
