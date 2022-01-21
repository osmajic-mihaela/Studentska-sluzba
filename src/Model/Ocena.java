package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Ocena implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4753925019373669982L;
	private String ocenaID;
	private String predmetID;
	private String studentIndeks;
	private VrednostOcene vrednostOcene;
	private LocalDate datumPolaganja;
	
	public Ocena(String predID, String studIndeks, VrednostOcene ocena, LocalDate datumPolaganja) {
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
	
	
	public LocalDate getDatumPolaganja() {
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
