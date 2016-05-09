package gui.windows.formatEditor.panels.decoratorWrapper;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import editor.Format;
import gui.windows.formatEditor.panels.PropertyPanel;

public class BoxShadowPanel extends JPanel
{
	protected JSpinner hShadow;
	protected JSpinner vShadow;
	protected JSpinner blurDistance;
	protected JSpinner spreadSize;
	protected JTextField color;
	
	public void update(Format format)
	{
		vShadow.setValue(format.getWrapperDecorator().getBoxShadow().getvShadow());
		hShadow.setValue(format.getWrapperDecorator().getBoxShadow().gethShadow());
		blurDistance.setValue(format.getWrapperDecorator().getBoxShadow().getBlurDistance());
		spreadSize.setValue(format.getWrapperDecorator().getBoxShadow().getSpreadSize());
		color.setText(format.getWrapperDecorator().getBoxShadow().getColor());
	}
	public void updateFormat(Format format)
	{
		format.getWrapperDecorator().getBoxShadow().setvShadow((int) vShadow.getValue());
		format.getWrapperDecorator().getBoxShadow().sethShadow((int) hShadow.getValue());
		format.getWrapperDecorator().getBoxShadow().setBlurDistance((int) blurDistance.getValue());
		format.getWrapperDecorator().getBoxShadow().setSpreadSize((int) blurDistance.getValue());
		format.getWrapperDecorator().getBoxShadow().setColor(color.getText());
	}
	public BoxShadowPanel()
	{
		super();
		this.setAlignmentX(0.5f);
		this.setAlignmentY(0.5f);
		PropertyPanel propertyPanel;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		
		hShadow = new JSpinner();
		propertyPanel = new PropertyPanel("Horizontal Size", hShadow);
		this.add(propertyPanel);
		
		vShadow = new JSpinner();
		propertyPanel = new PropertyPanel("Vertical Size", vShadow);
		this.add(propertyPanel);
		
		blurDistance = new JSpinner();
		propertyPanel = new PropertyPanel("Blur distance", blurDistance);
		this.add(propertyPanel);
		
		spreadSize = new JSpinner();
		propertyPanel = new PropertyPanel("Spread size", spreadSize);
		this.add(propertyPanel);
		
		color = new JTextField();
		propertyPanel = new PropertyPanel("Color code", color);
		this.add(propertyPanel);
	}

	public JSpinner gethShadow()
	{
		return hShadow;
	}

	public JSpinner getvShadow()
	{
		return vShadow;
	}

	public JSpinner getBlurDistance()
	{
		return blurDistance;
	}

	public JSpinner getSpreadSize()
	{
		return spreadSize;
	}

	public JTextField getColor()
	{
		return color;
	}
}
