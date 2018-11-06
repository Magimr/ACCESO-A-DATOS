import java.io.*;
import java.util.Scanner;

public class Actividad6 {
	public static void main(String[] args) throws IOException {
		File fichero = new File("AleatorioEmple.dat");
//declara el fichero de acceso aleatorio
		RandomAccessFile file = new RandomAccessFile(fichero, "r");
		int id, dep, posicion;
		int numero = 3;
		Double salario;
		char apellido[] = new char[10], aux;
		posicion = (numero - 1) * 36; // Nos situamos al inicio
//	//	for (;;) {
//			file.seek(posicion); // Nos posicionamos con la variable posicion
//			id = file.readInt(); // obtengo el id de empleado
//			for (int i = 0; i < apellido.length; i++) {
//				apellido[i] = file.readChar();
//				; // Los voy guardando en el array
//			}
//			String apellidoS = new String(apellido); // convierto en string el array
//			dep = file.readInt(); // obtengo dep
//			salario = file.readDouble(); // obtengo el salario
//			System.out.println(
//					"ID: " + id + ", Apellido: " + apellidoS + ",Departamento: " + dep + ", Salario: " + salario);
//			posicion = posicion + 36; // Me posiciono para el siguiente empleado
////Si he recorrido todos los bytes salgo del for
//			//if (file.getFilePointer() == file.length())
//			//	break;
//	//	} // fin del buble for
//		file.close();
		Scanner teclado= new Scanner(System.in);
		int identificador;
		System.out.println("Introduce el ID empleado");
		identificador=teclado.nextInt();
		posicion = (identificador - 1) * 36; // Calculo donde empieza el registro
		if (posicion >= file.length()) {
			System.out.println("ID: " + identificador + ", NO EXISTE EL EMPLEADO...");
		} else {
			file.seek(posicion); // Nos posicionamos en el registro
			id = file.readInt(); // Obtengo id de empleado
			for (int i = 0; i < apellido.length; i++) {
				aux = file.readChar(); // Recorro uno a uno los caracteres del apellido
				apellido[i] = aux; // Los voy guardando en el array
			}
			String apellidoS = new String(apellido); // convierto a String el array
			dep = file.readInt(); // Obtengo dep
			salario = file.readDouble(); // Obtengo el salario
			System.out.println(
					"ID: " + id + ", Apellido: " + apellidoS + ", Departamento: " + dep + ",	Salario: " + salario);
		}
	}
}