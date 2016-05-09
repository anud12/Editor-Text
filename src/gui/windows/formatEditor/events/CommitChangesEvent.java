package gui.windows.formatEditor.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.xml.bind.JAXBException;

import editor.Format;
import editor.Library;
import editor.XMLParser;
import gui.windows.formatEditor.FormatEditor;

public class CommitChangesEvent implements ActionListener
{
	FormatEditor editor;
	
	public CommitChangesEvent(FormatEditor editor)
	{
		this.editor = editor;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String tag = editor.getSelectedFormatTag();
		
		Format format = new Format();
		format.setTag(tag);
		
		editor.getDecoratorPanel().updateFormat(format);
		editor.getDecoratorWrapperPanel().updateFormat(format);
		editor.getPositionPanel().updateFormat(format);
		editor.getPositionWrapperPanel().updateFormat(format);
		editor.getFormatSpecificPanel().updateFormat(format);
		editor.getFontPanel().updateFormat(format);
		editor.getTextReplacerPanel().updateFormat(format);
		
		Library library = editor.getFormatLibrary();
		library.removeFormat(tag);
		
		library.addFormat(format);
		
		library.removeFormat(" undefined");
		
		editor.refreshList();
	}

}