package es.ucm.tp1.logic;

public class ObstacleList {

	private Obstacle[] ol;

	public ObstacleList(int size) {
		ol = new Obstacle[size];
		Obstacle.numOfObstacles = 0;
	}

	public void add(Obstacle obs) {
		ol[Obstacle.numOfObstacles - 1] = obs;
	}

	public boolean isPosObstacle(int row, int col) {
		
		boolean isInPos = false;
		int i = 0;
		while(!isInPos && (i < Obstacle.numOfObstacles)) {
			isInPos = ol[i].isInPosition(row, col);
			i++;
		}
		return isInPos;
	}
	
	

}
