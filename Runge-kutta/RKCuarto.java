class RKCuarto{
	private double x[];
	private double fx[];
	private int n;

	public double[] getx(){
		return this.x;
	}
	public double[] getfx(){
		return this.fx;
	}
	public int getn(){
		return this.n;
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

	public double valorh(double a,double b){
		return (b-a)/n;
	}
	public double[] valorx(double a,double b){
		double[] aux = new double[n+1];
		double h = valorh(a,b);
		double auxa =a;
		double suma=0;
		System.out.println(h);
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
			aux[i+1]=aux[i]+(k1+(2*k2)+(2*k3)+k4)/6;
				
		}
		return aux;
	}
}
