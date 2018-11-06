                import java.io.*;

public class Ej5T1 {
	public static void main(String[] args) throws IOException {
		File fichero = new File("coches.dat");
//Declara el fichero de acceso aleatorio.
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");
//Arrays con los datos.

		int id[] = { 1, 10, 15, 20, 25}; 
		String[] marca = {"Ford","Renault","Ferrari","Lamborghini","Seat"}; 
		String[] modelo= {"Focus","Laguna","Testarrossa","Gallardo","Ibiza"};
		int anyo[]= {2015, 2007, 2010, 2016, 2018};
		StringBuffer buffer = null; 
		StringBuffer buffer2 = null;
		int n = marca.length; 
		for (int i = 0; i < n; i++) { 
			int position = (id[i]-1)*68;
			file.seek(position);
			file.writeInt(id[i]); //id de coche
			buffer = new StringBuffer(marca[i]);
			buffer.setLength(15); //10 Caracteres para la marca
			buffer2 = new StringBuffer(modelo[i]);
			buffer2.setLength(15);//10 Caracteres para el modelo
			file.writeChars(buffer.toString()); //Insertar la marca
			file.writeChars(buffer2.toString()); //Insertar modelo
			file.writeInt(anyo[i]); //Insertar año
			
		}
		file.close();
	}
}