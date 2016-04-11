package gui.windows.formatEditor.panels;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import editor.Format;
import gui.windows.formatEditor.FormatEditor;

public class FormatSpecificPanel extends JPanel
{
	protected JTextField tag;
	protected JTextArea preText;
	protected JCheckBox hidden;
	protected JCheckBox centeredDom;
	protected JCheckBox newLine;
	protected JCheckBox hasChildren;
	
	public FormatSpecificPanel()
	{
		super();
		this.setAlignmentX(0.5f);
		this.setAlignmentY(0.5f);
		PropertyPanel propertyPanel;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		tag = new JTextField();
		propertyPanel = new PropertyPanel("Tag", tag);
		this.add(propertyPanel);
		
		preText = new JTextArea();
		preText.setBorder(BorderFactory.createEtchedBorder());
		propertyPanel = new PropertyPanel("Pre Text", preText);
		propertyPanel.setHeightIncrement(3);
		this.add(propertyPanel);
		
		hidden = new JCheckBox();
		propertyPanel = new PropertyPanel("Hidden", hidden);
		this.add(propertyPanel);
		
		centeredDom = new JCheckBox();
		propertyPanel = new PropertyPanel("Center", centeredDom);
		this.add(propertyPanel);
		
		newLine = new JCheckBox();
		propertyPanel = new PropertyPanel("On new line", newLine);
		this.add(propertyPanel);
		
		hasChildren = new JCheckBox();
		propertyPanel = new PropertyPanel("Has Children", hasChildren);
		this.add(propertyPanel);
	}
	public void updateFormat(Format format)
	{
		format.setTag(tag.getText());
		format.setPreText(preText.getText());
		format.setHidden(hidden.isSelected());
		format.setCenteredDom(centeredDom.isSelected());
		format.setNewLine(newLine.isSelected());
		format.setHasChildren(hasChildren.isSelected());
	}
	public void update(Format format)
	{
		tag.setText(format.getTag());
		preText.setText(format.getPreText());
		hidden.setSelected(format.getHidden());
		centeredDom.setSelected(format.getCenteredDom());
		newLine.setSelected(format.getNewLine());
		hasChildren.setSelected(format.getNewLine());
	}
	public JTextField getTag()
	{
		return tag;
	}
}
