import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class insertarRegistro {
	public static void main(String[] args) throws IOException {
		File fichero = new File("AleatorioEmple.dat");
		// Declara el fichero de acceso aleatorio.
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");
		StringBuffer buffer = null; // buffer para almacenar apellido
		String apellido = "Gonzalez"; // Apellido a insertar
		Double salario = 1230.87; // Salario
		int id = 20; // Id del empleado
		int dep = 10; // dep del empleado
//		long posicion = (id - 1) * 36; // Calculamos la posicion
//		file.seek(posicion); // Nos posicionamos
//		file.writeInt(id); // Se escribe el id
//		buffer = new StringBuffer(apellido);
//		buffer.setLength(10); // 10 caracteres para el apellido
//		file.writeChars(buffer.toString()); // insertar el apellido
//		file.writeInt(dep);
//		; // Insertar el departamento
//		file.writeDouble(salario);
//		file.close();
		int registro;
		Double introduceSalario;
		Scanner teclado= new Scanner(System.in);
		System.out.println("Introduce el ID empleado");
		registro=teclado.nextInt();
		
		
		long posicion=(registro-1)*36;
		
		if (posicion >= file.length()) {
			System.out.println("ID: " + registro + ", NO EXISTE EL EMPLEADO...");
		}else {
		System.out.println("Introduce la mejora de salario:");
		introduceSalario=teclado.nextDouble();
		posicion=posicion+4+20+4; //Sumo el tamaño de ID+apellido+departamento
		file.seek(posicion); //Nos posicionamos en el registro
		introduceSalario=file.readDouble()+introduceSalario;
		file.seek(posicion); //Nos posicionamos en el registro
		//file.writeInt(40); //Modificamos departamento
		file.writeDouble(introduceSalario); //Modificamos salario
		}
	}
}
