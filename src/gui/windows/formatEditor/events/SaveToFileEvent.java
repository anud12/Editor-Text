package gui.windows.formatEditor.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.xml.bind.JAXBException;

import editor.XMLParser;
import gui.windows.formatEditor.FormatEditor;

public class SaveToFileEvent implements ActionListener
{
	FormatEditor editor;
	
	public SaveToFileEvent(FormatEditor editor)
	{
		this.editor = editor;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		JFileChooser chooser = new JFileChooser();
		
		if(chooser.showOpenDialog(null) == chooser.APPROVE_OPTION)
		{
			File selectedFile = chooser.getSelectedFile();
			try
			{
				XMLParser.writeLibrary(selectedFile, editor.getFormatLibrary());
				editor.openLibrary(selectedFile);
			}
			catch (JAXBException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}

