package gui.windows.formatEditor.panels.TextReplacerPanel.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import editor.TextReplacer;
import gui.windows.formatEditor.panels.TextReplacerPanel.TextReplacerPanel;

public class EditButtonEvent implements ActionListener
{
	protected TextReplacerPanel replacerPanel;
	protected JTextField replacer = new JTextField();
	protected JTextField replaced = new JTextField();
	protected JCheckBox ignoreDuplicate = new JCheckBox();
	protected JCheckBox ignoreFirst = new JCheckBox();
	
	protected Object[] message = {
		    "Find:", replaced,
		    "Replace:", replacer,
		    "Ignore duplicate", ignoreDuplicate,
		    "Ignore first occurence", ignoreFirst
		};
	
	public EditButtonEvent(TextReplacerPanel replacerPanel)
	{
		this.replacerPanel = replacerPanel;
	}
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		if(replacerPanel.getList().isSelectionEmpty())
			return;
		TextReplacer replacerObject = replacerPanel.getModel().getElementAt(replacerPanel.getList().getSelectedIndex());
		
		replacer.setText(replacerObject.getReplacer().replaceAll("\n", "[newLine]"));
		replaced.setText(replacerObject.getReplaced().replaceAll("\n", "[newLine]"));
		ignoreDuplicate.setSelected(replacerObject.isIgnoreDuplicate());
		ignoreFirst.setSelected(replacerObject.isIgnoreFirst());
		
		int option = JOptionPane.showConfirmDialog(null, message, "Set Rule", JOptionPane.OK_CANCEL_OPTION);
		
		if(option == JOptionPane.OK_OPTION)
		{
			TextReplacer textReplacer = new TextReplacer(replaced.getText().replace("[newLine]", String.valueOf('\n')), replacer.getText().replace("[newLine]", String.valueOf('\n')), ignoreDuplicate.isSelected(), ignoreFirst.isSelected());
			DefaultListModel<TextReplacer> model = replacerPanel.getModel();
			
			model.addElement(textReplacer);
		}
		
	}
}