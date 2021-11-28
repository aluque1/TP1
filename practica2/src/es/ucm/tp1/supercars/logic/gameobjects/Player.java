package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

public class Player extends GameObject{

	private int coinsCollected;
	private static final int HP = 1;

	public Player(Game game, int x, int y) {
		super(game, x, y);
		onEnter();
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
	public boolean receiveCollision(Truck truck) {
		truck.decreaseHP();
		return true;
	}

	public void recieveCoin(int value) {
		coinsCollected = getCoinsCollected() + value;
	}
	
	public void loseCoins() {
		coinsCollected = 0;
	}
	
	public void spendCoins(int price) {
		coinsCollected -= price;
	}

	public void giveCoins(int coins) {
		coinsCollected += coins;
	}
	
	public void recieveTurbo() {
		x += 3;
	}

	public void moveForward() {
		x++;
	}
	
	public boolean moveUp() {
		boolean canMove = false;
		int futurePos = y - 1;
		if(game.isWithinBounds(futurePos)) {
			y = futurePos;
			canMove = true;
		}
		return canMove;
	}

	public boolean moveDown() {
		boolean canMove = false;
		int futurePos = y + 1;
		if(game.isWithinBounds(futurePos)) {
			y = futurePos;
			canMove = true;
		}
		return canMove;
	}

	@Override
	public void update() {
		if(!doCollision())
			moveForward();
		doCollision();
	}
	
	@Override
	public void onEnter() {
		coinsCollected = 5;
		this.hp = HP;

	}

	@Override
	public void onDelete() {
		// empty because never gets deleted.
	}
	
	@Override
	public boolean receiveWave() {
		return false;
	}

	public int getCoinsCollected() {
		return coinsCollected;
	}

	@Override
	public String toString() {
		String sprite;
		if (isAlive()) {
			sprite = ">";
		}
		else
			sprite = "@";
		
		return sprite;
	}
}
