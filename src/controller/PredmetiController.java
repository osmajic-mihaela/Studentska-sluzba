package controller;

import java.util.List;

import gui.TabbedPane;
import model.BazaPredmeta;
import model.Predmet;

public class PredmetiController {

	private static PredmetiController instance = null;
	public static PredmetiController getInstance() {
		if(instance == null) {
			instance = new PredmetiController();
		}
		return instance;
	}
	
	private PredmetiController() {}
	
	public List<Predmet> getListaSvihPredmeta(){
		return BazaPredmeta.getInstance().getPredmeti();
	}
	
	public void dodajPredmet(Predmet predmet) {
		BazaPredmeta.getInstance().dodajPredmet(predmet);
		TabbedPane.getInstance().azurirajPrikaz(3);
	}
	
	public void izmeniPredmet(int selectedIndex, Predmet predmet) {
		BazaPredmeta.getInstance().izmeniPredmet(selectedIndex, predmet);
		TabbedPane.getInstance().azurirajPrikaz(3);
	}
	
	public void obrisiPredmet(int selectedIndex) {
		BazaPredmeta.getInstance().obrisiPredmet(selectedIndex);
		TabbedPane.getInstance().azurirajPrikaz(3);
	}
	
	public Predmet getPredmetByID(String id) {
		return BazaPredmeta.getInstance().getPredmetByID(id);
	}
	
	public void obrisiStudentaSaNepolozenih(String studentIndeks) {
		BazaPredmeta.getInstance().obrisiStudentaSaNepolozenih(studentIndeks);
	}
	
	public void obrisiOcenuPolozeni(String ocenaID, String predmetID) {
		BazaPredmeta.getInstance().obrisiOcenuPolozeni(ocenaID, predmetID);
	}
	
	public void izmenaStudenta(String staraSifra,String novaSifra) {
		BazaPredmeta.getInstance().izmenaStudenta(staraSifra, novaSifra);
	}
	
}
