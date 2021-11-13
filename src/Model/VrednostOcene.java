package model;

public enum VrednostOcene {
	SEST(6),SEDAM(7),OSAM(8),DEVET(9),DESET(10);
	int vrednost;
	
	private VrednostOcene(int vrednost) {this.vrednost=vrednost;}
	
	public int getVrednost() {
		return vrednost;
	}
	
	
}
