package controller;

import java.util.List;

import gui.TabbedPane;
import model.BazaProfesora;
import model.Predmet;
import model.Profesor;

public class ProfesoriController {

	private static ProfesoriController instance = null;
	public static ProfesoriController getInstance() {
		if(instance == null) {
			instance = new ProfesoriController();
		}
		return instance;
	}
	
	private ProfesoriController() {}
	
	public void dodajProfesora(Profesor profesor) {
		BazaProfesora.getInstance().dodajProfesora(profesor);
		TabbedPane.getInstance().azurirajPrikaz(2);
	}
	
	public List<Profesor> getListaSvihProfesora() {
		return BazaProfesora.getInstance().getProfesori();
	}
	
	public void izmeniProfesora(int index, Profesor profesor) {
		BazaProfesora.getInstance().izmeniProfesora(index, profesor);
		TabbedPane.getInstance().azurirajPrikaz(2);
	}
	
	public void obrisiProfesora(int index) {
		BazaProfesora.getInstance().obrisiProfesora(index);
		TabbedPane.getInstance().azurirajPrikaz(2);
	}
	
	
	public List<Predmet> listaPredmetaKojeNePredaje(Profesor profesor){
		return BazaProfesora.getInstance().getListaNePredmeta(profesor);
	}
	
	public void obrisiPredmetProfesoru(int index, Profesor profesor) {
		BazaProfesora.getInstance().obrisiPredmetProfesoru(index,profesor);
		
	}
	
	public Profesor getProfesorByID(String id) {
		return BazaProfesora.getInstance().getProfesorByID(id);
	}
	public Profesor getProfesoriPredmeta(String id, int index) {
		return BazaProfesora.getInstance().getProfesoriPredmeta(id).get(index);
	}
}
