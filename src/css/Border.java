package css;

import java.util.LinkedList;

import javax.xml.bind.annotation.XmlElement;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Border implements CSS
{
	protected String style;

	protected String color;
	protected int left;
	protected int right;
	protected int top;
	protected int bottom;
	
	public Border()
	{
		top = 0;
		bottom = 0;
		right = 0;
		left = 0;
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
	
	@XmlElement( name = "left")
	public int getLeft()
	{
		return left;
	}
	
	@XmlElement( name = "right")
	public int getRight()
	{
		return right;
	}

	@XmlElement( name = "top")
	public int getTop()
	{
		return top;
	}
	
	@XmlElement( name = "bottom")
	public int getBottom()
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
	
	public void setWidth(int width)
	{
		left = width;
		right = width;
		top = width;
		bottom = width;
	}
	public void setTop(int width)
	{
		top = width;
	}
	public void setBottom(int width)
	{
		bottom = width;
	}
	public void setLeft(int width)
	{
		left = width;
	}
	public void setRight(int double1)
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
