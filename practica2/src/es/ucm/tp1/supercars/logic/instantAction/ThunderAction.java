package es.ucm.tp1.supercars.logic.instantAction;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

public class ThunderAction implements InstantAction{

	@Override
	public void execute(Game game) {
		StringBuilder str = new StringBuilder();
		boolean hit = false;
		
		String sprite = "";
		int col = game.getRandomColumn() + game.getPlayerX();
		int row = game.getRandomLane();
		str.append("Thunder hit position: (").append(col - game.getPlayerX()).append(", ").append(row).append(")");
		sprite = game.getStringAtPos(col, row);
		
		Collider go = game.getObjectInPosition(col, row);
		if(go != null)
			hit = go.recieveThunder();
		if(hit)
			str.append(" -> ").append(sprite).append("hit");
		System.out.println(str.toString());	
	}
}
