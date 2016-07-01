package ar.edu.unlam.tp5;


public class Cliente implements Comparable<Cliente>{
	private String nombre;
	private Integer edad;
	
	public Cliente(String nombre, Integer edad){
		this.nombre = nombre;
		this.edad = edad;
	}
	
	
	public String getNombre(){
		return this.nombre;
	}
	
	public Integer getEdad(){
		return this.edad;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object cliente){
		Cliente cli = (Cliente) cliente;
		
		if( this.nombre.equals(cli.getNombre())){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public int compareTo(Cliente cliente) {
		return this.nombre.compareTo(cliente.getNombre());
	}

}
