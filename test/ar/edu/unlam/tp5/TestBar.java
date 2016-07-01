package ar.edu.unlam.tp5;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBar {

	
	@Test
	public void queElBarSeAbraSinClientes(){
		Bar homero = new Bar();
		//Verifico que al inicializar el bar se encuentre cerrado
		assertTrue(homero.estado() == false);
		homero.abrirBar();
		//Verifico que el bar se haya abierto correctamente
		assertTrue(homero.estado() == true);
		//Cuento la cantidad de clientes dentro del bar
		assertTrue(homero.getClientes().size() == 0);
	}
	
	@Test
	public void queNoHayaDosClientesConElMismoNombre(){
		Bar moe = new Bar();
		
		Cliente carlos = new Cliente("Carlos", 25);
		Cliente carlitos = new Cliente("Carlos", 32);
		
		moe.agregarClientes(carlos);
		moe.agregarClientes(carlitos);
		/*como los 2 que ingresaron tienen el mismo nombre,
		solamente tuvo que haber dejado entrar a 1 */
		assertTrue(moe.getClientes().size() == 1);
	}
	
	@Test
	public void QueLosClientesEstenOrdenadosAlfabeticamente() {
		Bar homero = new Bar();
		Cliente ramon = new Cliente("Ramon", 32);
		Cliente pedro = new Cliente("Pedro", 21);
		Cliente sandra = new Cliente("Sandra", 19);
		Cliente eduardo = new Cliente("Eduardo", 36);
		homero.agregarClientes(ramon);
		homero.agregarClientes(pedro);
		homero.agregarClientes(sandra);
		homero.agregarClientes(eduardo);
		
		assertEquals("Eduardo", homero.getClientes().first().getNombre());
		/*Como al treeset no se puede acceder a su informacion
		  a traves del indice (como si fuera un array comun y corriente)
		  verifico que el primero sea el correcto con un assert,
		  el resto lo verifico por consola
		 */
		for (Cliente cli : homero.getClientes()){
			System.out.println(cli.getNombre());
		}
	}
	
	@Test
	public void QueLosClientesSePuedanCompararAunqueNoEstenEnElBar(){
		Bar homero = new Bar ();
		Cliente ramiro = new Cliente("Ramiro", 22);
		Cliente rama = new Cliente("Ramiro", 25);
		homero.agregarClientes(ramiro);
		assertTrue(ramiro.equals(rama));
	}

}
	
