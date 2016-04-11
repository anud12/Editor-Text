package gui.windows.formatEditor.panels.TextReplacerPanel.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import editor.TextReplacer;
import gui.windows.formatEditor.panels.TextReplacerPanel.TextReplacerPanel;

public class NewButtonEvent implements ActionListener
{
	protected TextReplacerPanel replacerPanel;
	protected JTextField replacer = new JTextField();
	protected JTextField replaced = new JTextField();
	protected JCheckBox ignoreDuplicate = new JCheckBox();
	protected JCheckBox ignoreFirst = new JCheckBox();
	
	protected Object[] message = {
		    "Find:", replacer,
		    "Replace:", replaced,
		    "Ignore duplicate", ignoreDuplicate,
		    "Ignore first occurence", ignoreFirst
		};
	
	public NewButtonEvent(TextReplacerPanel replacerPanel)
	{
		this.replacerPanel = replacerPanel;
	}
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		int option = JOptionPane.showConfirmDialog(null, message, "Set Rule", JOptionPane.OK_CANCEL_OPTION);
		
		if(option == JOptionPane.OK_OPTION)
		{
			TextReplacer textReplacer = new TextReplacer(replaced.getText().replace("[newLine]", String.valueOf('\n')), replacer.getText().replace("[newLine]", String.valueOf('\n')), ignoreDuplicate.isSelected(), ignoreFirst.isSelected());
			DefaultListModel<TextReplacer> model = replacerPanel.getModel();
			
			model.addElement(textReplacer);
		}
		
	}

}
