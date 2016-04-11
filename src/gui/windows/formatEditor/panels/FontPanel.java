package gui.windows.formatEditor.panels;

import java.awt.GraphicsEnvironment;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.StyledEditorKit.FontFamilyAction;

import editor.Format;

public class FontPanel extends JPanel
{
	protected JPanel panel;
	
	protected JComboBox<String> fontGeneric;
	protected JSpinner fontSize;
	protected JComboBox<String> fontName;
	protected JCheckBox bold;
	protected JCheckBox italic;
	protected JCheckBox underline;
	
	public void resetFontName()
	{
		fontName.removeAllItems();
		fontName.addItem("");
		String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		for(int i = 0 ; i < fonts.length ; i++)
		{
			fontName.addItem(fonts[i]);
		}
	}
	protected void selectFontName(Format format)
	{
		String font = format.getFont().getFontFamily();
		int i = 0;
		int count = fontName.getItemCount();
		boolean found = false;
		while(i < count)
		{
			if(fontName.getItemAt(i).equalsIgnoreCase(font))
			{
				found = true;
				break;
			}
			i++;
		}
		if(found)
		{
			fontName.setSelectedIndex(i);
		}
		else
		{
			fontName.addItem(font + " - External");
			fontName.setSelectedIndex(fontName.getItemCount() - 1);
		}
	}
	
	protected void selectFontGeneric(Format format)
	{
		String font = format.getFont().getFontGeneric();
		int i = 0;
		int count = fontGeneric.getItemCount();
		boolean found = false;
		while(i < count)
		{
			if(fontGeneric.getItemAt(i).equalsIgnoreCase(font))
			{
				found = true;
				break;
			}
			i++;
		}
		if(found)
		{
			fontGeneric.setSelectedIndex(i);
		}
		else
		{
			fontGeneric.setSelectedIndex(0);
		}
	}
	
	public void update(Format format)
	{
		resetFontName();
		
		selectFontName(format);
		
		selectFontGeneric(format);
		
		fontSize.setValue(format.getFont().getSize());
		
		bold.setSelected(format.getFont().getBold());
		italic.setSelected(format.getFont().getItalic());
		underline.setSelected(format.getFont().getUnderline());
	}
	public void updateFormat(Format format)
	{
		format.getFont().setFontFamily((String) fontName.getSelectedItem());
		format.getFont().setFontGeneric((String) fontGeneric.getSelectedItem());
		
		format.getFont().setSize((double) Double.valueOf(fontSize.getValue().toString()));
		
		format.getFont().setBold(bold.isSelected());
		format.getFont().setItalic(italic.isSelected());
		format.getFont().setUnderLine(underline.isSelected());
	}
	public FontPanel()
	{
		super();
		this.setAlignmentX(0.5f);
		this.setAlignmentY(0.5f);
		this.setBorder(new TitledBorder(null, "Font", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel = new JPanel();
		PropertyPanel propertyPanel;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		fontName = new JComboBox<String>();
		JButton button = new JButton("Open File");
		propertyPanel = new PropertyPanel("Font name", fontName, button);
		this.add(propertyPanel);
		
		fontGeneric = new JComboBox<String>();
		fontGeneric.addItem("Serif");
		fontGeneric.addItem("Sans Serif");
		fontGeneric.addItem("Monospace");
		
		propertyPanel = new PropertyPanel("Font generic", fontGeneric);
		this.add(propertyPanel);
		
		fontSize = new JSpinner();
		propertyPanel = new PropertyPanel("Font size", fontSize);
		this.add(propertyPanel);
		
		bold = new JCheckBox();
		propertyPanel = new PropertyPanel("Bold", bold);
		this.add(propertyPanel);
		
		italic = new JCheckBox();
		propertyPanel = new PropertyPanel("Italic", italic);
		this.add(propertyPanel);
		
		underline = new JCheckBox();
		propertyPanel = new PropertyPanel("Underline", underline);
		this.add(propertyPanel);
		
		this.resetFontName();
	}

	public JPanel getPanel()
	{
		return panel;
	}

	public JComboBox<String> getFontGeneric()
	{
		return fontGeneric;
	}

	public JSpinner getFontSize()
	{
		return fontSize;
	}

	public JComboBox<String> getFontName()
	{
		return fontName;
	}

	public JCheckBox getBold()
	{
		return bold;
	}

	public JCheckBox getItalic()
	{
		return italic;
	}

	public JCheckBox getUnderline()
	{
		return underline;
	}
}
