
import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
public class Main {
	public static void menu() {
		System.out.println("¿Que Metodo Deseas Realizar?");
		System.out.println("1.-Metodo de Lagrange");
		System.out.println("2.-Diferencias Divididas");
	}
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		String opcion;
		Interpolacion metodos;
		double año[]= {1980,1990,2000,2010};
		double poblacion[] = {817431,1054926,1489763,2384587};
		double x2[]= {8.1,8.3,8.6,8.7};
		double fx2[]= {16.94410,17.56492,18.50515,18.82091};
		String valor1 = null,valor2;
		String ruta = "C:\\Users\\abraham\\eclipse-workspace\\CensoPuebla\\src\\censo.txt";
		Archivo archivo=null;
		LinkedList<File> ListaArchivos = new LinkedList<>();
		ListaArchivos.add(new File(ruta));
		for (int i = 0; i < ListaArchivos.size(); i++) {
			archivo = new Archivo(ListaArchivos.get(i));
		}
		String arr[] = archivo.getWords();
		int n = Integer.parseInt(arr[0]);
//		System.out.println(arr[arr.length-1]);
		double x[] = new double[n+1];
		double fx[] = new double[n+1];
		String cadena="";		
		int p=0,c;
		for (int i = 0;i<arr.length; i++) {			
			//cadena+=arr[i];
			
			for (int j = i+1; j<arr.length; j++) {
				if(i%2==0 && j<arr.length-1&&p<=n){
					//System.out.println(arr[i+1] +" : "+arr[j+1]);					
					x[p]=Double.parseDouble(arr[i+1]);
					fx[p]=Double.parseDouble(arr[j+1]);
					p++;
				}
					
				break;												
				
			}
		//	p++;
		}
		metodos = new Interpolacion(x, fx); 
		while(true) {
			
			menu();
			opcion = leer.nextLine();
			if(Integer.parseInt(opcion)==1) {

				System.out.println("El resultado del censo en el 2008 es: "+String.format("%.2f",metodos.ResultadoLagrange(n,Double.parseDouble(arr[arr.length-1]))));
			}else if(Integer.parseInt(opcion)==2) {
				System.out.println(String.format("%.6f",metodos.ResultadoDiferencias(n,Double.parseDouble(arr[arr.length-1]))));
			}
			
		}

		
		
		
		
	/*	Interpolacion l = new Interpolacion(año,poblacion);
		Interpolacion l2 = new Interpolacion(x2,fx2);

		System.out.println("Año\tPoblación(año)(habitantes)");
		for(int i=0;i<año.length;i++) {
			System.out.println(String.format("%.0f",año[i])+"\t"+String.format("%.0f",poblacion[i]));
			System.out.println("--------------------");

		}
		System.out.println("El resultado del censo en el 2008 es: "+String.format("%.2f",l.ResultadoLagrange(3,2008)));
		System.out.println(String.format("%.6f",l2.ResultadoDiferencias(3,8.4)));
//		l3.DiferenciasDivididas(3);*/
		
		
	}
}
