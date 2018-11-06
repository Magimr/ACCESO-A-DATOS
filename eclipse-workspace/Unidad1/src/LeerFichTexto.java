import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichTexto {
	public static void main(String[] args) throws IOException {

		File fichero = new File("C:\\Users\\Ivan\\eclipse-workspace\\Unidad1\\src\\LeerFichTexto.java");
		FileReader fic = new FileReader(fichero); 
		char b[]=new char[20];
		int i;
		while ((i = fic.read(b)) != -1) { 
			System.out.print(b);
		}
		fic.close(); 
	
	}
}