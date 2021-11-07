package Model;


public abstract class Osoba {

    protected String ime;
    protected String prezime;
    protected String datumRodj;
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
	public String getDatumRodj() {
		return datumRodj;
	}
	public void setDatumRodj(String datumRodj) {
		this.datumRodj = datumRodj;
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
	
	public void setAdresaStan(String ulica,int br,String grad,String Drzava)
	{
		this.adresaStan.setUlica(ulica);
		this.adresaStan.setBroj(br);
		this.adresaStan.setGrad(grad);
		this.adresaStan.setDrzava(Drzava);
	}
	public Adresa getAdresaStan() {
		return adresaStan;
	}
	
	
	
    

}
