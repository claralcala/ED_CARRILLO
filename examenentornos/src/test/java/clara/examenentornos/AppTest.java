package clara.examenentornos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hamcrest.core.IsInstanceOf;
import org.hamcrest.core.IsNot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hamcrest.Matcher;
import org.hamcrest.core.IsInstanceOf;
import org.hamcrest.core.IsNot;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
   
{
	
	 @Test
	    public void testIngresar() throws IngresoNegativoException {
		 	Cuenta c= new Cuenta ("12345", "Pepe");
	        
		 	c.ingresar("Ingreso", 100.0);

	        assertEquals(c.getSaldo(), 100.0);
	   }
	 
	 @Test
	 public void ingresarConExcepcion() {
	        Cuenta cuenta1 = new Cuenta("4534535", "Pepe");
	        double cantidad = -50.0;
	        assertThrows(IngresoNegativoException.class, () -> cuenta1.ingresar("Ingresito", cantidad));
	    
	 }
	
	 @Test
	    public void testRetirar() throws IngresoNegativoException, SaldoInsuficienteException {
		 	Cuenta c2= new Cuenta ("12345", "Pepe");
	        c2.ingresar("Ingreso", 200.0);
		 	c2.retirar("Retirada", 100.0);

	        assertEquals(c2.getSaldo(), 100.0);
	   }
	 
	 @Test
	 public void retirarConExcepcion() throws IngresoNegativoException {
	        Cuenta cuenta2 = new Cuenta("4534535", "Pepe");
	        cuenta2.ingresar("Ing", 200.0);
	        double cantidad = -50.0;
	        assertThrows(IngresoNegativoException.class, () -> cuenta2.retirar("Retirada", cantidad));
	    
	 }
	 
	 @Test 
	 public void retirarExcepcion2() throws IngresoNegativoException {
		 Cuenta cuenta3 = new Cuenta ("2342423", "Luis");
		 cuenta3.ingresar("ingre", 50.0);
		 double cantidad= 100.0;
		 assertThrows(SaldoInsuficienteException.class, () -> cuenta3.retirar("Retirada", cantidad));
		 
	 }
	 @Test
	 public void testCuentaVacia() {
		  Cuenta cc = new Cuenta ("23423", "María");
		
		  assertThat(cc.mMovimientos.size(), hasSize(0));
		  
		  
	  }
	 
	

	@Test
	 public void testCuentaConMovimientos() throws IngresoNegativoException, SaldoInsuficienteException {
		 Cuenta cuen = new Cuenta ("23534", "Pepe");
		 cuen.ingresar("hola", 50.0);
		 cuen.retirar("hola2", 10.0);
		 assertThat2(cuen.mMovimientos.size(), 2);
	 }
	 
	@Test
	public void testPosicion() throws IngresoNegativoException {
		Cuenta cc2= new Cuenta ("123123", "Pepe");
		cc2.ingresar("ingreso", 50.0);
		
		assertThat3("ingreso", cc2.mMovimientos.get(0));
	}
	 
	 @Test
	public void testConcepto() {
		Movimiento mov= new Movimiento();
		mov.setConcepto("Ingreso");
		
		assertThat(mov.getConcepto().equals("Ingreso"), true);
	}
	 
	 
	 
	
	
	
	
	
	
	
	
	
	
	 
	 private void assertThat(boolean equals, boolean b) {
		// TODO Auto-generated method stub
		
	}

	private void assertThat3(String string, Object ingresar) {
		// TODO Auto-generated method stub
		
	}

	private void assertThat2(int size, int i) {
		// TODO Auto-generated method stub
		
	}

	private void assertThat(int size, Matcher<Collection<? extends Object>> hasSize) {
			// TODO Auto-generated method stub
			
		}

	 
    
}
