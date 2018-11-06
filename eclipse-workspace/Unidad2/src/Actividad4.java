import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Actividad4 {
	public static void main(String[] args) {
		int aux=0;
				try {
					
					Class.forName("org.sqlite.JDBC");
					Connection conexion=
								DriverManager.getConnection("jdbc:sqlite:C:\\SQLite\\db\\ejemplo.db");
					Statement sentencia = conexion.createStatement();
					String sql="SELECT * FROM empleados";
					ResultSet resul = sentencia.executeQuery(sql);
					
					System.out.println("--------------------------------");
					System.out.println("Datos de los empleados: (SQLite)");
					System.out.println("--------------------------------");
					while (resul.next()) {
						System.out.println(resul.getInt("emp_no")+" | "+resul.getString("apellido") + " | " + resul.getString("oficio")
						+ " " + resul.getInt("dir")+" | "+resul.getString("fecha_alt")+" | "+resul.getFloat("salario")+" | "+resul.getFloat("comision")+" | "+resul.getInt("dept_no"));
					}

					System.out.println("------------------------------------");
					System.out.println("Datos de los departamentos: (SQLite)");
					System.out.println("------------------------------------");
					sql="SELECT * from departamentos";
					resul= sentencia.executeQuery(sql);
					while (resul.next()) {
						System.out.println(resul.getInt("dept_no")+" | "+resul.getString("dnombre")+" | "+resul.getString("loc"));
					}
					
					resul.close(); // Cerramos ResultSet
					sentencia.close(); // Cerramos Statement
					conexion.close(); // Cerramos Conexión
					aux=1;
				}catch (ClassNotFoundException cn) {
					cn.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				if(aux==1) {
					try {
						
						Class.forName("org.hsqldb.jdbcDriver");
						Connection conexion=
									 DriverManager.getConnection("jdbc:hsqldb:file:C:\\hsqldb\\hsqldb-2.4.1\\hsqldb\\data\\ejemplo\\ejemplo");
						Statement sentencia = conexion.createStatement();
						String sql="SELECT * FROM empleados";
						ResultSet resul = sentencia.executeQuery(sql);
						
						System.out.println("--------------------------------");
						System.out.println("Datos de los empleados: (HSQLDB)");
						System.out.println("--------------------------------");
						while (resul.next()) {
							System.out.println(resul.getInt("emp_no")+" | "+resul.getString("apellido") + " | " + resul.getString("oficio")
							+ " | " + resul.getInt("dir")+" | "+ resul.getDate("fecha_alt") + " | " +resul.getFloat("salario")+" | "+resul.getFloat("comision")+" | "+resul.getInt("dept_no"));
						}

						System.out.println("------------------------------------");
						System.out.println("Datos de los departamentos: (HSQLDB)");
						System.out.println("------------------------------------");
						sql="SELECT * from departamentos";
						resul= sentencia.executeQuery(sql);
						while (resul.next()) {
							System.out.println(resul.getInt("dept_no")+" | "+resul.getString("dnombre")+" | "+resul.getString("loc"));
						}
						
						resul.close(); // Cerramos ResultSet
						sentencia.close(); // Cerramos Statement
						conexion.close(); // Cerramos Conexión
						aux=1;
					}catch (ClassNotFoundException cn) {
						cn.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} // if
				
	} // Main
} // Class

