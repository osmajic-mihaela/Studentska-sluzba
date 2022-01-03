package gui;

import java.awt.Color;
import java.awt.Component;
import java.util.Comparator;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

public class JTableStudenti extends JTable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6299463764788138191L;
	private static JTableStudenti instance=null;
	private static TableRowSorter<AbstractTableModelStudenti> sorter;
	
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
		
		AbstractTableModelStudenti model = new AbstractTableModelStudenti();
		sorter = new TableRowSorter<AbstractTableModelStudenti>(model);
		
		sorter.setComparator(0, new Comparator<String>() {
			
			public int compare(String o1, String o2) {
				
				String[] parts1 = o1.split("-");
				String p11 = parts1[0];
				String p21 = parts1[1];
				String p31 = parts1[2];
				
				String[] parts2 = o2.split("-");
				String p12 = parts2[0];
				String p22 = parts2[1];
				String p32 = parts2[2];
				
				int razlika;
				
				int ret = p11.compareTo(p12);
				if(ret==0) {
					razlika = Integer.parseInt(p31) - Integer.parseInt(p32);
					
					if(razlika==0) {
						
						return Integer.parseInt(p21) - Integer.parseInt(p22);
					}
					
					else 
						return razlika;
				}
					
				else 
					return ret;
				
				
				}
		
		});
		
		this.setRowSorter(sorter);
		
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
