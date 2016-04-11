package css;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Decorator implements CSS
{
	protected Border border;
	protected BoxShadow boxShadow;
	protected Background background;
	
	public Decorator()
	{
		border = new Border();
		boxShadow = new BoxShadow();
		background = new Background();
	}
	@XmlElement( name = "border")
	public Border getBorder()
	{
		return border;
	}
	public void setBorder(Border border)
	{
		this.border = border;
	}
	@XmlElement( name = "boxShadow")
	public BoxShadow getBoxShadow()
	{
		return boxShadow;
	}
	@XmlElement( name = "background")
	public Background getBackground()
	{
		return background;
	}
	@Override
	public List<String> getCSS()
	{
		List<String> lines = border.getCSS();
		lines.addAll(boxShadow.getCSS());
		lines.addAll(background.getCSS());
		return lines;
	}

}
