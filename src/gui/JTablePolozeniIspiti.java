package gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import model.Student;

public class JTablePolozeniIspiti extends JTable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -239772847640081604L;
	public JTablePolozeniIspiti(Student student) {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelPolozeniIspiti(student));
	}
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {

		Component c = super.prepareRenderer(renderer, row, column);

		if (isRowSelected(row)) {
			c.setBackground(Color.ORANGE);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
	
	@Override
    public void changeSelection(int rowIndex, int columnIndex,
            boolean toggle, boolean extend) {
        super.changeSelection(rowIndex, columnIndex, true, false);
    }
}
