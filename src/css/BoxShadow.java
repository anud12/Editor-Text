package css;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class BoxShadow implements CSS
{
	protected int hShadow;
	protected int vShadow;
	protected int blurDistance;
	protected int spreadSize;
	protected String color;
	
	public BoxShadow()
	{
		color = "black";
	}
	public void setHShadow(int hShadow)
	{
		this.hShadow = hShadow;
	}
	public void setvShadow(int vShadow)
	{
		this.vShadow = vShadow;
	}
	public void setBlurDistance(int blurDistance)
	{
		this.blurDistance = blurDistance;
	}
	public void setSpreadSize(int spreadSize)
	{
		this.spreadSize = spreadSize;
	}
	public void setColor(String color)
	{
		this.color = color;
	}
	@XmlElement( name = "hShadow")
	public int gethShadow()
	{
		return hShadow;
	}
	@XmlElement( name = "vShadow")
	public int getvShadow()
	{
		return vShadow;
	}
	@XmlElement( name = "blurDistance")
	public int getBlurDistance()
	{
		return blurDistance;
	}
	@XmlElement( name = "spreadSize")
	public int getSpreadSize()
	{
		return spreadSize;
	}
	@XmlElement( name = "color")
	public String getColor()
	{
		return color;
	}
	@Override
	public List<String> getCSS()
	{
		List<String> lines = new LinkedList();
		lines.add("box-shadow : " + hShadow + "px " + vShadow + "px " + blurDistance + "px " + spreadSize + "px " + color + " ;");
		return lines;
	}

}
