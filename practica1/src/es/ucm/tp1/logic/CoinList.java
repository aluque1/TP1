package es.ucm.tp1.logic;

public class CoinList {
	
	private Coin[] cl;
	
	public CoinList(int size) {
		cl = new Coin[size];
	}

	public void add(Coin coin) {
		cl[Coin.numOfCoins - 1] = coin;
	}

	public boolean isPosCoin(int row, int col) {
		boolean isInPos = false;
		int i = 0;
		while(!isInPos && (i < Coin.numOfCoins)) {
			isInPos = cl[i].isInPosition(row, col);
			i++;
		}
		return isInPos;
	}
}
