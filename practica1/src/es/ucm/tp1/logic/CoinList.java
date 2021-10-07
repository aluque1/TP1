package es.ucm.tp1.logic;

public class CoinList {
	
	private Coin[] cl;
	private int cont;
	
	public CoinList(int size) {
		cl = new Coin[size];
		cont = 0;
	}

	public void add(Coin coin) {
		cl[cont] = coin;
		cont++;
	}

	public boolean isPosCoin(int row, int col) {
		boolean isInPos = false;
		int i = 0;
		while(!isInPos && (i < cont)) {
			isInPos = cl[i].isInPosition(row, col);
			i++;
		}
		return isInPos;
	}
}
