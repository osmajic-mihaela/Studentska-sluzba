package controller;

import java.util.List;

import gui.TabbedPane;
import model.BazaStudenata;
import model.Predmet;
import model.Student;

public class StudentiController {

	private static StudentiController instance=null;
	public static StudentiController getInstance() {
		if(instance==null) {
			instance=new StudentiController();
		}
		return instance;
	}
	
	private StudentiController() {}
	
	public void dodajStudenta(Student s) {
		BazaStudenata.getInstance().dodajStudenda(s);
		TabbedPane.getInstance().azurirajPrikaz(1);
	}
	
	public List<Student> getListaSvihStudenata() {
		return BazaStudenata.getInstance().getStudenti();
	}
	
	public void izmeniStudenta(int i, Student s) {
		BazaStudenata.getInstance().izmeniStudenta(i, s);
		TabbedPane.getInstance().azurirajPrikaz(1);
	}
	
	public void obrisiStudenta(int index) {
		BazaStudenata.getInstance().obrisiStudenta(index);
		TabbedPane.getInstance().azurirajPrikaz(1);
	}
	
	public void updatePrikaz() {
		TabbedPane.getInstance().azurirajPrikaz(1);
	}
	
	public List<Predmet> listaPredmetaZaDodavanje(Student student){
		return BazaStudenata.getInstance().getListaNePredmeta(student);
	}
	
	public void izmeniPredmet(String stara,String nova) {
		BazaStudenata.getInstance().izmenaPredmeta(stara, nova);
	}
}
