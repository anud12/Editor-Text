package gui.windows.formatEditor.panels.TextReplacerPanel.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import editor.TextReplacer;
import gui.windows.formatEditor.panels.TextReplacerPanel.TextReplacerPanel;

public class RemoveButtonEvent implements ActionListener
{
	protected TextReplacerPanel replacerPanel;
	
	public RemoveButtonEvent(TextReplacerPanel replacerPanel)
	{
		this.replacerPanel = replacerPanel;
	}
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		if(replacerPanel.getList().isSelectionEmpty())
			return;
		
		replacerPanel.getModel().remove(replacerPanel.getList().getSelectedIndex());
	}

}
