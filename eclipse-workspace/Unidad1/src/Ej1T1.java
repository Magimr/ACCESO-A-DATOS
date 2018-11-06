import java.io.*;
import java.util.Scanner;

public class Ej1T1 {
	public static void main(String[] args) throws IOException {
		Scanner teclado= new Scanner(System.in);
		File fichero = new File("Biblioteca.xml");
		FileWriter fic = new FileWriter(fichero); 
		
		String titulo="";
		String autor="";
		
		System.out.println("Introduce el titulo: ");
			titulo=teclado.nextLine();
		

		
		System.out.println("Introduce el autor: ");
			autor=teclado.nextLine();
		String libro="<Biblioteca><Libro><Titulo>"+titulo+"</Titulo><Autor>"+autor+"</Autor></Libro></Biblioteca>";		
	
			fic.write(libro);		

		
		fic.close(); 
		
	}
}