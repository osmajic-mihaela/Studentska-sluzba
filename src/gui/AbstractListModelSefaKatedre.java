package gui;

import javax.swing.AbstractListModel;

import controller.KatedraController;
import model.Katedra;
import model.Profesor;

public class AbstractListModelSefaKatedre extends AbstractListModel<Object> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4660260215914821423L;
	private Katedra katedra;
	
	public AbstractListModelSefaKatedre(Katedra katedra) {
	  this.katedra=katedra;
	}
	
	@Override
	public int getSize() {
		return KatedraController.getInstance().getProfesoriZaSefa(katedra).size();
	}

	@Override
	public Object getElementAt(int index) {
		Profesor profa=KatedraController.getInstance().getProfesoriZaSefa(katedra).get(index);
		return profa.getIme()+" "+profa.getPrezime();
	}
	
}
