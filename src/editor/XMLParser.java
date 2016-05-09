package editor;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

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
 
		
		return library;
	}
}
