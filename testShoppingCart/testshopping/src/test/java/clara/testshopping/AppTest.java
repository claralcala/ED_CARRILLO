package clara.testshopping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.core.IsInstanceOf;
import org.hamcrest.core.IsNot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


import java.util.*;

public class AppTest {
	ShoppingCart shoppingCart1 = new ShoppingCart();
	ShoppingCart shoppingCart2 = new ShoppingCart();
	ShoppingCart shoppingCart3= new ShoppingCart();
	
	  @Test
	  @DisplayName ("Comprobamos que el carrito de la compra al crearse esté vacío")
	 public void testtestCarritoVacio() {
	    
	    assertEquals(0, shoppingCart1.getItemCount(), "El carrito de la compra debe estar vacío al ser creado");
	  }
	  
	  @Test
	  @DisplayName("Comprobamos que el carrito esté vacío cuando lo vaciamos. Con Hamcrest")
	  public void testvaciarCarrito() {
		  Product prod1 = new Product("manzanas", 23);
		  shoppingCart2.addItem(prod1);
		  shoppingCart2.empty();
		  assertThat2(shoppingCart2.getItemCount(), empty());
		  
	  }
	  
	  @Test
	  @DisplayName("Lo mismo que el anterior pero con JUNIT")
	  public void testvaciarCarritoJUNIT() {
		  Product pr1 = new Product("papas", 23);
		  shoppingCart3.addItem(pr1);
		  shoppingCart3.empty();
		  assertEquals(0, shoppingCart3.getItemCount());
		  
	  }
	  

	@Test
	@DisplayName("Comprobamos que el carrito de la compra tenga 1 item que hemos añadido")
	  public void testAnadir() {
	       
	        Product prod2 = new Product("peras", 4);
	        shoppingCart2.addItem(prod2);
	        assertThat1(shoppingCart2.getItemCount(), hasSize(1));
	        
	    }
	 

	@Test
	@DisplayName("Similar al anterior, pero en vez del tamaño, comprobamos que tenga un producto concreto")
	  public void testTieneProducto() {
		  Product prod3= new Product ("pizza Tarradellas", 2.5);
		  shoppingCart1.addItem(prod3);
		  assertThat(shoppingCart1.getItemCount(), contains(prod3));
	  }
	
	@Test
	@DisplayName("Comprobamos como los anteriores, pero ahora son varios")
	public void testTienevariosProductos() {
		Product queso = new Product ("queso fresco", 2);
		Product patatas = new Product ("Ruffles", 1);
		shoppingCart2.addItem(queso);
		shoppingCart2.addItem(patatas);
		assertThat1(shoppingCart2.getItemCount(), hasSize(2));
	}
	
	@Test
	@DisplayName("Eliminamos 1 producto, comprobamos que tiene tamaño 0 y que no contiene ese producto")
	 public void testQuitarProd() throws ProductNotFoundException {
	        Product huevos = new Product("huevos", 2.5);
	        shoppingCart1.addItem(huevos);
	        shoppingCart1.removeItem(huevos);
	        assertThat1(shoppingCart1.getItemCount(), hasSize(0));
	        assertThat(shoppingCart1.getItemCount(), not(contains(huevos)));
	    }
	
	@Test
	@DisplayName("Similar al anterior")
	public void testQuitarProd2() throws ProductNotFoundException {
		Product prod1= new Product("producto", 3.5);
		Product prod2= new Product("producto2", 2.5);
		shoppingCart1.addItem(prod1);
		shoppingCart1.addItem(prod2);
		shoppingCart1.removeItem(prod1);
		
		assertThat2(shoppingCart1.getItemCount(), hasSize(1));
		assertThat(shoppingCart1.getItemCount(), not(contains(prod1)));
		
		
	}
	
