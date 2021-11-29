package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Pedestrian extends GameObject{

	public static final String INFO = "[PEDESTRIAN] person crossing the road up and down[PEDESTRIAN] person crossing the road up and down";
	private static final String SPRITE = "☺";
	private static final int HP = 1;
	private boolean down; // true is down, false is up
	
	public Pedestrian(Game game, int x, int y) {
		super(game, x, y);
		this.hp = HP;
		symbol = SPRITE;
		down = true;
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
        if(down)
            y++;
        else
            y--;

        if (y % (game.getRoadWidth() - 1) == 0)
            down = !down;
    }

	@Override
	public void onDelete() {
		// Empty
	}

}
