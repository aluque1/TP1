package es.ucm.tp1.supercars.control;

public enum Level {

	TEST(10, 3, 8, 0.5, 0, 0), EASY(30, 3, 8, 0.5, 0.5, 0), HARD(100, 5, 6, 0.7, 0.3, 0), ADVANCED(100, 3, 8, 0.3, 0.3, 0.1);

	private int length;

	private int width;

	private int visibility;

	private double coinFrequency;

	private double obstacleFrequency;
	
	private double advObjFrequency;


	private Level(int length, int width, int visibility, double obstacleFrequency, double coinFrequency, double advObjFrequency) {
		this.length = length;
		this.width = width;
		this.visibility = visibility;
		this.obstacleFrequency = obstacleFrequency;
		this.coinFrequency = coinFrequency;
		this.advObjFrequency = advObjFrequency;
	}

	public static Level valueOfIgnoreCase(String inputString) {
		for (Level level : Level.values()) {
			if (level.name().equalsIgnoreCase(inputString)) {
				return level;
			}
		}
		return null;
	}

	public static String all(String separator) {
		StringBuilder buffer = new StringBuilder();
		int levelCount = 0;
		for (Level level : Level.values()) {
			if (levelCount > 0) {
				buffer.append(separator);
			}
			buffer.append(level.name());
			levelCount++;
		}
		return buffer.toString();
	}

// Getters for the game to be able to determine if we are inside the bounds, we are able to generate a coin, etc.
	public int getNumOfCols() {
		return this.length;
	}
	
	public int getNumOfRows() {
		return this.width;
		
	}

	public int getVisibility() {
		return visibility;
	}

	public double getCoinFrequency() {
		return coinFrequency;
	}

	public double getObstacleFrequency() {
		return obstacleFrequency;
	}
	
	public int getLength() {
		return length;
	}
	
	public int getWidth() {
		return width;
	}

	public boolean hasAdvancedObjects() {
		return advObjFrequency > 0;
	}

	public double advancedObjectsFrequency() {
		return advObjFrequency;
	}
	
}
