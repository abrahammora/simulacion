
public class Main {
	public static void main(String[] args) {
		double a�o[]= {1980,1990,2000,2010};
		double poblacion[] = {817431,1054926,1489763,2384587};
		Lagrange l = new Lagrange(a�o,poblacion);
		System.out.println("El resultado del censo en el 2008 es: "+l.resultado(3, 2008));
		
	}
}
