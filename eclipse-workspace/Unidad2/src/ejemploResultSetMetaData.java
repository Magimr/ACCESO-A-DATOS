import java.sql.*;

public class ejemploResultSetMetaData {
	public static void main(String[] args) {
		try {
//Cargamos el driver
			Class.forName("com.mysql.cj.jdbc.Driver");
//Establecemos conexion con la BBDD
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/acceso?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"ivan", "tameformacion");
			Statement sentencia = conexion.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM departamentos;");
			ResultSetMetaData rsmd = rs.getMetaData();
			int nColumnas = rsmd.getColumnCount();
			String nula;
			System.out.println("Número de columnas recuperadas: " + nColumnas);
			for (int i = 1; i <= nColumnas; i++) {
				System.out.println("Columna: " + i + ":");
				System.out.println(" Nombre:" + rsmd.getColumnName(i));
				System.out.println(" Tipo: " + rsmd.getColumnTypeName(i));
				if (rsmd.isNullable(i) == 0) {
					nula = "NO";
				} else {
					nula = "SI";
				}
				System.out.println(" Puede ser nula? " + nula);
				System.out.println(" Máximo ancho de columna:" + rsmd.getColumnDisplaySize(i));
			}
			conexion.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException sql) {
			sql.printStackTrace();
		}
	}
}
