import java.io.*;

public class LeerFichTextoBuf {
	public static void main(String[] args) {
		try {
			BufferedReader fichero = new BufferedReader(new FileReader("LeerFichTexto.java"));
			String linea;
			while ((linea = fichero.readLine()) != null) { // lee una línea
				System.out.println(linea);
			}
			fichero.close();
		} catch (FileNotFoundException fn) {
			System.out.println("No se encuentra el fichero");
		} catch (IOException e) {
			System.out.println("Error de E/S");
		}
	}
}
