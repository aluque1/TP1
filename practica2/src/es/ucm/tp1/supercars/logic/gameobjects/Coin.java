package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Coin extends GameObject{
	
	public static final String INFO = "[Coin] gives 1 coin to the player";
	private static int numOfCoins = 0;

	public Coin(Game game, int x, int randomLane) {
		super(game, x, randomLane);
		numOfCoins++;
	}

	@Override
	public boolean doCollision() {
		// TODO Auto-generated method stub
		return false;
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

	public static Object getCoinsCount() {
		return numOfCoins;
	}

}
