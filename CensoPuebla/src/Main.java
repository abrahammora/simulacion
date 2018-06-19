import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Arrays;
public class Main {
	public static void menu() {
		System.out.println("¿Que Metodo Deseas Realizar?");
		System.out.println("1.-Metodo de Lagrange");
		System.out.println("2.-Diferencias Divididas");
	}
	public static String menuArchivos(String[] files) {
		Scanner leer = new Scanner(System.in);
		System.out.println("¿Que archivo quieres usar?");		
		for (int i = 0; i < files.length; i++) {
			if(files[i]!=null) {
				System.out.println(i+1+".-"+files[i]);
				
			}
								
		}
		System.out.print("Elige una opcón:");
		return leer.nextLine();
	}
	public static boolean isNumeric(String cadena){
		try {
			double na=Double.parseDouble(cadena);

		} catch (NumberFormatException na){
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		String opcion;
		Interpolacion metodos =null;		
		String ruta="";				
		File dire = new File("/home/abraham/simulacion/Censo/");		
		String[] ficheros = dire.list();

		int con=0;

		for (int i = 0; i < ficheros.length; i++) {
			if(ficheros[i].contains(".txt") /*&& !ficheros[i].equals("")*/) {	
				//ificherostxt[con]=ficheros[i];
				con++;
			}				
		}			
		String[] ficherostxt=new String[con];
		int con2 =0;
		for (int i = 0; i < ficheros.length; i++) {
			if(ficheros[i].contains(".txt") /*&& !ficheros[i].equals("")*/) {	
				ficherostxt[con2]=ficheros[i];
				con2++;
			}				
		}		
		Archivo archivo=null;		
		LinkedList<File> ListaArchivos = new LinkedList<>();
		/*double[] x1 = {1,2,3};
		double[] fx1 = {0,9,22};
		metodos = new Interpolacion(x1,fx1);
		double[] aux = metodos.DerivTresPuntos(2);
		for(int i=0;i<aux.length;i++){
			System.out.println(aux[i]);
		}*/
		/*double[] x2={1.8,1.9,2.0,2.1,2.2};
		double[] fx2={10.889365,12.703199,14.778112,17.148957,19.855030};
		metodos=new Interpolacion(x2,fx2);
		System.out.println(metodos.DerivCincoPuntos());*/

		Arrays.sort(ficherostxt);
					
		String arr[]=null;
		int n=0;
		while(true) {
			String index = menuArchivos(ficherostxt);
			if(isNumeric(index)){
				if(Integer.parseInt(index)<=ficherostxt.length && Integer.parseInt(index)>0){
					ruta = "/home/abraham/simulacion/Censo/"+ficherostxt[Integer.parseInt(index)-1];
					ListaArchivos.add(new File(ruta));
						
					for (int i = 0; i < ListaArchivos.size(); i++) {
						archivo = new Archivo(ListaArchivos.get(i));
					}

					arr = archivo.getWords();												
					n = Integer.parseInt(arr[0]);
					double x[] = new double[n+1];
					double fx[] = new double[n+1];
					String cadena="";		
					int p=0,c;
					System.out.println("\tx\tf(x)");
					for (int i = 0;i<arr.length; i++) {			
						//cadena+=arr[i];			
						for (int j = i+1; j<arr.length; j++) {
							if(i%2==0 && j<arr.length-1&&p<=n){
								System.out.println("\t"+arr[i+1] +"\t"+arr[j+1]);					
								x[p]=Double.parseDouble(arr[i+1]);
								fx[p]=Double.parseDouble(arr[j+1]);
								p++;
							}								
							break;																		
						}
					}
					metodos = new Interpolacion(x, fx);
					if(Integer.parseInt(index)==3){
						System.out.println(" Resultado de Derivación de 3 puntos");
						System.out.println("\tx\tf(x)\tf'(x)");
							double[] aux = metodos.DerivTresPuntos(n);
							for (int i=0;i<arr.length;i++ ) {
								for (int j=i+1;j<arr.length;j++) {
								 	if(i%2==0 && j<arr.length-1){								 		
								 		System.out.println("\t"+arr[i+1]+"\t"+arr[j+1]+"\t"+aux[i/2]);
								 	}
								 	break;
								}								
							}
							

					}else if(Integer.parseInt(index)==4){
							System.out.println(" Resultado de Derivacion de 5 puntos");
							System.out.println("El resultado de f("+arr[arr.length/2]+") es: "+String.format("%.6f",metodos.DerivCincoPuntos()));

					}else if(Integer.parseInt(index)==5){
									System.out.println(" Resultado Formula del Trapecio");
									System.out.println("El resultado es: "+String.format("%.6f",metodos.FormulaTrapecio()));
					}else if(Integer.parseInt(index)==6){
									System.out.println(" Resultado de Regla de Simpson 1/3");
									System.out.println("El resultado es: "+String.format("%.6f",metodos.SimpsonTercio()));
					}else if(Integer.parseInt(index)==7){
									System.out.println(" Resultado de Regla de Simpson 3/8");
									System.out.println("El resultado es: "+String.format("%.6f",metodos.SimpsonOctavo()));
					}else{						
						menu();
						opcion = leer.nextLine();
						if(isNumeric(opcion)){
							if(Integer.parseInt(opcion)==1) {					
								System.out.println("El resultado de f("+arr[arr.length-1]+") es: "+String.format("%.6f",metodos.ResultadoLagrange(n,Double.parseDouble(arr[arr.length-1]))));
							}else if(Integer.parseInt(opcion)==2) {		
							
								System.out.println("El resultado de f("+arr[arr.length-1]+") es: "+String.format("%.6f",metodos.TablaDiferenciasD(n,Double.parseDouble(arr[arr.length-1]))));
							}else
								System.out.println("Opción Incorrecta");
						}else
							System.out.println("Opción Incorrecta");						
						}

				}
				
			}else
				System.out.println("Opción Incorrecta");
				
			
				
			
		}

		
		
		
		
	/*	Interpolacion l = new Interpolacion(año,poblacion);
		Interpolacion l2 = new Interpolacion(x2,fx2);
		System.out.println("Ao\tPoblacin(ao)(habitantes)");
		for(int i=0;i<año.length;i++) {
			System.out.println(String.format("%.0f",ao[i])+"\t"+String.format("%.0f",poblacion[i]));
			System.out.println("--------------------");
		}
		System.out.println("El resultado del censo en el 2008 es: "+String.format("%.2f",l.ResultadoLagrange(3,2008)));
		System.out.println(String.format("%.6f",l2.ResultadoDiferencias(3,8.4)));
//		l3.DiferenciasDivididas(3);*/
		
		
	}
}
