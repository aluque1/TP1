package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Coin extends GameObject{
	
	public static final String INFO = "[Coin] gives 1 coin to the player";
	private static int numOfCoins = 0;
	private static final String SPRITE = "¢";
	private static final int value = 1;
	private static final int HP = 1;

	public Coin(Game game, int x, int randomLane) {
		super(game, x, randomLane);
		this.hp = HP;
		symbol = SPRITE;
	}

	@Override
	public boolean receiveCollision(Player player) {
		player.recieveCoin(value);
		this.hp--;
		return true;
	}

	@Override
	public void onEnter() {
		numOfCoins++;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		
	}

	public static Object getCoinsCount() {
		return numOfCoins;
	}

}
