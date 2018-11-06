import java.sql.*;
import java.util.Scanner;

public class InsertarEmpleado {
	public static void main(String[] args) {
		try {
//Cargamos el driver
			Class.forName("com.mysql.cj.jdbc.Driver");
//Establecemos conexion con la BBDD

			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/acceso?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"ivan", "tameformacion");
//Pedimos los datos por teclado
			Scanner teclado = new Scanner(System.in);

			System.out.println("Introduce el número de empleado: ");
			int emp = teclado.nextInt();

			System.out.println("Introduce el apellido del empleado: ");
			String apellido = teclado.next();

			System.out.println("Introduce el oficio del empleado: ");
			String oficio = teclado.next();

			System.out.println("Introduce el director del empleado: ");
			int dir = teclado.nextInt();

			System.out.println("Introduce el salario del empleado: ");
			float salario = teclado.nextFloat();

			System.out.println("Introduce la comision del empleado: ");
			float comision = teclado.nextFloat();

			System.out.println("Introduce el numero de departamento del empleado: ");
			int dept = teclado.nextInt();

			Statement sentenciaDept = conexion.createStatement();
			String sql = "Select * from departamentos where dept_no=" + dept;
			ResultSet rsDept = sentenciaDept.executeQuery(sql);
			
			Statement sentenciaEmpleado = conexion.createStatement();
			sql= "Select * from empleados where emp_no="+emp;
			ResultSet rsEmpleado = sentenciaEmpleado.executeQuery(sql);
			
			Statement sentenciaDir = conexion.createStatement();
			sql= "Select * from empleados where emp_no="+dir;
			ResultSet rsDir = sentenciaDir.executeQuery(sql);
			
			

			if (salario > 0 && rsDept.next() && !rsEmpleado.next() && rsDir.next()) {
				sql = "insert into empleados values (" + emp + "," + "'"+apellido+ "'"+ "," + "'"+oficio+"'" + "," + dir + "," + null+","
						+ salario + "," + comision + "," + dept + ")";

				System.out.println(sql);
				Statement sentencia = conexion.createStatement();
				int filas = sentencia.executeUpdate(sql);
				System.out.println("Filas insertadas: " + filas);
				sentencia.close();

			}else {
				System.out.println("ERROR. HAY DATOS INCORRECTOS");
			}
			rsDept.close();
			rsDir.close();
			rsEmpleado.close();
			sentenciaDir.close();
			sentenciaDept.close();
			sentenciaEmpleado.close();
			teclado.close();
			conexion.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
