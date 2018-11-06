import java.io.*;

public class EscribirFichTexto {
	public static void main(String[] args) throws IOException {
		File fichero = new File("FichTexto.txt");
		FileWriter fic = new FileWriter(fichero); // crear el flujo de salida.
		String cadena = "Esto es una prueba con FileWriter";
		char[] cad = cadena.toCharArray(); // convierte un String en array de char
		String[] prov = { "Albacete", "Avila", "Badajoz", "Cáceres", "Huelva", "Jaén", "Madrid", "Segovia", "Soria",
				"Toledo", "Valladolid", "Zamora" };
		for (int i = 0; i < prov.length; i++) {
			fic.write(prov[i]);
			fic.write("\r\n");
			
		}

		fic.append('*'); // añado al final un *
		fic.close(); // cerrar el fichero.
		
	}
}