import java.io.*;

public class Ej3T1 {
	public static void main(String[] args) throws IOException {
		Departamento departamento;

		File fichero = new File("Departamentos.dat");

		FileOutputStream fileout = new FileOutputStream(fichero);

		ObjectOutputStream dataOS = new ObjectOutputStream(fileout);
		int numeroDepartamento[]= {1,2,3,4};
		String nombre[]= {"nombre 1", "nombre 2", "nombre 3", "nombre 4"};
		String localidad[]= {"localidad 1", "localidad 2", "localidad 3", "localidad 4"};
		for (int i = 0; i < numeroDepartamento.length; i++) {
			departamento = new Departamento(numeroDepartamento[i],nombre[i],localidad[i]); 
			dataOS.writeObject(departamento);
		}
		dataOS.close();
		fileout.close();
	}
}
