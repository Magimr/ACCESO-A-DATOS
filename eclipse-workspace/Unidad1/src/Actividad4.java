import java.io.*;
import java.util.Scanner;
public class Actividad4 {
public static void main(String[] args) throws IOException {
Scanner teclado= new Scanner(System.in);
File fichero = new File("FichdataAct4.dat");
FileOutputStream fileout = new FileOutputStream(fichero);
DataOutputStream dataOS = new DataOutputStream(fileout);
FileInputStream filein = new FileInputStream(fichero);
DataInputStream dataIS = new DataInputStream(filein);
String dni[]= new String[100];
String nombres[] = new String[100];
int edades[] = new int[100];
String ciudad[]= new String[100];
int aux=0;

while (aux!=2) {
for(int i=0; i<100;i++){
	System.out.println("Introduce un DNI: ");
	dni[i]=teclado.nextLine();
	
	System.out.println("Introduce un nombre: ");
	nombres[i]=teclado.nextLine();
	
	System.out.println("Introduce una edad: ");
	edades[i]=teclado.nextInt();
	
	System.out.println("Introduce una ciudad: ");
	teclado.nextLine();
	ciudad[i]=teclado.nextLine();
	
	
dataOS.writeUTF(dni[i]);
dataOS.writeUTF(nombres[i]);
dataOS.writeInt(edades[i]);
dataOS.writeUTF(ciudad[i]);




System.out.println("Desea introducir otros datos? 1-Si / 2-No");
aux= teclado.nextInt();
teclado.nextLine();

if(aux==2) {
	break;
}


}
}
int i=0;
try{
while (true){
dni[i] = dataIS.readUTF();
nombres[i] = dataIS.readUTF(); 
edades[i] = dataIS.readInt(); 
ciudad[i] = dataIS.readUTF();

System.out.println("DNI: "+dni[i]+", Nombre: "+nombres[i]+", Edad: "+edades[i]+
		", Ciudad: "+ciudad[i]);
i++;
}
}
catch(EOFException eo){}
teclado.close();
dataOS.close(); 
dataIS.close();
}
}