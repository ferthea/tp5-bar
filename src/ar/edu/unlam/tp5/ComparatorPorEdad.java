package ar.edu.unlam.tp5;

import java.util.Comparator;

public class ComparatorPorEdad implements Comparator<Cliente>{
	
	public ComparatorPorEdad(){
		
	}

	@Override
	public int compare(Cliente c1, Cliente c2) {
		return c1.getEdad() - c2.getEdad();
	}
}
