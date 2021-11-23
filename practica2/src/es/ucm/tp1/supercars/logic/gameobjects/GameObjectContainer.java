package es.ucm.tp1.supercars.logic.gameobjects;

import java.util.ArrayList;
import java.util.List;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

public class GameObjectContainer {
	
	private List<GameObject> gameObjects;
	Game game;
	
	public GameObjectContainer(Game game) {
		gameObjects = new ArrayList<>();
		this.game = game;
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
	
	private int getIndexOfPos(int x, int y) {
		// TODO si no da tiempo, mirar si hoy otra manera
		
		int i = 0;
		boolean found = false;
		
		while (i < gameObjects.size() && found) {
			found = gameObjects.get(i).isInPosition(x, y);
			i++;
		}
		
		if (found)
			i -= 1;
		else
			i = - 1;
		
		return i;
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

	public Collider getObjectInPosition(int x, int y) {
		int i = 0;
		boolean encontrado = false;
		Collider obj = null;
		
		while (i < gameObjects.size() && !encontrado) {
			if (gameObjects.get(i).isInPosition(x, y)) {
				obj = gameObjects.get(i);
				encontrado = true;
			}
			i++;
		}
		return obj;
	}
	
	public void removeDead() {
		for(int i = 0; i < gameObjects.size(); i++)
		 	if(!gameObjects.get(i).isAlive()) {
		 		gameObjects.get(i).onDelete();
		 		gameObjects.remove(gameObjects.get(i));
		 	}
		}

	public void clearContainer() {
		gameObjects.clear();
	}

	public void recieveWave() {
		// TODO VER SI VA MAL QUE PUEDE SER POR ESTO 
		int initialPos = game.getPlayerX() + game.getVisibility(); 
		for(int i = initialPos; i > game.getPlayerX(); i--) {
			for(int j = 0; j < game.getRoadWidth(); j++) {
				if(isPosEmpty(i + 1,j))
					gameObjects.get(getIndexOfPos(i, j)).reciveWave();
			}
		}
	}


}
