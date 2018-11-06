import java.io.*;

public class EscribirFichTextoBuf {
	public static void main(String[] args) {
		try {
			//BufferedWriter fichero = new BufferedWriter(new FileWriter("FichTexto2.txt"));
			PrintWriter fichero = new PrintWriter(new FileWriter("FichTexto2.txt"));
			for (int i = 1; i < 11; i++) {
				//fichero.write("Fila n�mero: " + i); // Escribe una l�nea
				//fichero.newLine(); // Salto de l�nea
				fichero.println("Fila n�mero: " + i);
			}
			fichero.close();
		} catch (FileNotFoundException fn) {
			System.out.println("No se encuentra el fichero");
		} catch (IOException e) {
			System.out.println("Error de E/S");
		}
	}
}