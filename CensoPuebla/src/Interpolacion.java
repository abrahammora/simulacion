
public class Interpolacion {
	private double x[];
	private double fx[];
	private double valores[];
	private double valores2[];
	private double valoreD[];
	
	public Interpolacion(double x[],double fx[]) {
		this.x=x;
		this.fx=fx;
		this.valores=new double[x.length];
		this.valores2=new double[x.length];
		this.valoreD = new double[x.length];
	}
	
	public void FormulaLagrange(int n,double X){
		double mul=1,mul2=1,num,den;
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=n;j++) {
				if(j!=i) {					
					num=X-x[j];
					den=x[i]-x[j];
					mul*=(num/den);
					//System.out.println(j+":"+ mul);									
				}				
			}
			mul2=mul*fx[i];
			//System.out.println(mul+"*"+poblacion[i]);
			mul=1;			
			valores[i]=mul2;
			//System.out.println(suma[i]);
		}
		
	}
	
	public double factorial(int n) {
		if(n==0||n==1)
			return 1;
		else
			return n*factorial(n-1);
	}
	public void DiferenciasDivididas(int n) {
		double numerador=fx[1]-fx[0];
		double denominador=x[1]-x[0];
		int i=0;
		while(i<n) {		
			valoreD[i]=Math.pow(numerador, i+1)/(factorial(i+1)*Math.pow(denominador, i+1));
			System.out.println(valoreD[i]);										
			i++;
		} 
		
	}
	
	public void IgualarArreglos(int n,double arr[]) {
		int j=0;
		for(int i=1;i<=n;i++) {
			valores2[j]=arr[i];
			j++;
		}
		
	}
	public void FormulaDiferencias(int n,double X) {
		DiferenciasDivididas(n);
		double mul=1,resta = 1,c;
		double arr[] = new double[x.length];			
		for(int i=0;i<=n;i++) {
			
			//resta=1;
			for(int j=0;j<=i-1;j++) {
				//if(j!=i) {
					resta*=X-x[j];
					//System.out.print("("+X+"-"+x[j]+") = "+resta);
//				}											

					//System.out.print(resta);
			}
			arr[i]=resta;
			
			//System.out.println(resta);
			resta=1;
//			System.out.println(valoreD[i]+"*"+resta);
		}
		

		
		IgualarArreglos(n,arr);
		
	}
	
	public double[] InterNewton(int n) {
		double suma[] =  new double[x.length];
		for(int i=0;i<n;i++) {
			suma[i]=(valoreD[i]*valores2[i]);
		//	System.out.println(valoreD[i]+"*"+valores2[i]);
		}
		return suma;
	}
	public double ResultadoLagrange(int n,double X){
		FormulaLagrange(n, X);
		double resultado=0;
		for(int i=0;i<valores.length;i++) {
			resultado+=valores[i];
		}
		
		return resultado; 
	}

	public double ResultadoDiferencias(int n,double X){
		FormulaDiferencias(n, X);
		double resultado=0,arr[];
		arr=InterNewton(n);
		for(int i=0;i<valores2.length;i++) {
			resultado+=arr[i];

		}
		
		return resultado+fx[0]; 
	}
}
