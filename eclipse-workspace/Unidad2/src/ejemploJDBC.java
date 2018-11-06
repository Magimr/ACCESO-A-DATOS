import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ejemploJDBC {
	public static void main(String[] args) {
// TODO Auto-generated method stub
		try {
//Cargamos el driver
			 /*CONEXION CON MYSQL*/ Class.forName("com.mysql.cj.jdbc.Driver");
			// /*CONEXION CON SQLITE*/ Class.forName("org.sqlite.JDBC");
			//   /*CONEXION CON HSQLDB*/ Class.forName("org.hsqldb.jdbcDriver");
			
//Establecemos la conexión con la BBDD
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/acceso?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "ivan", "tameformacion");
		// /*CONEXION CON SQLITE*/ Connection conexion=
				//	DriverManager.getConnection("jdbc:sqlite:C:\\SQLite\\db\\ejemplo.db");
		
		// /* CONEXION CON HSQLDB*/ Connection conexion=
			//	 DriverManager.getConnection("jdbc:hsqldb:file:C:\\hsqldb\\hsqldb-2.4.1\\hsqldb\\data\\ejemplo\\ejemplo");

//Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			String sql="SELECT * FROM departamentos,empleados where departamentos.dept_no='10' and departamentos.dept_no=empleados.dept_no";
			ResultSet resul = sentencia.executeQuery(sql);
		
//Recorremos el resultado para visualizar cada fila
//Se hace un buble mientras haya registros, se van visualizando
			
			System.out.println("-------------------------------------------");
			System.out.println("Datos de los empleados del departamento 10");
			System.out.println("-------------------------------------------");
			while (resul.next()) {
				System.out.println(resul.getString("apellido") + " " + resul.getString("oficio") + " " + resul.getFloat("salario"));
			}

			System.out.println("----------------------------------------");
			System.out.println("Apellido del empleado con mayor salario:");
			System.out.println("----------------------------------------");
			sql="SELECT apellido,salario from empleados where salario=(select max(salario) from empleados)";
			resul= sentencia.executeQuery(sql);
			while (resul.next()) {
				System.out.println(resul.getString("apellido")+" "+resul.getFloat("salario"));
			}
			
			
			

			resul.close(); // Cerramos ResultSet
			sentencia.close(); // Cerramos Statement
			conexion.close(); // Cerramos Conexión
		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// fin de main
}// fin de la clase