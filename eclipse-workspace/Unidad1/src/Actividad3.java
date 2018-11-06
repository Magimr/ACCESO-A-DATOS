import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Actividad3 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Boolean enc = false;
		try {
			String lineaIntroducida = "";
			PrintWriter fichero = new PrintWriter(new FileWriter("FichTexto2.txt"));

			do {

				lineaIntroducida = "";
				System.out.println("Introduce una frase. (Introduce 'Salir' para parar)");
				lineaIntroducida = teclado.nextLine();

				if (lineaIntroducida.equals("Salir") || lineaIntroducida.equals("salir")) {
					enc = true;
				} else {
					fichero.println(lineaIntroducida);
				}

			} while (enc != true);

			fichero.close();
		} catch (FileNotFoundException fn) {
			System.out.println("No se encuentra el fichero");
		} catch (IOException e) {
			System.out.println("Error de E/S");
		}
	}
}