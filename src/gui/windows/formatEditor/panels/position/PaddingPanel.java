package gui.windows.formatEditor.panels.position;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import editor.Format;
import gui.windows.formatEditor.panels.PropertyPanel;

public class PaddingPanel extends JPanel
{
	protected JSpinner leftSize;
	protected JSpinner rightSize;
	protected JSpinner topSize;
	protected JSpinner bottomSize;
	
	public void update(Format format)
	{
		leftSize.setValue(format.getPosition().getPadding().getLeftSize());
		rightSize.setValue(format.getPosition().getPadding().getRightSize());
		topSize.setValue(format.getPosition().getPadding().getTopSize());
		bottomSize.setValue(format.getPosition().getPadding().getBottomSize());
	}
	public void updateFormat(Format format)
	{
		format.getPosition().getPadding().setLeftSize((int) leftSize.getValue());
		format.getPosition().getPadding().setRightSize((int) rightSize.getValue());
		format.getPosition().getPadding().setTopSize((int) topSize.getValue());
		format.getPosition().getPadding().setBottomSize((int) bottomSize.getValue());
		
	}
	public PaddingPanel()
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
