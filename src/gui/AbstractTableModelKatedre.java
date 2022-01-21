package gui;

import javax.swing.table.AbstractTableModel;

import controller.KatedraController;

public class AbstractTableModelKatedre extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8793568446680487444L;

	@Override
	public int getRowCount() {
		return KatedraController.getInstance().getListaSvihKatedri().size();
	}

	@Override
	public int getColumnCount() {
		return KatedraController.getInstance().getColumnCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return KatedraController.getInstance().getValueAt(rowIndex, columnIndex);
	}
	
	@Override
	public String getColumnName(int column) {
		return KatedraController.getInstance().getColumnName(column);
	}

}
