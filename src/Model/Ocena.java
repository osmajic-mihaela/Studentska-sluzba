package model;

public class Ocena {
	
	private String ocenaID;
	private String predmetID;
	private String studentIndeks;
	private VrednostOcene vrednostOcene;
	private String datumPolaganja;
	
	public Ocena(String predID, String studIndeks, VrednostOcene ocena, String datumPolaganja) {
		super();
		this.predmetID = predID;
		this.studentIndeks = studIndeks;
		this.vrednostOcene=ocena;
		this.datumPolaganja = datumPolaganja;
		this.ocenaID=predID+studIndeks;
		
	}
	
	public String getPredmetID() {
		return predmetID;
	}
	
	public String getStudentIndeks() {
		return studentIndeks;
	}
	
	public VrednostOcene getVrednostOcene() {
		return vrednostOcene;
	}
	
	
	public String getDatumPolaganja() {
		return datumPolaganja;
	}

	public String getOcenaID() {
		return ocenaID;
	}

	public void setOcenaID(String ocenaID) {
		this.ocenaID = ocenaID;
	}

	public void setPredmetID(String predmetID) {
		this.predmetID = predmetID;
	}

	public void setStudentIndeks(String studentIndeks) {
		this.studentIndeks = studentIndeks;
	}
	
	
	
	
	
	

}
