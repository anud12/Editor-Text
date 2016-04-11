package gui.windows.formatEditor.panels.decoratorWrapper;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import editor.Format;
import gui.windows.formatEditor.panels.PropertyPanel;

public class BackgroundWrapperPanel extends JPanel
{
	public JTextField getColor()
	{
		return color;
	}

	protected JTextField color;
	
	public BackgroundWrapperPanel()
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
		this.color.setText(format.getWrapperDecorator().getBackground().getColor());
	}
	public void updateFormat(Format format)
	{
		format.getWrapperDecorator().getBackground().setColor(this.color.getText()); 
	}
}
