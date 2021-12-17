package es.ucm.tp1.supercars.logic.instantAction;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

public class WaveAction implements InstantAction{

	@Override
	public void execute(Game game) {
		int initialPos = game.getPlayerX() + game.getVisibility() - 1; 
		for(int i = initialPos; i >= game.getPlayerX(); i--) {
			for(int j = 0; j < game.getRoadWidth(); j++) {
				if(game.getObjectInPosition(i + 1, j) == null) {
					Collider go = game.getObjectInPosition(i, j);
					if(go != null)
						go.receiveWave();
				}
			}
		}
	}
	
}
