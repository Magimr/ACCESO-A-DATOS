import java.io.*;

public class EscribirFichBytes {
	public static void main(String[] args) throws IOException {
		File fichero = new File("FichBytes.dat");
//Creamos el flujo de salida hacia el fichero:
		FileOutputStream fileout = new FileOutputStream(fichero);
//Creamos el flujo de entrada desde el fichero:
		FileInputStream filein = new FileInputStream(fichero);
		int i;
		for (i = 1; i < 100; i++) {
			fileout.write(i); // escribe datos en el flujo de salida.
		}
		fileout.close();
		while ((i = filein.read()) != -1) { // lee datos del flujo de entrada
			System.out.println(i);
		}
		filein.close();
	}
}