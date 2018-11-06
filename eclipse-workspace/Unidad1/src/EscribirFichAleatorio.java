import java.io.*;

public class EscribirFichAleatorio {
	public static void main(String[] args) throws IOException {
		File fichero = new File("AleatorioEmple.dat");
//Declara el fichero de acceso aleatorio.
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");
//Arrays con los datos.
		String apellido[] = { "Fernandez", "Gil", "Lopez", "Ramos", "Sevilla", "Casilla", "Rey" }; // apellidos
		int dep[] = { 10, 20, 10, 10, 30, 30, 20 }; // Departamentos
		Double[] salario = { 1000.45, 2400.60, 3000.0, 1500.56, 2200.0, 1435.87, 2000.0 }; // Salarios
		StringBuffer buffer = null; // Buffer para almacenar apellido
		int n = apellido.length; // numero de elementos del array
		for (int i = 0; i < n; i++) { // Recorro el array
			file.writeInt(i + 1); // Uso i+1 para identificar empleado
			buffer = new StringBuffer(apellido[i]);
			buffer.setLength(10); // 10 Caracteres para el apellido
			file.writeChars(buffer.toString()); // Insertar apellido
			file.writeInt(dep[i]); // Insertar departamento
			file.writeDouble(salario[i]); // Insertar salario
		}
		file.close();
	}
}