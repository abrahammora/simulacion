
import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
public class Main {
	public static void menu() {
		System.out.println("�Que Metodo Deseas Realizar?");
		System.out.println("1.-Metodo de Lagrange");
		System.out.println("2.-Diferencias Divididas");
	}
	public static String menuArchivos(String[] files) {
		Scanner leer = new Scanner(System.in);
		System.out.println("�Que archivo quieres usar?");		
		for (int i = 0; i < files.length; i++) {
			if(files[i]!=null) {
				System.out.println(i+1+".-"+files[i]);
				
			}
								
		}	
		return leer.nextLine();
	}
	
	
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		String opcion;
		Interpolacion metodos;		
		String ruta;				
		File dire = new File("C:\\Users\\abraham\\eclipse-workspace\\CensoPuebla\\src");		
		String[] ficheros = dire.list();
		String[] ficherostxt=new String[ficheros.length];
		int con=0;
		for (int i = 0; i < ficheros.length; i++) {
			if(ficheros[i].contains(".txt") && ficheros[i]!=null) {	
				ficherostxt[con]=ficheros[i];
				con++;
			}				
		}			
		Archivo archivo=null;		
		LinkedList<File> ListaArchivos = new LinkedList<>();
	
	
		
	
		while(true) {
			ruta = "C:\\Users\\abraham\\eclipse-workspace\\CensoPuebla\\src\\"+ficherostxt[Integer.parseInt(menuArchivos(ficherostxt))-1];
			ListaArchivos.add(new File(ruta));
			
			for (int i = 0; i < ListaArchivos.size(); i++) {
				archivo = new Archivo(ListaArchivos.get(i));
			}
			
			String arr[] = archivo.getWords();
			int n = Integer.parseInt(arr[0]);

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
			}
			metodos = new Interpolacion(x, fx); 
			menu();
			opcion = leer.nextLine();
			if(Integer.parseInt(opcion)==1) {					
				System.out.println("El resultado de f("+arr[arr.length-1]+") es: "+String.format("%.6f",metodos.ResultadoLagrange(n,Double.parseDouble(arr[arr.length-1]))));
			}else if(Integer.parseInt(opcion)==2) {		
				
				System.out.println("El resultado de f("+arr[arr.length-1]+") es: "+String.format("%.6f",metodos.TablaDiferenciasD(n,Double.parseDouble(arr[arr.length-1]))));
			}
			
		}

		
		
		
		
	/*	Interpolacion l = new Interpolacion(a�o,poblacion);
		Interpolacion l2 = new Interpolacion(x2,fx2);

		System.out.println("A�o\tPoblaci�n(a�o)(habitantes)");
		for(int i=0;i<a�o.length;i++) {
			System.out.println(String.format("%.0f",a�o[i])+"\t"+String.format("%.0f",poblacion[i]));
			System.out.println("--------------------");

		}
		System.out.println("El resultado del censo en el 2008 es: "+String.format("%.2f",l.ResultadoLagrange(3,2008)));
		System.out.println(String.format("%.6f",l2.ResultadoDiferencias(3,8.4)));
//		l3.DiferenciasDivididas(3);*/
		
		
	}
}
