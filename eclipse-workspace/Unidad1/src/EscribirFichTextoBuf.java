import java.io.*;

public class EscribirFichTextoBuf {
	public static void main(String[] args) {
		try {
			//BufferedWriter fichero = new BufferedWriter(new FileWriter("FichTexto2.txt"));
			PrintWriter fichero = new PrintWriter(new FileWriter("FichTexto2.txt"));
			for (int i = 1; i < 11; i++) {
				//fichero.write("Fila número: " + i); // Escribe una línea
				//fichero.newLine(); // Salto de línea
				fichero.println("Fila número: " + i);
			}
			fichero.close();
		} catch (FileNotFoundException fn) {
			System.out.println("No se encuentra el fichero");
		} catch (IOException e) {
			System.out.println("Error de E/S");
		}
	}
}