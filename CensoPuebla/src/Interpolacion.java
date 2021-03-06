
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
	public double[] getx(){
					return this.x;
	}
	public double[] getfx(){
					return this.fx;
	}

	public double[] DerivTresPuntos(int n){
		double aux[] = new double[n];
		double v1=0,v2=0,v3=0,suma=0;
			for(int j=0;j<=n;j++){
					v1=((2*x[j]-x[1]-x[2])/(x[0]-x[1])*(x[0]-x[2]))*fx[0];
					v2=((2*x[j]-x[0]-x[2])/(x[1]-x[0])*(x[1]-x[2]))*fx[1];
					v3=((2*x[j]-x[0]-x[1])/(x[2]-x[0])*(x[2]-x[1]))*fx[2];
					suma+=(v1+v2+v3);					
					valores[j]=suma;
					suma=0;
	}
		return valores;
	}
	public double DerivCincoPuntos(){
					double h=x[1]-x[0];
					return (1/(12*h))*(fx[0]-8*(fx[1])+8*(fx[3])-fx[4]);
	}
	public double FormulaTrapecio(){
				return (x[1]-x[0])*((fx[0]+fx[1])/2);
	}					
	public double SimpsonTercio(){
				double h = x[1]-x[0];
				return (h/3)*(fx[0]+4*fx[1]+fx[2]);
	}
	public double SimpsonOctavo(){
				double h = (x[3]-x[0])/3;
				return ((3*h)/8)*(fx[0]+3*fx[1]+3*fx[2]+fx[3]);
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
	
	public double TablaDiferenciasD(int n,double X) {
		double tabla[][] = new double[x.length][x.length];	
			for(int j=0;j<tabla.length;j++) {						
				tabla[j][0]=fx[j];

			}
			
		 int p;
	        for (int k=0; k<=n-1;k++){
	        	p=0;
	       		for(int i=k+1;i<=n;i++){
	            		tabla[i][k+1]=(tabla[i][k]-tabla[i-1][k])/(x[i]-x[p]);
	        		p++;
	       		}
	        }
	   
        double p1=0;
    	double aux;
            for(int s=0;s<=n;s++){
            	 aux=1;
                    for(int c=0;c<s;c++){
                    	aux=aux*(X-x[c]);
                    }
                    p1=p1+(tabla[s][s]*aux);
            }
       return p1; 
	}
	public void DiferenciasDivididas(int n) {
		double numerador=fx[1]-fx[0];
		double denominador=x[1]-x[0];
		double diferencias[] = new double[n];
		int i=0;
		while(i<n) {		
			valoreD[i]=Math.pow(numerador, i+1)/(factorial(i+1)*(Math.pow(denominador, i+1)));
			//System.out.println(valoreD[i]);
			i++;
		} 
		
		/*for(i=0;i<n-1;i++) {			
			for(int j=i+1;j<n;j++) {
				//System.out.print("  "+fx[j+i]+"-"+fx[i-1+j]+"/"+x[j+i]+"-"+x[i-1+j]);
				diferencias[j]=(fx[j+i]-fx[i-1+j])/(x[j+i]-x[i-1+j]);
				System.out.println(diferencias[j]);
				
			}
			//System.out.println();
		}*/
		//valoreD=diferencias;
		
		
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
				//	System.out.print("("+X+"-"+x[j]+") = "+resta);
//				}											

					//System.out.print(resta);
			}
			arr[i]=resta;
			
			//System.out.println();
			resta=1;
//			System.out.println(valoreD[i]+"*"+resta);
		}
		

		
		IgualarArreglos(n,arr);
		
	}
	
	public double[] InterNewton(int n) {
		double suma[] =  new double[x.length];
		for(int i=0;i<n;i++) {
			suma[i]=(valoreD[i]*valores2[i]);
			//System.out.println(valoreD[i]+"*"+valores2[i]);
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
		double resultado=0,arr[] =  new double[n];
		arr=InterNewton(n);
		for(int i=0;i<valores2.length;i++) {
			resultado+=arr[i];

		}
		
		return resultado+fx[0]; 
	}
}
