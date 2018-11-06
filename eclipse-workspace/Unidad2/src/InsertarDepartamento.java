import java.sql.*;
import java.util.Scanner;

public class InsertarDepartamento {
	public static void main(String[] args) {
		try {
//Cargamos el driver
			Class.forName("com.mysql.cj.jdbc.Driver");
//Establecemos conexion con la BBDD
			Connection conexion =

					DriverManager.getConnection("jdbc:mysql://localhost/acceso?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
							"ivan", "tameformacion");
//Pedimos los datos por teclado
			Scanner teclado = new Scanner(System.in);
			System.out.println("Introduce el número de departamento: ");
			int dep = teclado.nextInt();
			System.out.println("Introduce el nombre de departamento: ");
			String dnombre = teclado.next();
			System.out.println("Introduce la localidad del departamento: ");
			String loc = teclado.next();
//Construimos la sentencia
			String sql = "INSERT INTO departamentos VALUES (" + dep + ",'" + dnombre + "','" + loc + "')";
			System.out.println(sql);
			Statement sentencia = conexion.createStatement();
			int filas = sentencia.executeUpdate(sql);
			System.out.println("Filas afectadas: " + filas);
			teclado.close();
			sentencia.close();
			conexion.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}