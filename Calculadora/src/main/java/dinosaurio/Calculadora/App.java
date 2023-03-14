package dinosaurio.Calculadora;


public class App 
{
    public static void main( String[] args )
    {
       double num1=4;
       double num2=6;
       System.out.println("La suma es " +suma(num1, num2));
       System.out.println("La resta es " +resta (num1, num2));
       System.out.println("La multiplicación es " +mult (num1, num2));
       System.out.println("La división es " +div (num1, num2));
    }
    public static double suma(double pepe, double hola) {
		double suma= pepe+hola;
		return suma;
	}
    
    public static double resta(double pepe, double hola) {
		double resta= pepe-hola;
		return resta;
    }
    public static double mult(double pepe, double hola) {
		double mult= pepe*hola;
		return mult;
    }
    public static double div(double pepe, double hola) {
		double div= pepe/hola;
		return div;
    }
}
