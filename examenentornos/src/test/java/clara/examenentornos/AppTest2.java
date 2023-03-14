package clara.examenentornos;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.core.IsInstanceOf;
import org.hamcrest.core.IsNot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


import java.util.*;
public class AppTest2 {

	private Empleado empleado;

    
    
    @Test
    public void testPlus_NoAumentaSalario_EdadMenorQue40() {
        Empleado empleado = new Empleado("Juan", "Perez", 30, 1000.0);
        assertFalse(empleado.plus(500.0));
        assertEquals(1000.0, empleado.getSalario());
    }

    @Test
    public void testPlus_AumentaSalario_EdadMayorQue40() {
        Empleado empleado = new Empleado("Maria", "Gomez", 45, 2000.0);
        assertTrue(empleado.plus(500.0));
        assertEquals(2500.0, empleado.getSalario());
    }
    

    @ParameterizedTest
    @ValueSource(doubles = { 100, 200, 300 })
    void testPlus(double sueldoPlus) {
        Empleado e = new Empleado("Juan", "Pérez", 45, 1000);
        double salarioAnterior = e.getSalario();
        boolean resultado = e.plus(sueldoPlus);
        if (e.getEdad() > 40) {
            assertTrue(resultado);
            assertEquals(salarioAnterior + sueldoPlus, e.getSalario());
        } else {
            assertFalse(resultado);
            assertEquals(salarioAnterior, e.getSalario());
        }
    }

    @ParameterizedTest
    @MethodSource("compararEmpleadosProvider")
    void testCompareTo(Empleado e1, Empleado e2, int resultadoEsperado) {
        int resultado = e1.compareTo(e2);
        assertEquals(resultadoEsperado, resultado);
    }

    static Collection<Object[]> compararEmpleadosProvider() {
        Empleado e1 = new Empleado("Juan", "Pérez", 45);
        Empleado e2 = new Empleado("María", "García", 50);
        Empleado e3 = new Empleado("Pedro", "Gómez", 45);
        Empleado e4 = new Empleado("Ana", "López", 40);
        return Arrays.asList(new Object[][] { { e1, e2, Empleado.MENOR }, { e2, e1, Empleado.MAYOR },
                { e1, e3, Empleado.IGUAL }, { e1, e4, Empleado.MENOR }, { e4, e1, Empleado.MAYOR } });
    }

	}

