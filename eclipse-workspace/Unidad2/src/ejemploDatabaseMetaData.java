import java.sql.*;

public class ejemploDatabaseMetaData {
	public static void main(String[] args) {
		try {
//Cargamos el driver
			Class.forName("com.mysql.cj.jdbc.Driver");
//Establecemos conexion con la BBDD
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/acceso?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"ivan", "tameformacion");
			DatabaseMetaData dbmd = conexion.getMetaData(); // Creamos el objeto DatabaseMetaData
			ResultSet resul = null;
			String nombre = dbmd.getDatabaseProductName();
			String driver = dbmd.getDriverName();
			String url = dbmd.getURL();
			String usuario = dbmd.getUserName();
			System.out.println("INFORMACIÓN SOBRE LA BBDD");
			System.out.println("=========================");
			System.out.println("Nombre: " + nombre);
			System.out.println("Driver: " + driver);
			System.out.println("URL: " + url);
			System.out.println("Usuario: " + usuario);
//Obtener información de las tablasa y vistas que existen
			resul = dbmd.getTables("acceso", null , null, null);
			while (resul.next()) {
				String catalogo = resul.getString(1); // Columna 1
				String esquema = resul.getString(2); // Columna 2
				String tabla = resul.getString(3); // Columna 3
				String tipo = resul.getString(4); // Columna 4
				System.out.println(tipo + " - Catálogo: " + catalogo + " , Esquema:" + esquema + " ,Nombre: " + tabla);
			}

//Cerramos conexión
			conexion.close();
		} catch (ClassNotFoundException e) {
		} catch (SQLException sql) {
		}
	}// Fin main
} // Fin clase