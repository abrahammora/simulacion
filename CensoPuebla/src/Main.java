
public class Main {
	public static void main(String[] args) {
		double año[]= {1980,1990,2000,2010};
		double poblacion[] = {817431,1054926,1489763,2384587};
		Lagrange l = new Lagrange(año,poblacion);
		System.out.println("El resultado del censo en el 2008 es: "+l.resultado(3, 2008));
		
	}
}
