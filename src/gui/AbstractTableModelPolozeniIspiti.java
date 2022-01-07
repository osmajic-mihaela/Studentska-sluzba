package gui;

import javax.swing.table.AbstractTableModel;

import model.BazaOcena;
import model.Student;

public class AbstractTableModelPolozeniIspiti extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2633403946930461999L;

	Student student;
	
	AbstractTableModelPolozeniIspiti(Student student) {
		this.student = student;
	}
	
	@Override
	public int getRowCount() {
		return student.getPolozeniPred().size();
	}

	@Override
	public int getColumnCount() {
		return BazaOcena.getInstance().getColumnCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaOcena.getInstance().getValueAt(rowIndex, columnIndex);
	}
	
	@Override
	public String getColumnName(int column) {
		return BazaOcena.getInstance().getColumnName(column);
	}

}
