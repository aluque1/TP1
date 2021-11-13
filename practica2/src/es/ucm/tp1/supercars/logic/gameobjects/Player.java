package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Player extends GameObject{


	public Player(Game game, int x, int y) {
		super(game, x, y);
		// TODO Auto-generated constructor stub
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
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
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
