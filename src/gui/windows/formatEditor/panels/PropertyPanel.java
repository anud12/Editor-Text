package gui.windows.formatEditor.panels;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Label;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PropertyPanel extends JPanel
{
	protected JLabel label;
	protected JPanel panel;
	
	protected void constructor(String labelText, Component component)
	{
		this.setMaximumSize(new Dimension(32767, 25));
		this.setLayout(new BorderLayout());
		
		panel = new JPanel();
		panel.setMaximumSize(new Dimension(32767, 35));
		panel.setMinimumSize(new Dimension(170, 35));
		
		this.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		label = new JLabel(labelText);
		label.setPreferredSize(new Dimension(80, 14));
		label.setSize(new Dimension(80, 0));
		label.setMinimumSize(new Dimension(80, 14));
		label.setMaximumSize(new Dimension(80, 14));
		
		component.setPreferredSize(new Dimension(80, 0));
		component.setMinimumSize(new Dimension(80, 0));
		
		panel.add(label);
		panel.add(component);
		
		Component verticalStrut = Box.createVerticalStrut(5);
		this.add(verticalStrut, BorderLayout.SOUTH);
	}
	public void setLabelWidthIncrement(int increment)
	{
		label.setPreferredSize(new Dimension(80 * increment, 14));
		label.setSize(new Dimension(80 * increment, 0));
		label.setMinimumSize(new Dimension(80 * increment, 14));
		label.setMaximumSize(new Dimension(80 * increment, 14));
	}
	public void setHeightIncrement(int increment)
	{
		this.setMaximumSize(new Dimension(32767, 25 * increment));
		
		panel.setMaximumSize(new Dimension(32767, 25 * increment));
		panel.setMinimumSize(new Dimension(170, 25 * increment));
	}
	public PropertyPanel(String labelText, Component component)
	{
		super();
		
		constructor(labelText, component);
	}
	public PropertyPanel(String labelText, Component component, Component component2)
	{
		constructor(labelText, component);
		
		component2.setMaximumSize(new Dimension(80,30));
		component2.setMinimumSize(new Dimension(80,30));
		component2.setPreferredSize(new Dimension(80,30));
		panel.add(Box.createHorizontalStrut(5));
		panel.add(component2);
	}
}
