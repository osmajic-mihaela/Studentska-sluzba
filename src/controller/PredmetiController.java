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
		//
	}
	
	public void izmeniPredmet(int selectedIndex, Predmet predmet) {
		//
	}
	
	public void obrisiPredmet(int selectedIndex) {
		BazaPredmeta.getInstance().obrisiPredmet(selectedIndex);
		TabbedPane.getInstance().azurirajPrikaz(3);
	}
}
