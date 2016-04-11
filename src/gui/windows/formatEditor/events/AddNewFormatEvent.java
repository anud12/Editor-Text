package gui.windows.formatEditor.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import editor.Format;
import gui.windows.formatEditor.FormatEditor;

public class AddNewFormatEvent implements ActionListener
{
	protected FormatEditor editor;
	public AddNewFormatEvent(FormatEditor editor)
	{
		this.editor = editor;
	}
	public void actionPerformed(ActionEvent arg0) 
	{
		Format format = new Format();
		
		format.setTag(" undefined");
		editor.getFormatLibrary().addFormat(format);
		editor.refreshList();
	}
}
