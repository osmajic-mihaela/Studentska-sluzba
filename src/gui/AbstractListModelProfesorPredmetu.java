package gui;

import javax.swing.AbstractListModel;

import model.BazaProfesora;
import model.Predmet;
import model.Profesor;

public class AbstractListModelProfesorPredmetu extends AbstractListModel<Object> {

	private static final long serialVersionUID = -7052735821941652456L;

	private Predmet predmet;
	
	AbstractListModelProfesorPredmetu(Predmet predmet) {
		this.predmet = predmet;
	}
	
	@Override
	public int getSize() {
		return BazaProfesora.getInstance().getProfesoriPredmeta(predmet.getPredmetID()).size();
	}

	@Override
	public Object getElementAt(int index) {
		Profesor profesor = BazaProfesora.getInstance().getProfesoriPredmeta(predmet.getPredmetID()).get(index);
		return profesor.getIme()+" "+ profesor.getPrezime();
	}
}
