package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Pedestrian extends GameObject{

	public static final String INFO = "[PEDESTRIAN] person crossing the road up and down[PEDESTRIAN] person crossing the road up and down";
	private static final String SPRITE = "☺";
	private static final int HP = 1;
	private boolean abajo; // true is up, false is down
	
	public Pedestrian(Game game, int x, int y) {
		super(game, x, y);
		this.hp = HP;
		symbol = SPRITE;
		abajo = true;
	}

	@Override
	public boolean receiveCollision(Player player) {
		player.decreaseHP();
		player.loseCoins();
		return true;
	}

	@Override
	public void onEnter() {
		// Empty
		
	}

	@Override
	public boolean receiveShot() {
		this.hp--;
		game.playerLoseCoins();
		return true;
	}
	
	@Override
	public void update() {
		if(abajo)
			y++;
		else
			y--;
		// programar movimiento, lo unico que hace fatla es subir o bajar, comprobar si esta en el borde y cambiar de direccion en caso afirmativo
		
	}

	@Override
	public void onDelete() {
		// Empty
	}

}
