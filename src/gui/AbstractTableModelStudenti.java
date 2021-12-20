package gui;

import javax.swing.table.AbstractTableModel;

import model.BazaStudenata;

public class AbstractTableModelStudenti extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6481089898389356408L;

	@Override
	public int getRowCount() {
		return BazaStudenata.getInstance().getStudenti().size();
	}

	@Override
	public int getColumnCount() {
		return BazaStudenata.getInstance().getColumnCount();
	}
	
	@Override
	public String getColumnName(int column) {
		return BazaStudenata.getInstance().getColumnName(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaStudenata.getInstance().getValueAt(rowIndex, columnIndex);
	}

	
}
