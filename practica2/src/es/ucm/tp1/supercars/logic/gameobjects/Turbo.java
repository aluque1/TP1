package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Turbo extends GameObject{
	
	private static final String SPRITE = ">>>";
	protected static final int HP = 1;
	public static final String INFO = "[TURBO] pushes the car: 3 columns";

	public Turbo(Game game, int x, int y) {
		super(game, x, y);
		this.hp = HP;
		symbol = SPRITE;
	}

	@Override
	public boolean receiveCollision(Player player) {
		player.recieveTurbo();
		this.hp--;
		return true;
	}

	@Override
	public void onEnter() {
		// Does not do anything
		
	}

	@Override
	public void update() {
		// Does not do anything
		
	}

	@Override
	public void onDelete() {
		// Does not do anything
	}
}
