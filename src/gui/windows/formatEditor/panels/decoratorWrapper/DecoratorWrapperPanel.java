package gui.windows.formatEditor.panels.decoratorWrapper;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import editor.Format;

public class DecoratorWrapperPanel extends JPanel
{	
	protected BorderWrapperPanel borderPanel;
	protected BoxShadowPanel boxShadowPanel;
	protected BackgroundWrapperPanel backgroundPanel;
	
	public void update(Format format)
	{
		borderPanel.update(format);
		boxShadowPanel.update(format);
		backgroundPanel.update(format);
	}
	public void updateFormat(Format format)
	{
		borderPanel.updateFormat(format);
		boxShadowPanel.updateFormat(format);
		backgroundPanel.updateFormat(format);
	}
	public DecoratorWrapperPanel()
	{
		super();
		this.setAlignmentX(0.5f);
		this.setAlignmentY(0.5f);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.setBorder(new TitledBorder(null, "Wrapper", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		borderPanel = new BorderWrapperPanel();
		borderPanel.setBorder(new TitledBorder(null, "Border", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.add(borderPanel);
		
		boxShadowPanel = new BoxShadowPanel();
		boxShadowPanel.setBorder(new TitledBorder(null, "Box Shadow", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.add(boxShadowPanel);
		
		backgroundPanel = new BackgroundWrapperPanel();
		backgroundPanel.setBorder(new TitledBorder(null, "Background", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.add(backgroundPanel);
	}

	public BorderWrapperPanel getBorderPanel()
	{
		return borderPanel;
	}

	public BoxShadowPanel getBoxShadowPanel()
	{
		return boxShadowPanel;
	}

	public BackgroundWrapperPanel getBackgroundPanel()
	{
		return backgroundPanel;
	}
}
