package model;

public enum GodinaStudiranja {
	PRVA(1),DRUGA(2),TRECA(3),CETVRTA(4);
	private int br;
	
	
	private GodinaStudiranja(int br) {
		this.br=br;
	}


	public int getBr() {
		return br;
	}
	
	
}
