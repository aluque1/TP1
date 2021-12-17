package es.ucm.tp1.supercars.logic.instantAction;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

public class ShotAction implements InstantAction{

	@Override
	public void execute(Game game) {
		boolean hit = false;
		int i = game.getPlayerX() + 1;
		int y = game.getPlayerY();
		while(y < (game.getVisibility() +  game.getPlayerX() - 1) && !hit) {
			Collider go = game.getObjectInPosition(i, y);
			if(go != null) {
				if(go.receiveShot())
					hit = true;
			}
			i++;
		}
	}
}
