import java.util.Scanner;
class Main{
				public static void ImprimirTabla(double[] x,double[] fx,int n,double res){
								System.out.println("\tx\t\tfx");
								for(int i=0;i<x.length;i++){
												System.out.println("\tx"+i+" "+String.format("%.3f",x[i])+"\t"+String.format("%.3f",fx[i]));
								}
								System.out.println("El resultado evaluado en "+n+" puntos es: "+String.format("%.4f",res));
				}
				public static void main(String[] args){
						Simpson obj = new Simpson();
						Scanner leer = new Scanner(System.in);
						String x0,xn;

					String opcion;
					while(true){

									System.out.println("¿Qué regla quieres usar?\n1.-Regla Simpson 1/3\n2.-Regla Simpson 3/8\n3.-Regla Compuesta Simpson 1/3\n4.-Regla Compuesta Simpson 3/8");
									System.out.print("Elige una opción:");
									opcion = leer.nextLine();
									System.out.print("Ingresa el valor de x0: ");
									x0 = leer.nextLine();
									System.out.print("Ingresa en valor de xn: ");
									xn = leer.nextLine();
									if(Integer.parseInt(opcion)==1){											
											obj.setn(3);
											double[] aux = obj.valorx(Double.parseDouble(x0),Double.parseDouble(xn),Integer.parseInt(opcion));
											aux[0] = Double.parseDouble(x0);
											aux[aux.length-1] = Double.parseDouble(xn);
											obj.setx(aux);
											double[] auxfx = obj.valorfx();
											obj.setfx(auxfx);
											ImprimirTabla(obj.getx(),obj.getfx(),obj.getn(),obj.SimpsonTercio());

													
									}else if(Integer.parseInt(opcion)==2){
											obj.setn(4);
											double[] aux = obj.valorx(Double.parseDouble(x0),Double.parseDouble(xn),Integer.parseInt(opcion));
											aux[0] = Double.parseDouble(x0);
											aux[aux.length-1] = Double.parseDouble(xn);
											obj.setx(aux);
											double[] auxfx = obj.valorfx();
											obj.setfx(auxfx);
											ImprimirTabla(obj.getx(),obj.getfx(),obj.getn(),obj.SimpsonOctavo());

									}else if(Integer.parseInt(opcion)==3){
											String n;
										do{
												System.out.print("Ingresa la cantidad de puntos a evaluar: ");
												 n = leer.nextLine();
											if(Integer.parseInt(n)%2==0){											
													obj.setn(Integer.parseInt(n)+1);
													double[] aux=obj.valorx(Double.parseDouble(x0),Double.parseDouble(xn),Integer.parseInt(opcion));
													aux[0] = Double.parseDouble(x0);
													aux[aux.length-1] = Double.parseDouble(xn);
													obj.setx(aux);
													double[] auxfx = obj.valorfx();
													obj.setfx(auxfx);
													ImprimirTabla(obj.getx(),obj.getfx(),obj.getn()-1,obj.SimpsonCompuestaTercio());
											}else
												System.out.println("El valor de n debe ser par");
										}while(Integer.parseInt(n)%2!=0);
									}else if(Integer.parseInt(opcion)==4){												
											String n;
											do{
												System.out.print("Ingresa la cantidad de puntos a evaluar: ");
												n = leer.nextLine();
												if(Integer.parseInt(n)%3==0){											
													obj.setn(Integer.parseInt(n)+1);
													double[] aux = obj.valorx(Double.parseDouble(x0),Double.parseDouble(xn),Integer.parseInt(opcion));
													aux[0] = Double.parseDouble(x0);
													aux[aux.length-1] = Double.parseDouble(xn);
													obj.setx(aux);
													double[] auxfx = obj.valorfx();
													obj.setfx(auxfx);
													ImprimirTabla(obj.getx(),obj.getfx(),obj.getn()-1,obj.SimpsonCompuestaOctavo());
											
												}else
													System.out.println("El valor de n debe multiplo de 3");
											}while(Integer.parseInt(n)%3!=0);
									}

					}
				}
}
