package gui.windows.formatEditor.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.xml.bind.JAXBException;

import editor.Library;
import editor.XMLParser;
import gui.windows.formatEditor.FormatEditor;

public class OpenLibraryEvent implements ActionListener
{
	protected FormatEditor editor;
	
	public OpenLibraryEvent (FormatEditor editor)
	{
		this.editor = editor;
	}
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		JFileChooser chooser = new JFileChooser();
		
		if(chooser.showOpenDialog(null) == chooser.APPROVE_OPTION)
		{
			File selectedFile = chooser.getSelectedFile();
			try
			{
				Library library = XMLParser.readLibrary(selectedFile);
				editor.setLibrary(library);
				editor.refreshList();
			}
			catch (JAXBException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
