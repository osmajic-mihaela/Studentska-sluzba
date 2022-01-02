package gui;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmeta;
import model.Profesor;

public class AbstractTableModelPredmetiPoProfesoru extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6643396654384128386L;
	
	Profesor profesor;
	
	AbstractTableModelPredmetiPoProfesoru(Profesor profesor) {
		this.profesor = profesor;
	}

	@Override
	public int getRowCount() {
		return profesor.getPredmetiKojePred().size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String sifra=profesor.getPredmetiKojePred().get(rowIndex);
		int i=BazaPredmeta.getInstance().getIndexByID(sifra);
		if(columnIndex>1)
			columnIndex+=1;
		return BazaPredmeta.getInstance().getValueAt(i, columnIndex);
	}

	@Override
	public String getColumnName(int column) {
		if(column>1)
			column+=1;
		return BazaPredmeta.getInstance().getColumnName(column);
	}
}
