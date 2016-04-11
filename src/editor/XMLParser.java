package editor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLParser
{
	static public void writeLibrary(File file, Library library) throws JAXBException 
	{
		
		JAXBContext context = JAXBContext.newInstance(Library.class);
		Marshaller marshaller = context.createMarshaller();
		
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		marshaller.marshal(library, file);
	}
	static public Library readLibrary(File file) throws JAXBException 
	{
		
		JAXBContext context = JAXBContext.newInstance(Library.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		Library library = (Library) unmarshaller.unmarshal(file);
		String name = file.getName();
		library.setName(name.substring(0, name.lastIndexOf(".")));
		
		return library;
	}
}
