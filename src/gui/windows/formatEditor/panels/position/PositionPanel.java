package gui.windows.formatEditor.panels.position;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import editor.Format;
import gui.windows.formatEditor.panels.PropertyPanel;

public class PositionPanel extends JPanel
{
	protected MarginPanel marginPanel;
	protected PaddingPanel paddingPanel;
	
	public void update (Format format)
	{
		marginPanel.update(format);
		paddingPanel.update(format);
	}
	public void updateFormat(Format format)
	{
		marginPanel.updateFormat(format);
		paddingPanel.updateFormat(format);
	}
	public PositionPanel()
	{
		super();
		this.setAlignmentX(0.5f);
		this.setAlignmentY(0.5f);
		PropertyPanel propertyPanel;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.setBorder(new TitledBorder(null, "Text", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		marginPanel = new MarginPanel();
		marginPanel.setBorder(new TitledBorder(null, "Margin", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.add(marginPanel);
		
		paddingPanel = new PaddingPanel();
		paddingPanel.setBorder(new TitledBorder(null, "Padding", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.add(paddingPanel);
	}

	public MarginPanel getMarginPanel()
	{
		return marginPanel;
	}

	public PaddingPanel getPaddingPanel()
	{
		return paddingPanel;
	}
}
