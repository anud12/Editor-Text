package css;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class Font implements CSS
{
	protected double size;
	protected String fontFamily;
	protected String fontGeneric;
	protected boolean bold;
	protected boolean italic;
	protected boolean underline;
	protected boolean center;
	protected String color;
	
	public Font()
	{
		size = 14;
		color = "inherit";
		fontFamily = "";
		fontGeneric = "";
		bold = false;
		italic = false;
		underline = false;
		center = true;
	}
	@XmlElement( name = "fontFamily")
	public String getFontFamily()
	{
		return fontFamily;
	}

	@XmlElement( name = "fontGeneric")
	public String getFontGeneric()
	{
		return fontGeneric;
	}

	@XmlElement( name = "bold")
	public boolean getBold()
	{
		return bold;
	}
	
	@XmlElement( name = "italic")
	public boolean getItalic()
	{
		return italic;
	}

	@XmlElement( name = "underline")
	public boolean getUnderline()
	{
		return underline;
	}

	@XmlElement( name = "center")
	public boolean getCenter()
	{
		return center;
	}

	@XmlElement( name = "color")
	public String getColor()
	{
		return color;
	}

	@XmlElement( name = "size")
	public double getSize()
	{
		return size;
	}
	public void setColor(String color)
	{
		this.color = color;
	}
	public void setSize(double size)
	{
		this.size = size;
	}
	public void setCenter(boolean bool)
	{
		center = bool;
	}
	public void setFontFamily(String family)
	{
		this.fontFamily = family;
	}
	public void setFontGeneric(String generic)
	{
		this.fontGeneric = generic;
	}
	public void setBold(boolean bold)
	{
		this.bold = bold;
	}
	public void setItalic(boolean italic)
	{
		this.italic = italic;
	}
	public void setUnderLine(boolean underLine)
	{
		this.underline = underLine;
	}
	@Override
	public List<String> getCSS()
	{
		LinkedList<String> strings = new LinkedList<>();
		
		strings.add("font-size : " + size/16 + "em ;");
		
		
		if(fontFamily != "")
		{
			strings.add("font-family : " + fontFamily + ";");
		}
		else
		if(fontGeneric != null)
		{
			strings.add("font-family : " + fontGeneric + ";");
		}
		
		if(bold)
		{
			strings.add("font-weight : bold ;");
		}
		else
		{
			strings.add("font-weight : normal ;");
		}
		if(underline)
		{
			strings.add("text-decoration: underline ;");
		}
		if(italic)
		{
			strings.add("font-style : italic;");
		}
		if(center)
		{
			strings.add("text-align : center ;");
		}
		strings.add("word-wrap: break-word; ");
		strings.add("color : " + color + ";");
		return strings;
	}
}
