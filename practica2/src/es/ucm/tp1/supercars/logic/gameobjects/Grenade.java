package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Grenade extends GameObject{

	public static final String INFO = "[GRENADE] Explodes in 3 cycles, harming everyone around";
	private static final String SPRITE = "ð";
	protected static final int HP = 3;
	
	public Grenade(Game game, int x, int y) {
		super(game, x, y);
		this.hp = HP;
		symbol = SPRITE;
	}

	@Override
	public boolean receiveCollision(Player player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onEnter() {
		// Does not do anything
	}

	@Override
	public void update() {
		if(isAlive()) 
			hp--;
		//else 
			//explosionAction(game, x, y); 
	}

	@Override
	public void onDelete() {
		// Does not do anything
	}
	
	@Override
	public boolean receiveShot() {
		return false;
	}
	
	@Override
	public String toString() {
		String sprite = "";
		if (isAlive()) {
			sprite = getSymbol() + "[" + hp + "]";
		}
		return sprite;
	}

}
