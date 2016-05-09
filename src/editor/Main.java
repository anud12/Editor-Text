package editor;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import gui.windows.formatEditor.FormatEditor;

public class Main
{
	public static void main(String args[]) throws IOException, JAXBException
	{
		FormatEditor editor = new FormatEditor();
		editor.refreshList();
		
	}
}
