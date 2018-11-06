import java.io.*;

public class Actividad5 {
	public static void main(String[] args) throws IOException {
		Musica musica; // Defino la variable persona
//declaramos el fichero
		File fichero = new File("FichMusica.dat");
//crea el flujo de salida
		FileOutputStream fileout = new FileOutputStream(fichero);
//Vinculamos el flujo de bytes con el flujo de datos (objetos)
		ObjectOutputStream dataOS = new ObjectOutputStream(fileout);
		String canciones[]= {"cancion 1", "cancion 2", "cancion 3", "cancion 4"};
		String album[]= {"Album 1", "Album 2", "Album 3", "Album 4"};
		String artistas[]= {"Artista 1", "Artista 2", "Artista 3", "Artista 4"};
		for (int i = 0; i < canciones.length; i++) {
			musica = new Musica(canciones[i],album[i],artistas[i]); // creo la persona.
			dataOS.writeObject(musica); // escribo la persona en el fichero.
		}
		dataOS.close();
	}
}
