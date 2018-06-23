class Simpson{
				private double x[];
				private double fx[];
				private double h;
				private int n;
				public double[] getx(){
								return this.x;
				}
				public double[] getfx(){
								return this.fx;
				}
				public void setx(double[] x){
								this.x=x;								
				}
				public void setn(int n){
								this.n=n;
				}
				public int getn(){
							return this.n;
				}
				public void setfx(double[] fx){
								this.fx=fx;
				}
				public double geth(){
						return this.h;
				}
				public void seth(double h){
								this.h=h;
				}
				public double polinomio(double x){
						return Math.pow(x,2)+5*x-3;
						//return Math.exp(-Math.pow(x,2));
//						return (1.25*Math.sin(x/2)) + 3;
				}
				public void valorh(double x0,double xn){
						h = (xn-x0)/(n-1);
				}
				public double[] valorx(double x0,double xn,int index){
						double[] aux = new double[n];
						if(index == 1){
								aux[1] = (x0+xn)/2;
						}else if(index == 2){
							 	h = (xn-x0)/3;
								aux[1]=(x0+h);
								aux[2]=x0+(2*h);
						}else if(index ==3 || index ==4){
							valorh(x0,xn);

							for(int i=1;i<n;i++){												
									aux[i]=x0+i*h;
							}
						}
						return aux;
				}
				public double[] valorfx(){
						double[] aux = new double[x.length];
						for(int i=0;i<aux.length;i++){
								aux[i]=polinomio(x[i]);
						}
						return aux;
				}
				public double SimpsonCompuestaTercio(){
						double suma=0,suma2=0;
						for(int i=1;i<=n-1;i+=2){							
									suma+=fx[i];								
								//System.out.println(suma);
						}

						for(int i=2;i<n-2;i+=2){
							suma2+=fx[i];
							//System.out.println(suma2);
						}
						
						//System.out.println(h+":"+n);
						return (h/3)*(fx[0]+fx[fx.length-1]+(4*suma)+(2*suma2));
				}
				public double SimpsonCompuestaOctavo(){
						double suma=0,suma2=0;
							for(int i=1;i<=n-2;i+=3){	
									suma+=(fx[i]+fx[i+1]);
							}
							for(int i=3;i<n-3;i+=3){
									suma2+=fx[i];
							}
							//System.out.println(3*h/8+"["+fx[0]+"+"+fx[fx.length-1]+"+3("+suma+")2("+suma2+")]");
					return ((3*h)/8)*(fx[0]+fx[fx.length-1]+(3*suma)+(2*suma2));
				}
				public double SimpsonTercio(){
						double h = x[1]-x[0];
						return (h/3)*(fx[0]+4*fx[1]+fx[2]);
				}
				public double SimpsonOctavo(){
						double	h = (x[3]-x[0])/3;
						return ((3*h)/8)*(fx[0]+3*fx[1]+3*fx[2]+fx[3]);
				}

}
