package gui.windows.formatEditor.panels.positionWrapper;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import editor.Format;
import gui.windows.formatEditor.panels.PropertyPanel;

public class MarginPanel extends JPanel
{
	protected JSpinner leftSize;
	protected JSpinner rightSize;
	protected JSpinner topSize;
	protected JSpinner bottomSize;
	
	public void update(Format format)
	{
		leftSize.setValue(format.getWrapperPosition().getMargin().getLeftSize());
		rightSize.setValue(format.getWrapperPosition().getMargin().getRightSize());
		topSize.setValue(format.getWrapperPosition().getMargin().getTopSize());
		bottomSize.setValue(format.getWrapperPosition().getMargin().getBottomSize());
	}
	public void updateFormat(Format format)
	{
		format.getWrapperPosition().getMargin().setLeftSize((int) leftSize.getValue());
		format.getWrapperPosition().getMargin().setRightSize((int) rightSize.getValue());
		format.getWrapperPosition().getMargin().setTopSize((int) topSize.getValue());
		format.getWrapperPosition().getMargin().setBottomSize((int) bottomSize.getValue());
	}
	public MarginPanel()
	{
		super();
		this.setAlignmentX(0.5f);
		this.setAlignmentY(0.5f);
		PropertyPanel propertyPanel;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		leftSize = new JSpinner();
		propertyPanel = new PropertyPanel("Left size", leftSize);
		this.add(propertyPanel);
		
		rightSize = new JSpinner();
		propertyPanel = new PropertyPanel("Right size", rightSize);
		this.add(propertyPanel);
		
		topSize = new JSpinner();
		propertyPanel = new PropertyPanel("Top size", topSize);
		this.add(propertyPanel);
		
		bottomSize = new JSpinner();
		propertyPanel = new PropertyPanel("Bottom size", bottomSize);
		this.add(propertyPanel);
	}

	public JSpinner getLeftSize()
	{
		return leftSize;
	}

	public JSpinner getRightSize()
	{
		return rightSize;
	}

	public JSpinner getTopSize()
	{
		return topSize;
	}

	public JSpinner getBottomSize()
	{
		return bottomSize;
	}
}
