package ar.edu.unlam.tp5;

import java.util.TreeSet;

public class Bar{
	private TreeSet<Cliente> clientes;
	private boolean abierto;
	
	public Bar(){
		clientes = new TreeSet<Cliente>();
		abierto = false;
	}
	
	public Bar(ComparatorPorEdad comparador){
		clientes = new TreeSet<Cliente>(comparador);
		abierto = false;
	}
	
	public void agregarClientes(Cliente cliente){
		clientes.add(cliente);
	}
	
	public void abrirBar(){
		abierto = true;
	}
	
	public void cerrarBar(){
		abierto = false;
	}
	
	public boolean estado(){
		return abierto;
	}
	
	public TreeSet<Cliente> getClientes(){
		return clientes;
	}
	
}
	
