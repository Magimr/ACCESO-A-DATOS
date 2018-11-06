import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.*;

public class PruebaSax1 {
	public static void main(String[] args) throws FileNotFoundException, IOException, SAXException {
		XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
		GestionContenido gestor = new GestionContenido();
		procesadorXML.setContentHandler(gestor);
		InputSource fileXML = new InputSource("alumnos.xml");
		procesadorXML.parse(fileXML);
	}
}// Fin PruebaSax1

class GestionContenido extends DefaultHandler {
	int count=0;
	boolean isEndElement=false;
	public GestionContenido() {
		super();
	}

	public void startDocument() {
		System.out.println("Comienzo del documento XML");
	}

	public void endDocument() {
		System.out.println("Final del documento XML");
	}

	public void startElement(String uri, String nombre, String nombreC, Attributes atts) {
		if(!isEndElement) {
			count++;
		}
		
		printIndent();
		System.out.println("Principio Elemento: " + nombre);
		isEndElement=false;
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException{
		count--;
		printIndent();	
		System.out.println("Fin Elemento: " + localName);
		isEndElement=true;
		
		
	}

	public void characters(char[] ch, int inicio, int longitud) throws SAXException {
		
		String car = new String(ch, inicio, longitud);
		car = car.replaceAll("[\t\n]", ""); // Quitar los saltos de linea
		if(car!=null && !car.equals("")) {
			count++;
			printIndent();
			System.out.println("Caracteres: " + car);			
		}
	}
	
	public void printIndent() {
		for(int i=0;i<count;i++) {
			System.out.print("\t");
		}
	}
}// Fin GestionContenido
