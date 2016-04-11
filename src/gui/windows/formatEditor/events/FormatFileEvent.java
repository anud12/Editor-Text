package gui.windows.formatEditor.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.xml.bind.JAXBException;

import editor.Library;
import editor.XMLParser;
import gui.windows.formatEditor.FormatEditor;

public class FormatFileEvent implements ActionListener
{
	protected FormatEditor editor;
	
	public FormatFileEvent(FormatEditor editor)
	{
		this.editor = editor;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		JFileChooser chooser = new JFileChooser();
		
		if(chooser.showOpenDialog(null) == chooser.APPROVE_OPTION)
		{
			
			Scanner scanner;
			try
			{
				File selectedFile = chooser.getSelectedFile();
				
				scanner = new Scanner(selectedFile);
				String string = "";
				
				Library library = editor.getFormatLibrary();
				
				while(scanner.hasNextLine())
				{
					String line = scanner.nextLine();
								
					string += line + " \n ";
				}
				
				String path = selectedFile.getAbsolutePath().substring(0, selectedFile.getAbsolutePath().lastIndexOf("."));
				path += "\\" + selectedFile.getName().substring(0, selectedFile.getName().lastIndexOf(".")) + ".html";
				
				File file = new File(path);
				file.getParentFile().mkdirs();
				System.out.println(path);
				
				FileWriter stream = new FileWriter(file);
				
				stream.write(editor.getFormatLibrary().getReader().process(string));
				stream.flush();
				stream.close();
			}
			
			
			catch (FileNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
