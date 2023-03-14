package dinosaurio.Calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testDiv()
    {
    	App calcu= new App();
        assertEquals(calcu.div(10, 2), 5.0);
        assertEquals(calcu.div(10, 2), 5.d);
        assertEquals(calcu.div(10, 2), 5.0);
       
    }
    
    public void testSuma()
    {
    	App calcu= new App();
        assertEquals(calcu.suma(10, 2), 12.0);
        assertEquals(calcu.suma(10, 2), 12.d);
        assertEquals(calcu.suma(10, 2), 12.0);
    }
    
    public void testResta()
    {
    	App calcu= new App();
        assertEquals(calcu.resta(10, 2), 8.0);
        assertEquals(calcu.resta(10, 2), 8.d);
        assertEquals(calcu.resta(10, 2), 8.0);
    }
    
    public void testMult()
    {
    	App calcu= new App();
        assertEquals(calcu.mult(10, 2), 20.0);
        assertEquals(calcu.mult(10, 2), 20.d);
        assertEquals(calcu.mult(10, 2), 20.0);
    }
}
