package gui;

import java.util.List;

import javax.swing.AbstractListModel;

import controller.KatedraController;
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
		String[] katedra = { "ma", "fz", "eo", "ps","it","p" };
        List<String> listaKatedri= KatedraController.getInstance().getSifreSvihKatedri();
		return katedra[listaKatedri.indexOf(predmet.getPredmetID().substring(0, 3))]+predmet.getPredmetID().substring(3)+" - "+ predmet.getNazivPredmeta();
	}

}
