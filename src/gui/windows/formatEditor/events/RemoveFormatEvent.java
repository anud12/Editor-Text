package gui.windows.formatEditor.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import editor.Library;
import gui.windows.formatEditor.FormatEditor;

public class RemoveFormatEvent implements ActionListener
{
	protected FormatEditor editor;
	
	public RemoveFormatEvent(FormatEditor editor)
	{
		this.editor = editor;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String tag = editor.getSelectedFormatTag();
		
		Library library = editor.getFormatLibrary();
		library.removeFormat(tag);
	
		editor.refreshList();
	}
}
