package controller;

import java.util.List;

import gui.TabbedPane;
import model.BazaStudenata;
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
}
