import java.io.File;

public class VerInf {
	public static void main(String[] args) {
		String directorio="C:\\Users\\Ivan\\eclipse-workspace\\Unidad1\\src";
		File f = new File(directorio,"VerInf.java");
		System.out.println("INFORMACIÓN SOBRE EL FICHERO:");
		if (f.exists()) {
			System.out.println("Nombre del fichero: " + f.getName());
			System.out.println("Ruta absoluta: " + f.getAbsolutePath());
			System.out.println("Se puede leer: " + f.canRead());
		}
	}
}
