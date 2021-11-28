package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class SuperCoin extends Coin{
	
	public static final String INFO = "[SUPERCOIN] gives 1000 coins";
	private static boolean isPresent = false;
	private static final String SPRITE = "$";
	private static final int VALUE = 1000;

	public SuperCoin(Game game, int x, int randomLane) {
		super(game, x, randomLane);
		symbol = SPRITE;
		value = VALUE;
	}
	
	@Override
	public void onEnter() {
		isPresent = true;
	}
	
	@Override
	public void onDelete() {
		isPresent = false;
	}
	
	public static boolean hasSuperCoin() {
		return isPresent;
	}
}
