package css;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Padding implements CSS
{
	protected int left;
	protected int right;
	protected int top;
	protected int bottom;
	
	public Padding()
	{
		left = 0;
		right = 0;
		top = 0;
		bottom = 0;
	}
	public Padding clone()
	{
		Padding clone = new Padding();
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
		strings.add("padding-left : " + left + "px ;");
		strings.add("padding-right : " + right + "px ;");
		strings.add("padding-top : " + top + "px ;");
		strings.add("padding-bottom : " + bottom + "px ;");
		return strings;
	}
}
