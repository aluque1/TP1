package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Coin extends GameObject{
	
	public static final String INFO = "[Coin] gives 1 coin to the player";
	private static int numOfCoins = 0;
	private static final String SPRITE = "¢";
	private static final int VALUE = 1;
	protected static final int HP = 1;
	protected int value;

	public Coin(Game game, int x, int randomLane) {
		super(game, x, randomLane);
		this.hp = HP;
		symbol = SPRITE;
		this.value = VALUE;
		
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
		//Empty as it doesn't move
		
	}

	@Override
	public void onDelete() {
		numOfCoins--;
	}

	public static Object getCoinsCount() {
		return numOfCoins;
	}

}
