package gui;

import javax.swing.AbstractListModel;

import model.BazaProfesora;
import model.Predmet;
import model.Profesor;

public class AbstractListModelPredmetiProfNePredaje extends AbstractListModel<Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7052735821941652456L;

	private Profesor profesor;
	
	AbstractListModelPredmetiProfNePredaje(Profesor profesor) {
		this.profesor = profesor;
	}
	
	@Override
	public int getSize() {
		return BazaProfesora.getInstance().getListaNePredmeta(profesor).size();
	}

	@Override
	public Object getElementAt(int index) {
		Predmet predmet = BazaProfesora.getInstance().getListaNePredmeta(profesor).get(index);
		return predmet.getPredmetID()+" - "+ predmet.getNazivPredmeta();
	}

}
