package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class SuperCoin extends Coin{
	
	public static final String INFO = "[Super Coin] gives 1000 coins to the player";
	private static boolean isPresent = false;
	private static final String SPRITE = "$";
	private static final int value = 1000;

	public SuperCoin(Game game, int x, int randomLane) {
		super(game, x, randomLane);
		this.hp = HP;
		symbol = SPRITE;
	}

	@Override
	public void onEnter() {
		isPresent = true;
	}
	
	@Override
	public void onDelete() {
		isPresent = false;
	}
	
}
