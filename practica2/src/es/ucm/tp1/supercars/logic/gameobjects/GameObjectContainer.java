package es.ucm.tp1.supercars.logic.gameobjects;

import java.util.ArrayList;
import java.util.List;

public class GameObjectContainer {
	
	private List<GameObject> gameObjects;
	
	public GameObjectContainer() {
		gameObjects = new ArrayList<>();
	}
	
	public void update() {
		for (GameObject obj : gameObjects) {
			 	obj.update();
			}
	}

	public void addObject(GameObject go) {
		if (this.isPosEmpty(go.getX(), go.getY()))
		gameObjects.add(go);
		go.onEnter();
	}
	
	private boolean isPosEmpty(int x, int y){
		int i = 0;
		boolean empty = true;
		
		while (i < gameObjects.size() && empty) {
			empty = !(gameObjects.get(i).isInPosition(x, y));
			i++;
		}
		return empty;
	}

	public String getStringAtPos(int x, int y) {
		int i = 0;
		boolean encontrado = false;
		String symbol = "";
		
		while (i < gameObjects.size() && !encontrado) {
			if (gameObjects.get(i).isInPosition(x, y)) {
				symbol = gameObjects.get(i).toString();
				encontrado = true;
			}
			i++;
		}
		return symbol;
	}
	
	
}
