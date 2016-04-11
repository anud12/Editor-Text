package editor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import css.Border;
import gui.windows.formatEditor.FormatEditor;

public class Test
{
	public static void main(String args[]) throws IOException
	{
		File out = new File("library.xml");
		Library library = new Library();
		
		Scanner scanner = new Scanner(new File("in.txt"));
		String string = "";
		while(scanner.hasNextLine())
		{
			String line = scanner.nextLine();
						
			string += line + " \n ";
		}
		
		double fontSize = 16;
		Reader reader = new Reader(library);
		
		Border debugBorder = new Border();
		debugBorder.setColor("#DFDFDF");
		debugBorder.setWidth(0D);
		debugBorder.setStyle("Solid");
		
		Format format = new Format("/titlu");
		format.getFont().setFontFamily("Roboto Mono");
		format.setCenteredDom(true);
		format.setHasChildren(true);
		library.addFormat(format);
		format.getFont().setSize(35);
		format.getFont().setBold(true);
		
		format.getPosition().getMargin().setSize(20);
		
		format.getWrapperPosition().setzIndex(9);
		format.getWrapperPosition().getMargin().setTopSize(0);
		format.getWrapperPosition().getMargin().setBottomSize(0);

		format.getPosition().getPadding().setSize(5);
		
		format.getWrapperDecorator().getBackground().setColor("#00B0FF");
		format.getFont().setColor("white");
		
		format.getWrapperDecorator().getBoxShadow().setHShadow(0);
		format.getWrapperDecorator().getBoxShadow().setvShadow(0);
		format.getWrapperDecorator().getBoxShadow().setBlurDistance(3);
		format.getWrapperDecorator().getBoxShadow().setSpreadSize(3);
		format.getWrapperDecorator().getBoxShadow().setColor("rgba(0,0,0,0.45)");
		
		library.addFormat(format);	
		
		format = new Format("/c");
		format.getFont().setSize(fontSize);
		format.setNewLine(true);
		format.setHasChildren(true);
		format.setPreText("Capitol : ");
		format.getFont().setFontFamily("Roboto Mono");
		format.getPosition().getMargin().setTopSize(30);
		format.getPosition().getMargin().setLeftSize(50);
		
		format.getWrapperPosition().setzIndex(8);
		format.getWrapperDecorator().getBorder().setStyle("solid");
		format.getWrapperDecorator().getBorder().setTop(1D);
		format.getWrapperDecorator().getBorder().setColor("#DDDDDD");
		format.getWrapperPosition().getMargin().setTopSize(0);
		format.getWrapperPosition().getMargin().setBottomSize(22);
		
		format.getFont().setColor("#00B0FF");
		
		
		format.getDecorator().setBorder(debugBorder);
		
		library.addFormat(format);
		
		format = new Format("/l");
		format.getFont().setSize(fontSize);
		format.setPreText("-");
		format.setReplaceOrder(new TextReplacer("\n","<br>-",true ,true));
		format.setHidden(false);
		format.setNewLine(true);
		format.getFont().setFontFamily("Roboto Mono");
		
		format.getPosition().getMargin().setLeftSize(25);
		format.getDecorator().setBorder(debugBorder);
		
		
		library.addFormat(format);
		
		format = new Format("/p");
		format.getFont().setSize(fontSize);
		format.setNewLine(true);
		format.getFont().setFontFamily("Roboto Mono");
		format.getPosition().getMargin().setLeftSize(25);
		format.getDecorator().setBorder(debugBorder);
		
		library.addFormat(format);
		
		format = new Format("/tb");
		format.setNewLine(true);
		format.setDomTag("table");
		
		format.setReplaceOrder(new TextReplacer("|", "</td><td>", false, false));
		format.setReplaceOrder(new TextReplacer("-|","</td></tr>",false ,true ));
		format.setReplaceOrder(new TextReplacer("|-","<tr><td>",false ,true ));
		format.getFont().setFontFamily("Roboto Mono");
		format.getFont().setCenter(true);
		format.getFont().setSize(20);
		
		format.getPosition().getMargin().setLeftSize(25);
		format.getDecorator().setBorder(debugBorder);
		
		library.addFormat(format);
		
		format = new Format("/cod");
		format.getFont().setSize(fontSize);
		format.setHidden(false);
		format.setNewLine(true);
		format.getFont().setItalic(true);
		format.setReplaceOrder(new TextReplacer("\n","<br>",false ,true ));
		format.setReplaceOrder(new TextReplacer(" ", "&nbsp;",true ,true ));
		format.setReplaceOrder(new TextReplacer("\t", "&nbsp; &nbsp; &nbsp; &nbsp; ",true ,true ));
		format.getFont().setFontFamily("Roboto Mono");
		format.getFont().setFontGeneric("monospace");
		format.getPosition().getMargin().setLeftSize(25);
		format.getDecorator().setBorder(debugBorder);
		
		library.addFormat(format);
		
		format = new Format("/def");
		format.getFont().setSize(fontSize);
		format.getFont().setFontFamily("Roboto Mono");
		format.getFont().setColor("#512DA8");
		format.getFont().setUnderLine(true);
		format.setHidden(false);
		format.setNewLine(true);
		format.setPreText("Definitie: ");
		format.getPosition().getMargin().setBottomSize(5);
		format.getPosition().getMargin().setTopSize(5);
		format.getPosition().getPadding().setSize(5);
		format.getDecorator().getBorder().setColor("#512DA8");
		format.getDecorator().getBorder().setStyle("dashed");
		format.getDecorator().getBorder().setLeft(2D);;
		format.getPosition().getMargin().setLeftSize(25);

		library.addFormat(format);

		try
		{
			XMLParser.writeLibrary(out, library);
		}
		catch (JAXBException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FormatEditor editor = new FormatEditor();
		editor.setLibrary(library);
		File file = new File("test.html");
		FileWriter stream = new FileWriter(file);
		
		stream.write(reader.process(string));
		stream.flush();
		
		System.in.read();
	}
}
