package gui;

import javax.swing.AbstractListModel;

import model.BazaStudenata;
import model.Predmet;
import model.Student;

public class AbstractListModelNePredmetiStudenata extends AbstractListModel<Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2807410648743438114L;
	private Student student;
	
	AbstractListModelNePredmetiStudenata(Student student) {
		this.student = student;
	}
	@Override
	public int getSize() {
		return BazaStudenata.getInstance().getListaNePredmeta(student).size();
	}

	@Override
	public Object getElementAt(int index) {
		Predmet predmet = BazaStudenata.getInstance().getListaNePredmeta(student).get(index);
		return predmet.getPredmetID()+" - "+ predmet.getNazivPredmeta();
	}

}
