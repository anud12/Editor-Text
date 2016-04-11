package gui.windows.formatEditor.panels.decoratorWrapper;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import editor.Format;
import gui.windows.formatEditor.panels.PropertyPanel;

public class BorderWrapperPanel extends JPanel
{	
	protected JComboBox<String> style;
	protected JSpinner leftWidth;
	protected JSpinner rightWidth;
	protected JSpinner topWidth;
	protected JSpinner bottomWidth;
	protected JTextField color;
	
	public void update(Format format)
	{
		String formatStyle = format.getWrapperDecorator().getBorder().getStyle();
		
		int i = 0;
		int count = style.getItemCount();
		boolean found = false;
		while(i < count)
		{
			if(style.getItemAt(i).equalsIgnoreCase(formatStyle))
			{
				found = true;
				break;
			}
			i++;
		}
		if(found)
		{
			style.setSelectedIndex(i);
		}
		else
		{
			style.setSelectedIndex(0);
		}
		leftWidth.setValue(format.getWrapperDecorator().getBorder().getLeftWidth());
		rightWidth.setValue(format.getWrapperDecorator().getBorder().getRightWidth());
		bottomWidth.setValue(format.getWrapperDecorator().getBorder().getBottomWidth());
		topWidth.setValue(format.getWrapperDecorator().getBorder().getTopWidth());
		color.setText(format.getWrapperDecorator().getBorder().getColor());
	}
	
	public void updateFormat(Format format)
	{
		format.getWrapperDecorator().getBorder().setStyle((String) style.getSelectedItem());
		format.getWrapperDecorator().getBorder().setLeft(Double.valueOf((String) leftWidth.getValue().toString()));
		format.getWrapperDecorator().getBorder().setRight(Double.valueOf((String)rightWidth.getValue().toString()));
		format.getWrapperDecorator().getBorder().setBottom(Double.valueOf((String)bottomWidth.getValue().toString()));
		format.getWrapperDecorator().getBorder().setTop(Double.valueOf((String)topWidth.getValue().toString()));
		format.getWrapperDecorator().getBorder().setColor(color.getText().toString());
	}
	public BorderWrapperPanel()
	{
		super();
		this.setAlignmentX(0.5f);
		this.setAlignmentY(0.5f);
		PropertyPanel propertyPanel;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		style = new JComboBox<String>();
		style.addItem("Inherit");
		style.addItem("None");
		style.addItem("Solid");
		style.addItem("Dotted");
		style.addItem("Dashed");
		style.addItem("Double");
		style.addItem("Groove");
		style.addItem("Ridge");
		style.addItem("Inset");
		style.addItem("Outset");
				
		propertyPanel = new PropertyPanel("Style", style);
		this.add(propertyPanel);
		
		leftWidth = new JSpinner();
		propertyPanel = new PropertyPanel("Left width", leftWidth);
		this.add(propertyPanel);
		
		rightWidth = new JSpinner();
		propertyPanel = new PropertyPanel("Right width", rightWidth);
		this.add(propertyPanel);
		
		topWidth = new JSpinner();
		propertyPanel = new PropertyPanel("Top width", topWidth);
		this.add(propertyPanel);
		
		bottomWidth = new JSpinner();
		propertyPanel = new PropertyPanel("Bottom width", bottomWidth);
		this.add(propertyPanel);
		
		color = new JTextField();
		propertyPanel = new PropertyPanel("Color code", color);
		this.add(propertyPanel);
	}
	
	public JComboBox<String> getStyle()
	{
		return style;
	}

	public JSpinner getLeftWidth()
	{
		return leftWidth;
	}

	public JSpinner getRightWidth()
	{
		return rightWidth;
	}

	public JSpinner getTopWidth()
	{
		return topWidth;
	}

	public JSpinner getBottomWidth()
	{
		return bottomWidth;
	}

	public JTextField getColor()
	{
		return color;
	}
}
