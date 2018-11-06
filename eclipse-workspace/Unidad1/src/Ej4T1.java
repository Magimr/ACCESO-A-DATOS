import java.io.*;
import java.util.Scanner;

public class Ej4T1 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Scanner teclado = new Scanner(System.in);
		Departamento departamento;
		int n;
		String nombre;
		String localidad;
		ObjectOutputStream dataOS=null;
		FileOutputStream fileoutCopia=null;

		File fichero = new File("Departamentos.dat");
		File ficheroCopia = new File("Ej4T1.dat");


		FileInputStream filein = new FileInputStream(fichero);
		ObjectInputStream dataIS = new ObjectInputStream(filein);
		
		
		
		
		
		
		System.out.println("Introduce el numero de departamento a modificar: ");
		n = teclado.nextInt();
		teclado.nextLine();
		try {
			fileoutCopia= new FileOutputStream(ficheroCopia);
			dataOS = new ObjectOutputStream(fileoutCopia);
			while (true) {
				
				departamento = (Departamento) dataIS.readObject();
				
				if (departamento.getNumero() == n) {

				
					
					System.out.println("Introduce el nuevo nombre: ");
					nombre = teclado.nextLine();
					departamento.setNombre(nombre);

					System.out.println("Introduce la nueva localidad: ");
					localidad = teclado.nextLine();
					departamento.setLocalidad(localidad);

					dataOS.writeObject(departamento);
					
				
				}else {
					dataOS.writeObject(departamento);
					
				}

			}
			
		} catch (EOFException e) {
		}
		dataIS.close();
		dataIS=null;
		if(dataOS!=null) {
		dataOS.close();
		dataOS=null;
		filein.close();
		filein=null;
		teclado.close();
		fileoutCopia.flush();
		fileoutCopia.close();
		fileoutCopia=null;
		System.gc();
		String nombreFichero= fichero.getName();
		System.out.println(fichero.delete());
		System.out.println(ficheroCopia.renameTo(new File(nombreFichero)));
		}
	}
}
