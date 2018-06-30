import java.util.Scanner;
class Main{
	public static String menuFunciones(){
		Scanner leer = new Scanner(System.in);
		System.out.println("¿Cual funcion deseas evaluar?");
		System.out.println("1: y'= te^(3t)-2y\n2: y'= 1+(t-y)^2\n3: y'= 1+y/t\n4: y'= cos(2t)+sin(3t)");
		System.out.println("5: y'= e^(t-y)\n6: y'= (1+t)/(1+y)\n7: y'= -y+ty^(1/2)\n8: y'= t^(-2)(sin(2t)-2ty)");
		System.out.println("9: y'= y/t-(y/t)^2\n10: y'= 1+y/t+(y/t)^2\n11: y'=-(y+1)(y+3)\n12: y'= -5y+5t^2+2t");
		System.out.print("Elige una opcion:");
		return leer.nextLine();

			
	}
	public static void main(String[] args){
		Scanner leer = new Scanner(System.in);
		RKCuarto obj = new RKCuarto();
		obj.setn(10);
		obj.setm(2);
		double[] alfa ={0,0};
		double[] aux =obj.valorx(0,1);

		obj.setx(aux);
		/*for(int i=0;i<aux.length;i++){
			System.out.println(String.format("%.3f",aux[i]));
		}*/
		double[][] aux2 = obj.RungeKutta(0,1,alfa);
		System.out.println("t\tw1\t\tw2");
		for(int i=0;i<aux.length;i++){
			System.out.print(String.format("%.3f",aux[i])+"\t");
			for(int j=0;j<obj.getm();j++){
				System.out.print(aux2[i][j]+"\t");
			}
			System.out.println();
		}
		/*String n,a,b,y;	
		String opF = menuFunciones();
		System.out.print("Ingresa el intervalo a:");
		a=leer.nextLine();	
		System.out.print("Ingresa el intervalo b:");
		b=leer.nextLine();
		System.out.print("Ingresa la condición inicial para y("+a+"):");
		y=leer.nextLine();
		System.out.print("Ingresa el numero de particiones:");
		n=leer.nextLine();		
		obj.setn(Integer.parseInt(n));
		double[] aux =obj.valorx(Double.parseDouble(a),Double.parseDouble(b));
	 	//aux[aux.length-1]=2;
		obj.setx(aux);
		double[] aux2 = obj.RungeKutta(Double.parseDouble(a),Double.parseDouble(b),Double.parseDouble(y),Integer.parseInt(opF));
		obj.setfx(aux2);
		double[] fx = obj.getfx();
		
		for(int i=0;i<aux.length;i++){
			System.out.println(String.format("%.3f",aux[i])+" "+fx[i]);
		}*/
	}
}
