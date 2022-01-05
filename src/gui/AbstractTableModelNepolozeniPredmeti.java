package gui;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmeta;
import model.Student;
import model.Predmet;

public class AbstractTableModelNepolozeniPredmeti extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    Student student;

    AbstractTableModelNepolozeniPredmeti(Student student){
        this.student = student;
    }

    @Override
    public int getRowCount(){
        return student.getNepolozeniPred().size();
    }

    @Override
    public int getColumnCount(){
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        String predmetid = student.getNepolozeniPred().get(rowIndex);
        Predmet p = BazaPredmeta.getInstance().getPredmetByID(predmetid);
        
        switch(columnIndex) {
        	case 0:
        		return p.getPredmetID();
        	case 1:
        		return p.getNazivPredmeta();
        	case 2:
        		return p.getBrESPB();
        	case 3:
        		return p.getGodStudija()+"";
        	case 4:
        		return p.getSemestar()+"";
        	default:
        		return null;
        }
    }

    @Override
    public String getColumnName(int column){
        switch(column) {
        	case 0:
        		return "Šifra predmeta";
        	case 1:
        		return "Naziv predmeta";
        	case 2:
        		return "ESPB";
        	case 3:
        		return "Godina studija";
        	case 4:
        		return "Semestar";
        	default:
        		return null;
        }
    }
}