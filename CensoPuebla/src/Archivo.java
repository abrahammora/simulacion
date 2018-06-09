import java.io.*;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
public class Archivo {
	private File archivo;
	private String contenido;

	public Archivo(File archivo) {
		this.archivo=archivo;
		this.contenido="";
		LeerArchivo();
	}
	


	public void  LeerArchivo() {
		String linea = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(this.archivo);
			br = new BufferedReader(fr);
			while((linea=br.readLine())!=null) {
				this.contenido+=""+linea+"\n";
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public String getContenido() {
		return this.contenido;
	}
	
	public int getLinea() {
		if(this.contenido.equals(""))
			return 0;
		else
			return this.contenido.split("\n").length;
	}
	
	public String[] getWords() {
		//String pat = "^\n";
		if(this.contenido.equals(""))
			return null;
		else 
			return this.contenido.replaceAll(" ","\n").split("\\s+");
	}

	public String TokenContenido(String contenido) {
		StringTokenizer tokens = new StringTokenizer(contenido,"");
		String cadena="";
		while(tokens.hasMoreTokens()) {
			cadena+=tokens.nextToken();
		}
		return cadena;
		
	}
}
