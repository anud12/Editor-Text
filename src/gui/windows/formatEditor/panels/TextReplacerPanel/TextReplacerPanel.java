
package gui.windows.formatEditor.panels.TextReplacerPanel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import editor.Format;
import editor.TextReplacer;
import gui.windows.formatEditor.panels.TextReplacerPanel.events.EditButtonEvent;
import gui.windows.formatEditor.panels.TextReplacerPanel.events.NewButtonEvent;
import gui.windows.formatEditor.panels.TextReplacerPanel.events.RemoveButtonEvent;

public class TextReplacerPanel extends JPanel
{
	protected JList<TextReplacer> list;
	
	
	public TextReplacerPanel()
	{
		this.setBorder(new TitledBorder(null, "Text Replacer", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_19 = new JPanel();
		this.add(panel_19, BorderLayout.WEST);
		panel_19.setLayout(new BoxLayout(panel_19, BoxLayout.X_AXIS));
		
		list = new JList<TextReplacer>();
		panel_19.add(list);
		list.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		list.setMinimumSize(new Dimension(3200, 0));
		list.setMaximumSize(new Dimension(3200, 9999));
		list.setPreferredSize(new Dimension(320, 0));
		list.setModel(new DefaultListModel<TextReplacer>());

		
		JPanel panel_17 = new JPanel();
		this.add(panel_17, BorderLayout.CENTER);
		panel_17.setLayout(new BoxLayout(panel_17, BoxLayout.X_AXIS));
		
		JPanel panel_18 = new JPanel();
		panel_18.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_17.add(panel_18);
		panel_18.setLayout(new BoxLayout(panel_18, BoxLayout.Y_AXIS));
		
		JButton btnNew = new JButton("New");
		btnNew.setMinimumSize(new Dimension(75, 23));
		btnNew.setMaximumSize(new Dimension(75, 23));
		btnNew.setPreferredSize(new Dimension(75, 23));
		btnNew.addActionListener(new NewButtonEvent(this));
		panel_18.add(btnNew);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		verticalStrut_3.setMinimumSize(new Dimension(0, 5));
		verticalStrut_3.setMaximumSize(new Dimension(32767, 5));
		verticalStrut_3.setPreferredSize(new Dimension(0, 5));
		panel_18.add(verticalStrut_3);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setPreferredSize(new Dimension(75, 23));
		btnRemove.setMinimumSize(new Dimension(75, 23));
		btnRemove.setMaximumSize(new Dimension(75, 23));
		btnRemove.addActionListener(new RemoveButtonEvent(this));
		panel_18.add(btnRemove);
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		verticalStrut_4.setPreferredSize(new Dimension(0, 5));
		verticalStrut_4.setMinimumSize(new Dimension(0, 5));
		verticalStrut_4.setMaximumSize(new Dimension(32767, 5));
		panel_18.add(verticalStrut_4);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setPreferredSize(new Dimension(75, 23));
		btnEdit.setMinimumSize(new Dimension(75, 23));
		btnEdit.setMaximumSize(new Dimension(75, 23));
		btnEdit.addActionListener(new EditButtonEvent(this));
		panel_18.add(btnEdit);
	}
	
	public DefaultListModel<TextReplacer> getModel()
	{
		return (DefaultListModel<TextReplacer>) list.getModel();
	}
	public JList<TextReplacer> getList()
	{
		return list;
		
	}
	
	public void update(Format format)
	{
		LinkedList<TextReplacer> replacers = format.getReplacers();
		
		DefaultListModel<TextReplacer> listModel = (DefaultListModel<TextReplacer>) list.getModel();
		
		listModel.clear();
		
		Iterator<TextReplacer> iterator = replacers.iterator();
		
		while(iterator.hasNext())
		{
			TextReplacer replacer = iterator.next();
			
			listModel.addElement(replacer);
		}
	}
	
	public void updateFormat(Format format)
	{
		DefaultListModel<TextReplacer> listModel = (DefaultListModel<TextReplacer>) list.getModel();
		
		format.getReplacers().clear();
		
		Enumeration<TextReplacer> enumeration = listModel.elements();
		
		
		
		while(enumeration.hasMoreElements())
		{
			TextReplacer element = enumeration.nextElement();
			
			format.setReplaceOrder(element);
		}
				
		Iterator<TextReplacer> iterator = format.getReplacers().iterator();
		while(iterator.hasNext())
		{
			TextReplacer replacer = iterator.next();
			
			System.out.println(replacer);
			
		}
	}
}
