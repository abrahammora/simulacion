
public class Lagrange {
	private double año[];
	private double poblacion[];
	private double suma[];
	
	public Lagrange(double[] año,double[] poblacion) {
		this.año=año;
		this.poblacion=poblacion;
		this.suma=new double[4];
	}
	
	public void formula(int n,int x) {
		double mul=1,mul2=1,num,den;
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=n;j++) {
				if(j!=i) {					
					num=x-año[j];
					den=año[i]-año[j];
					mul*=(num/den);
					//System.out.println(j+":"+ mul);
					
					
				}				
			}
			mul2=mul*poblacion[i];
			//System.out.println(mul+"*"+poblacion[i]);
			mul=1;
			
			suma[i]=mul2;
			//System.out.println(suma[i]);
		}
		
	}
	
	public double resultado(int n,int x) {
		formula(n,x);
		double resultado=0;
		for(int i=0;i<suma.length;i++) {
			resultado+=suma[i];
		}
		
		return resultado; 
	}
}
