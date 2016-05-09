package css;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Position implements CSS
{
	protected Margin margin;
	protected Padding padding;
	protected int zIndex = 1;
	
	
	
	public Position ()
	{
		margin = new Margin();
		padding = new Padding();
	}
	public void setzIndex(int index)
	{
		zIndex = index;
	}
	@XmlElement( name = "zIndex")
	public int getzIndex()
	{
		return zIndex;
	}
	@XmlElement( name = "margin")
	public Margin getMargin()
	{
		return margin;
	}
	@XmlElement( name = "padding")
	public Padding getPadding()
	{
		return padding;
	}
	public void setPadding(Padding padding)
	{
		this.padding = padding;
	}
	public void setMargin(Margin margin)
	{
		this.margin = margin;
	}
	@Override
	public List<String> getCSS()
	{
		List<String> lines = margin.getCSS();
		lines.addAll(padding.getCSS());
		lines.add("z-index :" + zIndex + "; ");
		return lines;
	}

}
