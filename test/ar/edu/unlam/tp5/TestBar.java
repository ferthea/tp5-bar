package ar.edu.unlam.tp5;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBar {

	
	@Test
	public void QueElBarSeAbraSinClientes(){
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
	public void QueNoHayaDosClientesConElMismoNombre(){
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
		
		/*Como a los TreeSet no se pueden acceder a mediante indices (como
		 * si fueran arrays comunes y corrientes), hay 2 metodos: first() y last()
		 * que devuelven el primer elemento y el ultimo respectivamente.
		 * Por lo tanto verifico que el primer y ultimo elemento sean los que deben ser.
		 */
		
		assertEquals("Eduardo", homero.getClientes().first().getNombre());
		assertEquals("Sandra", homero.getClientes().last().getNombre());
	}
	
	@Test
	public void QueLosClientesSePuedanCompararAunqueNoEstenEnElBar(){
		Bar homero = new Bar ();
		Cliente ramiro = new Cliente("Ramiro", 22);
		Cliente rama = new Cliente("Ramiro", 25);
		Cliente edu = new Cliente("Eduardo", 25);
		homero.agregarClientes(ramiro);
		
		Cliente unicoClienteDentroDelBar = homero.getClientes().first();
		
		/* Ingreso un solo cliente al bar y lo comparo con otro que no haya ingresado.
		   Como tienen el mismo nombre, tiene que devolver 0
		   es decir, son iguales*/
		assertEquals(0, unicoClienteDentroDelBar.compareTo(rama));
		
		/*Como Ramiro es "mayor" alfabeticamente (Es decir, empieza con R y eduardo con E)
		  tiene que devolver un numero mayor a 0*/
		assertTrue (ramiro.compareTo(edu) > 0);
	}
	
	@Test
	public void QueLosClientesEstenOrdenadosPorEdad(){
		ComparatorPorEdad comparador = new ComparatorPorEdad();
		Bar homero = new Bar (comparador);
		Cliente ramon = new Cliente("Ramon", 32);
		Cliente pedro = new Cliente("Pedro", 21);
		Cliente sandra = new Cliente("Sandra", 19);
		Cliente eduardo = new Cliente("Eduardo", 36);
		homero.agregarClientes(ramon);
		homero.agregarClientes(pedro);
		homero.agregarClientes(sandra);
		homero.agregarClientes(eduardo);
		
		//Como hice con el otro test, verifico que el primer y ultimo elemento sean los correctos.
		assertEquals("Sandra", homero.getClientes().first().getNombre());
		assertEquals("Eduardo", homero.getClientes().last().getNombre());
	}

}
	
