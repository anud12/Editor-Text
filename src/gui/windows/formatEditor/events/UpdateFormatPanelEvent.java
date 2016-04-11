package gui.windows.formatEditor.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import editor.Format;
import gui.windows.formatEditor.FormatEditor;

public class UpdateFormatPanelEvent implements ListSelectionListener, ActionListener
{
	protected JList<String> list;
	protected FormatEditor editor;
	
	public UpdateFormatPanelEvent(FormatEditor editor)
	{
		this.editor = editor;
		
	}
	public void valueChanged(ListSelectionEvent arg0) 
	{
		if(editor.getList().getSelectedValue() == null)
		{
			return;
		}
		String tag = editor.getList().getSelectedValue().toString();
		
		editor.getLblFormatName().setText(tag);
		
		Format format = (Format) editor.getFormatLibrary().getFormat(tag);
		editor.getFormatSpecificPanel().update(format);
		
		editor.getDecoratorPanel().update(format);
		editor.getDecoratorWrapperPanel().update(format);
		
		editor.getPositionPanel().update(format);
		editor.getPositionWrapperPanel().update(format);
		
		editor.getFontPanel().update(format);
		
		editor.getTextReplacerPanel().update(format);
		
		editor.setSelectedFormatTag(tag);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(editor.getList().getSelectedValue() == null)
		{
			return;
		}
		String tag = editor.getList().getSelectedValue().toString();
		
		editor.getLblFormatName().setText(tag);
		
		Format format = (Format) editor.getFormatLibrary().getFormat(tag);
		editor.getFormatSpecificPanel().update(format);
		
		editor.getDecoratorPanel().update(format);
		editor.getDecoratorWrapperPanel().update(format);
		
		editor.getPositionPanel().update(format);
		editor.getPositionWrapperPanel().update(format);
		
		editor.getFontPanel().update(format);
		
		editor.setSelectedFormatTag(tag);
	}
}
