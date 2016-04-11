package css;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Background implements CSS
{
	protected String color;
	
	public Element createElement(Document document)
	{
		Element rootElement = document.createElement("background");
		
		Element element = document.createElement("color");
		element.appendChild(document.createTextNode(color));
		
		rootElement.appendChild(element);
		
		return rootElement;
	}
	public Background()
	{
		color = "inherit";
	}
	
	@Override
	public List<String> getCSS()
	{
		LinkedList<String> lines = new LinkedList();
		lines.add("background-color :" + color + ";");
		return lines;
	}
	public void setColor(String color)
	{
		this.color = color;
	}
	@XmlElement( name = "color")
	public String getColor()
	{
		return color;
	}

}
