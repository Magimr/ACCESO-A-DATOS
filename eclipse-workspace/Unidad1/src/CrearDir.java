import java.io.*;

public class CrearDir {
	public static void main(String[] args) {
		File d = new File("NUEVODIR");
		File f1 = new File(d, "Fichero1.txt");
		File f2 = new File(d, "Fichero2.txt");
		d.mkdir();
		try {
			
			if (f1.createNewFile()) {
				System.out.println("Fichero1 creado correctamente.");
			} else {
				System.out.println("No se ha podido crear el Fichero1");
			}
			if (f2.createNewFile()) {
				System.out.println("Fichero2 creado correctamente.");
			} else {
				System.out.println("No se ha podido crear el Fichero2");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		f1.renameTo(new File(d, "Fichero1nuevo.txt"));
		System.out.println("Comprueba que el Fichero2 existe antes de continuar.");
		System.out.println("Pulsa cualquier tecla para continuar.");
		try {
			System.in.read();
			if (f2.delete()) {
				System.out.println("Fichero2 borrado...");
			} else {
				System.out.println("No se ha podido borrar el fichero2");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
