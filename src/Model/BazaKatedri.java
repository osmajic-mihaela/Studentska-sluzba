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
			if((p.getGodRadnogStaza()>4) && ((p.getZvanje().equalsIgnoreCase("redovni profesor")) ||(p.getZvanje().equalsIgnoreCase("vanredni profesor")) ) && (!katedra.getSefKatedreID().equals(p.getProfesorID()))) {
				predavaci.add(p);
			}
		}
		return predavaci;
		
	}
}
