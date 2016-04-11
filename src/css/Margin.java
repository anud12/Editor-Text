package css;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Margin implements CSS
{
	protected int left;
	protected int right;
	protected int top;
	protected int bottom;
	
	public Margin()
	{
		left = 0;
		right = 0;
		top = 0;
		bottom = 0;
	}
	
	public Margin clone()
	{
		Margin clone = new Margin();
		clone.setLeftSize(left);
		clone.setRightSize(right);
		clone.setTopSize(top);
		clone.setBottomSize(bottom);
		
		return clone;
	}
	public void setSize(int size)
	{
		left = size;
		right = size;
		top = size;
		bottom = size;
	}
	@XmlElement( name = "left")
	public int getLeftSize()
	{
		return left;
	}
	@XmlElement( name = "right")
	public int getRightSize()
	{
		return right;
	}
	@XmlElement( name = "top")
	public int getTopSize()
	{
		return top;
	}
	@XmlElement( name = "bottom")
	public int getBottomSize()
	{
		return bottom;
	}
	public void setLeftSize(int size)
	{
		left = size;
	}
	public void setRightSize(int size)
	{
		right = size;
	}
	public void setTopSize(int size)
	{
		top = size;
	}
	public void setBottomSize(int size)
	{
		bottom = size;
	}
	@Override
	public List<String> getCSS()
	{
		LinkedList<String> strings = new LinkedList<String>();
		strings.add("margin-left : " + left + "px ;");
		strings.add("margin-right : " + right + "px ;");
		strings.add("margin-top : " + top + "px ;");
		strings.add("margin-bottom : " + bottom + "px ;");
		return strings;
	}
}
