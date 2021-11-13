package model;

import java.time.LocalDate;

public abstract class Osoba {

    protected String ime;
    protected String prezime;
    protected LocalDate datumRodj;
    protected String kontaktBroj;
    protected String email;
    protected Adresa adresaStan;
    
    
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getKontaktBroj() {
		return kontaktBroj;
	}
	public void setKontaktBroj(String kontaktBroj) {
		this.kontaktBroj = kontaktBroj;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setAdresaStan(String ulica,String br,String grad,String Drzava)
	{
		this.adresaStan.setUlica(ulica);
		this.adresaStan.setBroj(br);
		this.adresaStan.setGrad(grad);
		this.adresaStan.setDrzava(Drzava);
	}

	public Adresa getAdresaStan() {
		return adresaStan;
	}
	public LocalDate getDatumRodj() {
		return datumRodj;
	}
	public void setDatumRodj(LocalDate datumRodj) {
		this.datumRodj = datumRodj;
	}
	
	
	
	
    

}
