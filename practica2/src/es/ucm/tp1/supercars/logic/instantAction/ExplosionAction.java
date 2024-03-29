package es.ucm.tp1.supercars.logic.instantAction;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

public class ExplosionAction implements InstantAction{
	
	private int x;
	private int y;
	
	public ExplosionAction(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void execute(Game game) {
		for(int i = -1; i < 2; i++) {
			for(int j = -1; j < 2; j++){
				Collider go = game.getObjectInPosition(x + i, y + j);
				if(go != null)
					go.receiveShot();
			}
		}
	}
}