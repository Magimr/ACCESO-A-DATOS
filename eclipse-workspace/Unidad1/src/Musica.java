import java.io.Serializable;

public class Musica implements Serializable{
	
	private String cancion;
	private String album;
	private String artista;
	
	public Musica(String cancion, String album, String artista) {
		super();
		this.cancion = cancion;
		this.album = album;
		this.artista = artista;
	}
	public String getCancion() {
		return cancion;
	}
	public void setCancion(String cancion) {
		this.cancion = cancion;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista = artista;
	}

}
