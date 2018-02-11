package presentacion;

import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListCellRenderer;

import dominio.Vino;



public class CustomListModel extends AbstractListModel {
	private ArrayList<Vino> lista = new ArrayList<>();

	
	@Override
	public int getSize() {
		return lista.size();
	}
	@Override
	public Object getElementAt(int index) {
		Vino p = lista.get(index);
		return p.getNombre();
	}
	
	public void addVino(Vino p ){
		lista.add(p);
		this.fireIntervalAdded(this, getSize(), getSize()+1);
		 }
	
	public void eliminarVino(int index0){
		lista.remove(index0);
		this.fireIntervalRemoved(index0, getSize(), getSize()+1);
	}
	
	public Vino getVino(int index){
		return lista.get(index);
	}
	
	
	public void modificarVino(Vino p, int index) {
		Vino aux = lista.get(index);
		aux.setNombre(p.getNombre());
		aux.setCosecha(p.getCosecha());
		aux.setTipo(p.getTipo());
		aux.setPrecio(p.getPrecio());
		aux.setStock(p.getStock());
		
		lista.remove(p);
		lista.add(aux);
	}
	
	
	
	
	
}

