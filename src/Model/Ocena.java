package Model;


public class Ocena {
	
	private String ocenaID;
	private String predmetID;
	private String studentIndeks;
	private int vrednostOcene;
	private String datumPolaganja;
	
	public Ocena(String predID, String studIndeks, int ocena, String datumPolaganja) {
		super();
		this.predmetID = predID;
		this.studentIndeks = studIndeks;
		
		if(ocena>=6 && ocena<=10)
			this.vrednostOcene=ocena;
		else
			System.out.println("Ocena nije validna");
		
		this.datumPolaganja = datumPolaganja;
		this.ocenaID=predID+studIndeks;
		
	}
	
	public String getPredmetID() {
		return predmetID;
	}
	
	public String getStudentIndeks() {
		return studentIndeks;
	}
	
	public int getVrednostOcene() {
		return vrednostOcene;
	}
	
	
	public String getDatumPolaganja() {
		return datumPolaganja;
	}

	public String getOcenaID() {
		return ocenaID;
	}
	
	
	
	
	
	

}
