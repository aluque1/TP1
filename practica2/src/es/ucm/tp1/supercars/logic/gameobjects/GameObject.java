package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

public abstract class GameObject implements Collider {

	protected int x, y;

	protected Game game;

	protected String symbol;
	protected int hp;

	public GameObject(Game game, int x, int y) {
		this.x = x;
		this.y = y;
		this.game = game;
	}

	protected String getSymbol() {
		return symbol;
	}

	@Override
	public String toString() {
		String sprite = "";
		if (isAlive()) {
			sprite = getSymbol();
		}
		return sprite;
	}

	public boolean isInPosition(int x, int y) {
		return this.x == x && this.y == y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isAlive() {
		return hp > 0;
	}

	public abstract void onEnter();

	public abstract void update();

	public abstract void onDelete();
	
	public void decreaseHP() {
		hp--;
	}

	protected void instaKill() {
		hp = 0;
	}
	
	@Override
	public boolean receiveWave() {
		x++;
		return true;
	}
	
	@Override
	public boolean receiveShot() {
		this.hp--;
		return true;
	}

}
