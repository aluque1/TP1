package es.ucm.tp1.logic;

public class ObstacleList {

	private Obstacle[] ol;
	private int cont;

	public ObstacleList(int size) {
		ol = new Obstacle[size];
		cont = 0;
	}

	public void add(Obstacle obs) {
		ol[cont] = obs;
		cont++;
	}

	public boolean isPosObstacle(int row, int col) {
		
		boolean isInPos = false;
		int i = 0;
		while(!isInPos && (i < cont)) {
			isInPos = ol[i].isInPosition(row, col);
			i++;
		}
		return isInPos;
	}

}
