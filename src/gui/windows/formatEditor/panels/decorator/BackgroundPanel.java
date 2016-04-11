package gui.windows.formatEditor.panels.decorator;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import editor.Format;
import gui.windows.formatEditor.panels.PropertyPanel;

public class BackgroundPanel extends JPanel
{
	public JTextField getColor()
	{
		return color;
	}

	protected JTextField color;
	
	public BackgroundPanel()
	{
		super();
		this.setAlignmentX(0.5f);
		this.setAlignmentY(0.5f);
		PropertyPanel propertyPanel;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		color = new JTextField();
		propertyPanel = new PropertyPanel("Color code", color);
		this.add(propertyPanel);
	}
	public void update(Format format)
	{
		this.color.setText(format.getDecorator().getBackground().getColor());
	}
	public void updateFormat(Format format)
	{
		format.getDecorator().getBackground().setColor(this.color.getText()); 
	}
}
