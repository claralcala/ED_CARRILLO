package clara.testCuentaTarjeta;

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
import java.util.Date;

public class AppTest 
    
{
	Cuenta cuen = new Cuenta("1234", "Pepe");
    Credito credi = new Credito("5678", "Pepe", new Date(), 1000);
    Debito debi = new Debito ("5464", "Pepe", new Date());
	
	@Test
	@DisplayName("En este test comprobamos que salte la excepción cuando ingresamos una cant negativa")
    public void ingresarConExcepcion() {
        Cuenta cuenta1 = new Cuenta("4534535", "Pepe");
        double cantidad = -50.0;
        assertThrows(Exception.class, () -> cuenta1.ingresar(cantidad));
    }
	
	@Test
	@DisplayName("En este test hacemos un ingreso y comprobamos que el número de movimientos de la cuenta es 1")
	public void testNumeroDeMovimientos() throws Exception {
        Cuenta cuenta2 = new Cuenta("2342424", "Luis");
        double cantidad = 500.0;

        cuenta2.ingresar(cantidad);

        assertEquals(1, cuenta2.mMovimientos.size());
       
    }
	
	@Test
	@DisplayName("En este ingresamos 100 euros en la cuenta y comprobamos que el saldo equivale a esos 100")
	public void testIngresarDinero() throws Exception {
        Cuenta cuenta3 = new Cuenta("2342424", "Lola");
        double cantidad = 100.0;

        cuenta3.ingresar(cantidad);

        assertEquals(100.0, cuenta3.getSaldo());
       
    }
	
	@Test
	@DisplayName("Similar al de ingresar, comprobamos que salte excepción al retirar cantidad negativa")
    public void retirarConExcepcion() {
        Cuenta cuenta1 = new Cuenta("4534535", "Pepe");
        double cantidad = -50.0;

        assertThrows(Exception.class, () -> cuenta1.retirar(cantidad));
    }
	
	
	@Test
	@DisplayName("Como el saldo de la cuenta es 0 de base e intentamos retirar 30, comprobamos que salte la excepción")
    public void retirarConExcepcion2() {
        Cuenta cuenta1 = new Cuenta("4534535", "Pepe");
       
        double cantidad = 30;
       

        assertThrows(Exception.class, () -> cuenta1.retirar(cantidad));
    }
	
	@Test
	@DisplayName("En este retiramos 100 euros en la cuenta y comprobamos que el saldo equivale a lo que había menos esos 100")
	public void testRetirarDinero() throws Exception {
        Cuenta cuenta5 = new Cuenta("2342424", "Lola");
        double cantidad = 100.0;

        cuenta5.ingresar(200.0);
        cuenta5.retirar(cantidad);

        assertEquals(100.0, cuenta5.getSaldo());
       
    }
	
	@Test
	public void ingresarConcepto()throws Exception {
		Cuenta c = new Cuenta("2342342", "María");
		c.ingresar("esto es un ingreso", 100);
		
		assertEquals(100, c.getSaldo());
	}
	@Test
	public void retirarConcepto()throws Exception {
		Cuenta c1 = new Cuenta("2342342", "Pepa");
		c1.ingresar("esto es un ingreso", 200);
		c1.retirar("Esto es una retirada", 100);
		
		assertEquals(100, c1.getSaldo());
	}
	
	@Test 
	public void comprobarSaldo() throws Exception {
		Cuenta c2 = new Cuenta ("hola", "adios");
		c2.ingresar(300);
		c2.ingresar(200);
		
		assertEquals(500, c2.getSaldo());
	}
	
	
	
	
	@Test
    public void testRetirarCred() throws Exception {
        credi.retirar(50);
        assertEquals(997.0, credi.getCreditoDisponible(), 0.001);
        

        
    }
	
	@Test
    public void testIngresarCred() throws Exception {
		credi.setCuenta(cuen);
        credi.ingresar(100);
        assertEquals(100, cuen.getSaldo(), 0.001);
        
    }
	
	@Test
    void testPagoEnEstablecimientoCred() throws Exception {
        credi.pagoEnEstablecimiento("Tienda Random", 50);
        assertEquals(50, credi.getSaldo(), 0.001);
        
    }
	
	@Test
    void testLiquidarCred() throws Exception {
		Credito credi2 = new Credito ("6789", "Luis", new Date(), 1000);
		Cuenta cuen2 = new Cuenta("1234", "Luis");
		credi2.setCuenta(cuen2);
        credi2.pagoEnEstablecimiento("Tienda Random 1", 50);
        credi2.pagoEnEstablecimiento("Mercadona", 100);
        credi2.liquidar(2, 2023);
        
       
       
       assertEquals(150.0, credi2.getSaldo(), 0.001);
       }
	
	
	@Test
	public void testConceptoMovimiento() {
		String concepto = "esto es un ingreso";
		Movimiento mov = new Movimiento();
		mov.setConcepto(concepto);
		assertEquals(concepto, mov.getConcepto());
	}
    
	@Test
	public void testFechaMovimiento() {
		Date fecha = new Date();
		Movimiento mov2 = new Movimiento();
		mov2.setFecha(fecha);
		assertEquals(fecha, mov2.getFecha());
	}
	
	@Test
	public void testImporteMovimiento() {
		double importe= 50.0;
		Movimiento mov3 = new Movimiento();
		mov3.setImporte(importe);
		assertEquals(importe, mov3.getImporte());
	}
	
	@Test 
	public void retirarDebito() throws Exception {
		Cuenta cuenta3 = new Cuenta("45343", "Pepe");
		debi.setCuenta(cuenta3);
		cuenta3.ingresar(60);
		debi.retirar(20);
		assertEquals(40.0, debi.getSaldo());
	}
	
	@Test
	public void ingresarDebito() throws Exception {
		Cuenta cuenta4 = new Cuenta("67867", "Luis");
		Debito deb2= new Debito("4564", "Luis", new Date());
		
		deb2.setCuenta(cuenta4);
		cuenta4.ingresar(100);
		//Tenemos que ingresar dinero en la cuenta previamente antes de coger parte de ese dinero para ingresarlo en la tarjeta
		deb2.ingresar(50);
		assertEquals(50, deb2.getSaldo());
		
	}
	
	@Test
	public void pagoEstablecimientoDebito() throws Exception {
		Cuenta cuenta5 = new Cuenta("456456", "José");
		Debito deb3= new Debito("4534", "José", new Date());
		
		deb3.setCuenta(cuenta5);
		cuenta5.ingresar(200);
		deb3.pagoEnEstablecimiento("Pago en el Mercadona", 50);
		
		assertEquals(150, deb3.getSaldo());
		
	}
	
	@Test 
	public void saldoDebito() throws Exception {
		Cuenta cuenta6= new Cuenta("3453", "María");
		Debito deb4 = new Debito("345345", "María", new Date());
		
		deb4.setCuenta(cuenta6);
		
		cuenta6.ingresar(200);
		
		assertEquals(200, deb4.getSaldo());
	}
	
	
}
