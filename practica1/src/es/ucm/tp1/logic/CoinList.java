package es.ucm.tp1.logic;

public class CoinList {
	
	private Coin[] cl;
	
	public CoinList(int size) {
		cl = new Coin[size];
		Coin.numOfCoins = 0;
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
	
	public void pickCoinInPos(int row, int col) {
		for(int i = 0; i < Coin.numOfCoins; i++) {
			if(cl[i].isInPosition(row, col))
				for(int j = i; j < Coin.numOfCoins - 1; ++j) {
					cl[j] = cl[j + 1];
				}
		}
		Coin.numOfCoins--;
	}
	
	
}
