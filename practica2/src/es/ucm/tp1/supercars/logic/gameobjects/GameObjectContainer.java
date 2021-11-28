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
		if (this.isPosEmpty(go.getX(), go.getY())) {
			gameObjects.add(go);
			go.onEnter();
		}
		
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
		int i = 0;
		boolean found = false;
		
		while (i < gameObjects.size() && !found) {
			found = gameObjects.get(i).isInPosition(x, y);
			i++;
		}
		
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
		for (GameObject obj : gameObjects) {
		 	obj.onDelete();
		}
		gameObjects.clear();
	}

	public void clearLastVisibleColumn() {
		// TODO  deletes one object at a time for some reason.
		int col = game.getPlayerX() + game.getVisibility() - 1; 
		for(int i = 0; i < gameObjects.size(); i++)
			if(gameObjects.get(i).colIs(col))
				gameObjects.remove(gameObjects.get(i));
	}
	
	public void recieveWave() {
		int initialPos = game.getPlayerX() + game.getVisibility() - 1; 
		for(int i = initialPos; i >= game.getPlayerX(); i--) {
			for(int j = 0; j < game.getRoadWidth(); j++) {
				if(isPosEmpty(i + 1,j)) {
					int index = getIndexOfPos(i, j);
					if(index <= gameObjects.size())
						gameObjects.get(index - 1).reciveWave();
				}
			}
		}
	}

	public void explode(int x, int y) {
		for(int i = -1; i < 2; i++) {
			for(int j = -1; j < 2; j++){
				if(game.isWithinVisibility(x + i, y + j))
					getObjectInPosition(x + i, y + j).recieveExplosion(); // TODO MAYBE CHANGE THIS TO RECIEVE SHOT
			}
		}
	}


}
