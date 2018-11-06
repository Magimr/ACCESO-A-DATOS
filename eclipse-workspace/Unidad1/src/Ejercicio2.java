import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) throws IOException {
		Scanner teclado = new Scanner(System.in);
		String directorio = "C:\\Users\\Ivan\\Desktop";
		System.out.println("Introduce el fichero que deseas leer: ");
		File fichero = new File(directorio, teclado.nextLine());
		FileReader fic = new FileReader(fichero);
		int i;
		while ((i = fic.read()) != -1) {
			System.out.print((char) i);
		}
		fic.close();

	}
}