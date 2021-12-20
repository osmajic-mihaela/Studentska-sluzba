package gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class JTableStudenti extends JTable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6299463764788138191L;
	private static JTableStudenti instance=null;
	
	public static JTableStudenti getInstance() {
		if(instance==null) {
			instance=new JTableStudenti();
		}
		return instance;
	}
	
	private JTableStudenti() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelStudenti());
		
		
	}

	@Override
    public void changeSelection(int rowIndex, int columnIndex,
            boolean toggle, boolean extend) {
        super.changeSelection(rowIndex, columnIndex, true, false);
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
}
