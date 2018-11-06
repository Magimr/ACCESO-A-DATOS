import java.io.*;
import java.util.Scanner;


public class ejemplo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado=new Scanner(System.in);
		
		System.out.println("Introduce un directorio");
		File f= new File(teclado.nextLine());	
		
		String[] archivos= f.list();
	
		
/*		for(int i=0;i<archivos.length;i++) {
			System.out.println(archivos[i]);
		}*/
		if(archivos!=null) {
			for(String frase:archivos) {
			
				System.out.println(frase);
			}
		}
	}

}
