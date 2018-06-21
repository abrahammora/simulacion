import java.util.Scanner;
class Main{
				public static void main(String[] args){
						Simpson obj = new Simpson();
						Scanner leer = new Scanner(System.in);
						String x0,xn;

					String opcion;
					while(true){

									System.out.println("¿Qué regla quieres usar?\n1.-Regla Simpson 1/3\n2.-Regla Simpson 3/8\n3.-Regla Compuesta Simpson 1/3");
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
											System.out.println("\tx\tfx");
											for(int i=0;i<auxfx.length;i++){
												System.out.println("\t"+aux[i]+"\t"+auxfx[i]);
											}
											System.out.println("El resultado evaluado en 3 puntos es: "+obj.SimpsonTercio());
													
									}else if(Integer.parseInt(opcion)==2){
											obj.setn(4);
											double[] aux = obj.valorx(Double.parseDouble(x0),Double.parseDouble(xn),Integer.parseInt(opcion));
											aux[0] = Double.parseDouble(x0);
											aux[aux.length-1] = Double.parseDouble(xn);
											obj.setx(aux);
											double[] auxfx = obj.valorfx();
											obj.setfx(auxfx);
											System.out.println("\tx\tfx");
											for(int i=0;i<auxfx.length;i++){
												System.out.println("\t"+aux[i]+"\t"+auxfx[i]);
											}
											System.out.println("El resultado evaluado en 4 puntos es: "+obj.SimpsonOctavo());
									}else if(Integer.parseInt(opcion)==3){

											System.out.print("Ingresa la cantidad de puntos a evaluar: ");
											String n = leer.nextLine();
											if(Integer.parseInt(n)%2==0){											
												obj.setn(Integer.parseInt(n));
												double[] aux = obj.valorx(Double.parseDouble(x0),Double.parseDouble(xn),Integer.parseInt(opcion));
												aux[0] = Double.parseDouble(x0);
												aux[aux.length-1] = Double.parseDouble(xn);
												obj.setx(aux);
												double[] auxfx = obj.valorfx();
												obj.setfx(auxfx);
												System.out.println("\tx\tfx");
												for(int i=0;i<auxfx.length;i++){
													System.out.println("\t"+aux[i]+"\t"+auxfx[i]);
												}
												System.out.println("El resultado evaluado en "+n+" puntos es: "+obj.SimpsonCompuesta());
										}else
												System.out.println("El valor de n debe ser par");
									}

					}
				}
}
