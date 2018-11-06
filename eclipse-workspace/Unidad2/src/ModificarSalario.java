import java.sql.*;
import java.util.Scanner;

public class ModificarSalario {
	public static void main(String[] args) {
		try {
//Cargamos el driver
			Class.forName("com.mysql.cj.jdbc.Driver");
//Establecemos conexion con la BBDD

			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/acceso?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"ivan", "tameformacion");
//Pedimos los datos por teclado
			Scanner teclado = new Scanner(System.in);
			System.out.println("Introduce el número de departamento: ");
			int dep = teclado.nextInt();
			System.out.println("Introduce la subida de salario: ");
			int subida = teclado.nextInt();
			String sql = "UPDATE empleados SET salario=salario+" + subida + " WHERE dept_no=" + dep;
			System.out.println(sql);
			Statement sentencia = conexion.createStatement();
			int filas = sentencia.executeUpdate(sql);
			System.out.println("Filas modificadas: " + filas);
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
