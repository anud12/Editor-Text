package css;

import java.util.LinkedList;

import javax.xml.bind.annotation.XmlElement;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Border implements CSS
{
	protected String style;

	protected String color;
	protected Double left;
	protected Double right;
	protected Double top;
	protected Double bottom;
	
	public Border()
	{
		top = 0D;
		bottom = 0D;
		right = 0D;
		left = 0D;
		style = "inherit";
		color = "inherit";
	}
	@XmlElement( name = "style")
	public String getStyle()
	{
		return style;
	}

	@XmlElement( name = "color")
	public String getColor()
	{
		return color;
	}
	
	@XmlElement( name = "leftWidth")
	public double getLeftWidth()
	{
		return left;
	}
	
	@XmlElement( name = "rightWidth")
	public double getRightWidth()
	{
		return right;
	}

	@XmlElement( name = "topWidth")
	public double getTopWidth()
	{
		return top;
	}
	
	@XmlElement( name = "bottomWidth")
	public double getBottomWidth()
	{
		return bottom;
	}

	public void setStyle(String style)
	{
		this.style = style;
	}
	
	public void setColor(String color)
	{
		this.color = color;
	}
	
	public void setWidth(Double width)
	{
		left = width;
		right = width;
		top = width;
		bottom = width;
	}
	public void setTop(Double width)
	{
		top = width;
	}
	public void setBottom(Double width)
	{
		bottom = width;
	}
	public void setLeft(Double width)
	{
		left = width;
	}
	public void setRight(Double double1)
	{
		right = double1;
	}
	
	public LinkedList<String> getCSS()
	{
		LinkedList<String> strings = new LinkedList<String>();
		strings.add("border-style : " + style + ";");
		strings.add("border-color : " + color + ";");
		strings.add("border-width : " + top + "px " + right + "px " + bottom + "px " + left + "px ;");
		strings.add("border-collapse : collapse ;");
		
		return strings;
	}
}
