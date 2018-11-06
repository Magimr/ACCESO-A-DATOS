import java.io.*;
public class LeerFichObject {
public static void main(String[] args) throws IOException,
ClassNotFoundException{
Departamento departamento; //defino la variable persona
//Declaramos el fichero
File fichero = new File("Departamentos.dat");
//Creamos el flujo de entrada
FileInputStream filein = new FileInputStream (fichero);
//Conectamos el flujo de bytes al flujo de datos (objetos)
ObjectInputStream dataIS = new ObjectInputStream(filein);
try{
while(true){ //recorremos el fichero
departamento = (Departamento) dataIS.readObject(); //Leemos una persona
System.out.println("Nombre: "+departamento.getNombre()+" ,edad:"
+departamento.getLocalidad());
}
}catch (EOFException e){}
dataIS.close(); //Cerrar stream de entrada
filein.close();
}
}
