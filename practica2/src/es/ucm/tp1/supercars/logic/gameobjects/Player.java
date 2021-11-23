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

	public void decreaseHP() {
		hp--;
	}

	@Override
	public boolean receiveCollision(Player player) {
		// Aun no, se va a escribir cuando tengamos el truck y el pedestrian
		return false;
	}

	

	public void recieveCoin(int value) {
		coinsCollected = getCoinsCollected() + value;
	}
	
	public void recieveTurbo() {
		x += 3;
		doCollision();
	}

	public boolean moveUp() {
		int futurePos = y - 1;
		if(game.isWithinBounds(futurePos)) {
			y = futurePos;
			return true;
		}
		else
			return false;
	}

	public boolean moveDown() {
		int futurePos = y + 1;
		if(game.isWithinBounds(futurePos)) {
			y = futurePos;
			
			return true;
		}
		else
			return false;
	}

	@Override
	public void update() {
		x++;
		doCollision();
	}
	
	@Override
	public void onEnter() {
		coinsCollected = 0;
		this.hp = HP;

	}

	@Override
	public void onDelete() {
		// empty because never gets deleted.

	}

	public int getCoinsCollected() {
		return coinsCollected;
	}

	@Override
	public String toString() {
		if (isAlive()) {
			return ">";
		}
		else
			return "@";
	}

	


}