	@Test
	@DisplayName("Comprobamos que la cuenta de productos sea mayor que la cuenta inicial que comprobamos")
	public void testMeterProducto() {
		int cuentaInicial=shoppingCart1.getItemCount();
		Product producto = new Product ("producto", 5.7);
		shoppingCart1.addItem(producto);
		assertTrue(shoppingCart1.getItemCount()>cuentaInicial);
	}
	
	@Test
	@DisplayName("Similar al anterior, pero al revés. Con False")
	public void testMeterProductoFalse() {
		int cuentaInicial=shoppingCart1.getItemCount();
		Product producto = new Product ("producto", 5.7);
		shoppingCart1.addItem(producto);
		assertFalse(shoppingCart1.getItemCount()<cuentaInicial);
	}
	
	@Test
	@DisplayName("Ahora hacemos lo contrario, quitando 1 producto")
	public void testQuitarProductoJUNIT() throws ProductNotFoundException{
		Product prod3 = new Product("producto3", 4.7);
		shoppingCart2.addItem(prod3);
		int cuentaInicial=shoppingCart2.getItemCount();
		shoppingCart2.removeItem(prod3);
		assertTrue(shoppingCart2.getItemCount()<cuentaInicial);
		
		
	}
	
	@Test
	@DisplayName("Similar al anterior, pero devolviendo false")
	public void testQuitarProductoJUNIT2() throws ProductNotFoundException{
		Product prod4 = new Product("producto4", 2.7);
		shoppingCart2.addItem(prod4);
		int cuentaInicial=shoppingCart2.getItemCount();
		shoppingCart2.removeItem(prod4);
		assertFalse(shoppingCart2.getItemCount()>cuentaInicial);
		
		
	}
	
	@Test
	
	public void testEliminarProd() {
		Product prod5= new Product("producto5", 1.3);
		Product prod6 = new Product("pepe", 1.5);
		shoppingCart3.addItem(prod5);
		assertThrows(ProductNotFoundException.class, ()-> {shoppingCart3.removeItem(prod6);});
	}
	
	@Test
	@DisplayName("Comprobamos que el balance esperado coincida con el que tenemos")
	public void testBalance() {
		ShoppingCart shop4= new ShoppingCart();
		Product p1 = new Product("hola", 1.0);
		Product p2 = new Product ("adios", 1.0);
		Product p3 = new Product ("buenas", 1.0);
        shop4.addItem(p1);
        shop4.addItem(p2);
        shop4.addItem(p3);
        double balance = shop4.getBalance();
        assertEquals(3.0, balance);
      
	}
	
	@Test
	@DisplayName("Como el anterior")
	public void testBalance2() {
		ShoppingCart shop5= new ShoppingCart();
		Product p1 = new Product("hola", 10.0);
		Product p2 = new Product ("adios", 10.0);
		Product p3 = new Product ("buenas", 10.0);
        shop5.addItem(p1);
        shop5.addItem(p2);
        shop5.addItem(p3);
        double balance = shop5.getBalance();
        assertEquals(30.0, balance);
      
	}
	
	@Test
	@DisplayName("Como los anteriores, pero comprobamos que un carro nuevo al crearse y sin items tenga balance 0")
	public void testBalance3() {
		ShoppingCart carro1= new ShoppingCart();
		double balance= carro1.getBalance();
		assertEquals(0, balance);
	}
	
	
	private int getProductCount(ShoppingCart c) {
		return c.getItemCount();
	}
	
	
	//Métodos de Hamcrest que se han generado   
	private void assertThat(int itemCount, Matcher<Iterable<? extends Product>> matcher) {
		// TODO Auto-generated method stub
		
	}
	
	 private void assertThat1(int itemCount, Matcher<Collection<? extends Object>> hasSize) {
			// TODO Auto-generated method stub
			
	}
	 
	 private void assertThat2(int itemCount, Matcher<Collection<? extends Object>> empty) {
			// TODO Auto-generated method stub
			
	}
	  
	  
	  
	
    
}
