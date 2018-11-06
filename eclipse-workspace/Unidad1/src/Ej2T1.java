import java.io.*;
import java.util.Scanner;

public class Ej2T1 {
	public static void main(String[] args) throws IOException {
		Scanner teclado= new Scanner(System.in);
		File fichero1;
		File fichero2;
		String texto=null;
		
		
		System.out.println("Introduce el nombre del fichero a copiar: ");
		fichero1= new File("C:\\Users\\Ivan\\eclipse-workspace\\Unidad1\\"+teclado.nextLine());
		FileReader fic = new FileReader(fichero1); 
		
		int i;
		
		System.out.println("Introduce el nombre del fichero donde se va a copiar: ");
		fichero2= new File("C:\\Users\\Ivan\\eclipse-workspace\\Unidad1\\"+teclado.nextLine());
		FileWriter fic2= new FileWriter(fichero2);
		
		while ((i = fic.read()) != -1) { 
		
			fic2.write(i);
		}
		
		
		fic.close();
		fic2.close();
		
	}
}