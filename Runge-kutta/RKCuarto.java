class RKCuarto{
	private double x[];
	private double fx[];
	private int n;
	private int m;

	public double[] getx(){
		return this.x;
	}
	public double[] getfx(){
		return this.fx;
	}
	public int getn(){
		return this.n;
	}
	public int getm(){
		return this.m;
	}
	public void setm(int m){
		this.m=m;
	}
	public void setn(int n){
		this.n=n;
	}
	public void setx(double[] x){
		this.x=x;
	}
	public void setfx(double[] fx){
		this.fx=fx;
	}

	public double EDO(double x,double y,int op){
		if(op==1) return x * Math.exp(3*x)-2*y;
		else if(op==2) return 1 + Math.pow((x-y),2);
		else if(op==3) return 1 + y/x;
		else if(op==4) return Math.cos(2*x)+Math.sin(3*x); 
		else if(op==5) return Math.exp(x-y);
		else if(op==6) return (1+x)/(1+y);
		else if(op==7) return -y+(x*Math.pow(y,0.5));
		else if(op==8) return Math.pow(x,-2)*(Math.sin(2*x)-(2*x*y));
		else if(op==9) return (y/x)-Math.pow((y/x),2);
		else if(op==10) return 1+(y/x)+Math.pow((y/x),2);
		else if(op==11) return -(y+1)*(y+3);
		else if(op==12) return -5*y+5*Math.pow(x,2)+2*x;

			//return y-Math.pow(x,2)+1;
		
		return 0;
	}
	public double[] EDO2(double x,double[] y){
		double aux[] = new double[y.length+1];
		//if(op==1){
			for(int i=0;i<y.length-1;i++){
				aux[i]=-4*y[i]+3*y[i+1]+6;
				aux[i+1]=-2.4*y[i]+1.6*y[i+1]+3.6;
			}
		//Depredador Presa
		/*for (int i = 0; i < y.length-1; i++) {
			aux[i] = 0.1* x -0.02*x*y[i];
			aux[i+1] = -0.3* y[i] + 0.01*x *y[i+1];
		}*/
		//Ejercicio 
		/*for (int i = 0; i < y.length-1; i++) {
			aux[i] = y[i+1];
			aux[i+1] = Math.exp(2*x)*Math.sin(x)-2*y[i]+2*y[+1];
		}*/
			return aux;
			//return -4*y+3*y+6;
		//}
		//else if(op==2){
		//	for(int i=0;i<y.length;i++){

		//	}
			//return -2.4*y+1.6*y+3.6;
		//	return aux;
		//}

		//return null;
	}

	public double valorh(double a,double b){
		return (b-a)/n;
	}
	public double[] valorx(double a,double b){
		double[] aux = new double[n+1];
		double h = valorh(a,b);
		double auxa =a;
		double suma=0;
//		System.out.println(h);
		for(int i=0;i<=n;i++){			
			aux[i]=auxa;
			auxa+=h;
			
		}
		return aux;
	}
	public double[] RungeKutta(double a,double b,double inity,int op){
		double h = valorh(a,b);
		double[] aux = new double[n+1];
		double k1,k2,k3,k4;		
		aux[0]=inity;
		for(int i=0;i<n;i++){
			k1 = h*EDO(x[i],aux[i],op);
			k2 = h*EDO((x[i]+(h/2)),(aux[i]+(k1/2)),op);
			k3 = h*EDO(x[i]+(h/2),(aux[i]+(k2/2)),op);
			k4 = h*EDO(x[i+1],aux[i]+k3,op);
			aux[i+1]=aux[i]+k1/6+k2/3+k3/3+k4/6;
				
		}
		return aux;
	}
	public double[][] RungeKutta(double a,double b,double[] alfa){
		double h = valorh(a,b);
		double[] k1 = new double[m];
		double[] k2 = new double[m];
		double[] k3 = new double[m];
		double[] k4 = new double[m];
		double[][] aux = new double[n+1][m+1];
		double[] yd = new double[m];
		double[] dydx = new double[m];
		int numF=0;
		for(int i=0;i<m;i++) aux[0][i]=alfa[i];

		for(int i=0;i<n;i++){				
			for(int j=0;j<m;j++)yd[j]=aux[i][j];
			dydx=EDO2(x[i],yd);
			for(int j=0;j<m;j++)k1[j]=h*dydx[j];
						
			for(int j=0;j<m;j++)yd[j]=aux[i][j]+(k1[j]/2);				
			dydx=EDO2(x[i]+(h/2),yd);							
			for(int j=0;j<m;j++)k2[j]=h*dydx[j];
								
			for(int j=0;j<m;j++)yd[j]=aux[i][j]+(k2[j]/2);
			dydx=EDO2(x[i]+(h/2),yd);						
			for(int j=0;j<m;j++)k3[j]=h*dydx[j];
					
			for(int j=0;j<m;j++)yd[j]=aux[i][j]+k3[j];
			dydx=EDO2(x[i+1],yd);			
			for(int j=0;j<m;j++)k4[j]=h*dydx[j];

			for(int j=0;j<m;j++){
				aux[i+1][j]=aux[i][j] + k1[j]/6 + k2[j]/3 + k3[j]/3 + k4[j]/6;
			}
		}
			return aux;
	}
}
