package model;

import java.util.ArrayList;
import java.util.List;

import controller.ProfesoriController;

public class BazaKatedri {
private static BazaKatedri instance = null;
	
	public static BazaKatedri getInstance() {
		if(instance == null) {
			instance = new BazaKatedri();
		}
		
		return instance;
	}
	
	private List<Katedra> katedre;
	private List<String> kolone;
	
	private BazaKatedri(){
		
		initKatedre();
		
		kolone = new ArrayList<String>();
		kolone.add("Sifra katedre");
		kolone.add("Naziv katedre");
		kolone.add("Sef katedre");

	}
	
	private void initKatedre() {
		this.katedre= new ArrayList<Katedra>();
		katedre.add(new Katedra("e42", "Katedra za matematiku", ""));
		katedre.add(new Katedra("e43", "Katedra za fiziku", ""));
		katedre.add(new Katedra("e44", "Katedra za elektroniku", ""));
		katedre.add(new Katedra("e45", "Katedra za primenjene racunarske nauke", ""));
		katedre.add(new Katedra("e46", "Katedra za informatiku", ""));
		katedre.add(new Katedra("e47", "Katedra za automatiku", ""));
		
		
	}
	
	public List<Katedra> getKatedre(){
		return katedre;
	}
	
	public void setKatedre(List<Katedra> katedre) {
		this.katedre = katedre;
	}
	
	public int getColumnCount() {
		return 3;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Katedra getRow(int rowIndex) {
		return this.katedre.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Katedra katedra = this.katedre.get(row);
		switch(column) {
			case 0:
				return katedra.getKatedraID();
			case 1:
				return katedra.getNazivKatedre();
			case 2:
				if(katedra.getSefKatedreID()!="") {
					Profesor pr=ProfesoriController.getInstance().getProfesorByID(katedra.getSefKatedreID());
					return pr.getIme()+" "+pr.getPrezime(); 
				}
				else
					return katedra.getSefKatedreID();
			default:
				return null;
		}	
	}
	
	public List<String> getSifreSvihKatedri(){
		
		List<String> lista= new ArrayList<>();
		for(Katedra k : katedre) {
			lista.add(k.getKatedraID());
		}
		return lista;
	}
	
	public ArrayList<Profesor> getProfesoriZaSefa(Katedra katedra){
		
		ArrayList<Profesor> predavaci = new ArrayList<Profesor>();
		for(String profesorID : katedra.getProfesoriNaKatedri()) {
			Profesor p= ProfesoriController.getInstance().getProfesorByID(profesorID);
			if((p.getGodRadnogStaza()>4) && ((p.getZvanje().equalsIgnoreCase("REDOVNI_PROFESOR")) ||(p.getZvanje().equalsIgnoreCase("VANREDNI_PROFESOR")) ) && (!katedra.getSefKatedreID().equals(p.getProfesorID()))) {
				predavaci.add(p);
			}
		}
		return predavaci;
		
	}
	
	public Katedra findByID(String sifra) {
		for(Katedra k : katedre) {
			if(k.getKatedraID().equalsIgnoreCase(sifra))
				return k;
		}
		return null;
	}
	
	public void dodajPredmet(String sifraKatedre,Predmet predmet) {
		Katedra k= findByID(sifraKatedre);
		k.getPredmetiNaKatedri().add(predmet.getPredmetID());
		//System.out.println(k.getPredmetiNaKatedri());
	}
	
	public void izmeniPredmet(String katedraNova,String brojNovi,String staraSifraPredmeta) {
		
		if(!(staraSifraPredmeta).contains(katedraNova) ) {
			Katedra k= findByID(staraSifraPredmeta.substring(0,3));
			k.getPredmetiNaKatedri().remove(staraSifraPredmeta);
			Katedra k1= findByID(katedraNova);
			k1.getPredmetiNaKatedri().add(katedraNova+brojNovi);
			return;
		}
		Katedra k= findByID(staraSifraPredmeta.substring(0,3));
		int i=k.getPredmetiNaKatedri().indexOf(staraSifraPredmeta);
		k.getPredmetiNaKatedri().add(i, katedraNova+brojNovi);
		return ;
	}
	
	public void dodajProfesora(String predmetID, String profesorID) {
		Katedra k= findByID(predmetID.substring(0,3));
		if(!k.getProfesoriNaKatedri().contains(profesorID)) {
			k.getProfesoriNaKatedri().add(profesorID);
			//System.out.println("predmeti: "+k.getPredmetiNaKatedri());
			//System.out.println("profesori:"+ k.getProfesoriNaKatedri());
		}
	}
	
	public void proveraBrisanjaProfesora(int rbPredmetaProf,Profesor prof) {
		
		String predmetID= prof.getPredmetiKojePred().get(rbPredmetaProf);
		String katedraID=predmetID.substring(0,3);
		Katedra k=findByID(katedraID);
		int br=0;
		
		for(String prID : prof.getPredmetiKojePred()) {
			if(k.getPredmetiNaKatedri().contains(prID))
				br++;
		}
		
		if(br==0) {
			if(k.getSefKatedreID().equalsIgnoreCase(prof.getProfesorID()))
				k.setSefKatedreID("");
			
			k.getProfesoriNaKatedri().remove(k.getProfesoriNaKatedri().indexOf(prof.getProfesorID()));
		}
		
	}
}
