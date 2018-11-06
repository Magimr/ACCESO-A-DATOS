import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Actividad7 {
	public static void main(String[] args) throws IOException {
		File fichero = new File("AleatorioEmple.dat");
		// Declara el fichero de acceso aleatorio.
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");
		StringBuffer buffer = null; // buffer para almacenar apellido
		int registro;
		Double introduceSalario;
		Scanner teclado= new Scanner(System.in);
		System.out.println("Introduce el ID empleado");
		registro=teclado.nextInt();
		double salarioAnterior;
		
		
		long posicion=(registro-1)*36;
		
		if (posicion >= file.length()) {
			System.out.println("ID: " + registro + ", NO EXISTE EL EMPLEADO...");
		}else {
		System.out.println("Introduce la mejora de salario:");
		introduceSalario=teclado.nextDouble();
		posicion=posicion+4+20+4; //Sumo el tamaño de ID+apellido+departamento
		file.seek(posicion); //Nos posicionamos en el registro
		salarioAnterior=file.readDouble();
		introduceSalario=salarioAnterior+introduceSalario;
		file.seek(posicion); //Nos posicionamos en el registro
		//file.writeInt(40); //Modificamos departamento
		file.writeDouble(introduceSalario); //Modificamos salario
		System.out.println("Apellido: ");
		System.out.println("Salario Anterior: "+salarioAnterior);
		System.out.println("Salario nuevo: "+introduceSalario);
		}
	}
}
