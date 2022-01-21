package controller;

import java.util.ArrayList;
import java.util.List;

import model.BazaKatedri;
import model.Katedra;
import model.Profesor;

public class KatedraController {
	private static KatedraController instance = null;
	public static KatedraController getInstance() {
		if(instance == null) {
			instance = new KatedraController();
		}
		return instance;
	}
	
	private KatedraController() {}
	
	public List<Katedra> getListaSvihKatedri(){
		return BazaKatedri.getInstance().getKatedre();
	}
	
	public List<String> getSifreSvihKatedri(){
		return BazaKatedri.getInstance().getSifreSvihKatedri();
	}
	
	public int getColumnCount() {
		return  BazaKatedri.getInstance().getColumnCount();
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaKatedri.getInstance().getValueAt(rowIndex, columnIndex);
	}
	
	public String getColumnName(int column) {
		return BazaKatedri.getInstance().getColumnName(column);
	}
	
	public ArrayList<Profesor> getProfesoriZaSefa(Katedra katedra){
		
		return BazaKatedri.getInstance().getProfesoriZaSefa(katedra);
		
	}
}
