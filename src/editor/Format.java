package editor;

import java.util.Iterator;
import java.util.LinkedList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import css.Decorator;
import css.Font;
import css.Position;

@XmlRootElement( name = "format")
public class Format
{	
	protected String tag;
	
	protected Decorator decorator;
	protected Position position;
	protected Font font;
	
	protected Decorator wrapperDecorator;
	protected Position wrapperPosition;
	
	protected boolean centeredDom;
	protected boolean hidden;
	protected String preText;
	protected boolean newLine;
	protected boolean hasChildren;
	protected String id;
	protected String domTag;
	protected boolean isHeader;
	
	protected LinkedList<TextReplacer> replacers;
	
	public Format()
	{
		preText = "";
		replacers = new LinkedList<TextReplacer>();
		
		this.domTag = "div";
		this.font = new Font();
		
		this.decorator = new Decorator();
		this.position = new Position();
		this.wrapperDecorator = new Decorator();
		this.wrapperPosition = new Position();
	}
	public Format(String tag)
	{
		this.tag = tag;
		preText = "";
		replacers = new LinkedList<TextReplacer>();
		
		this.domTag = "div";
		this.font = new Font();
		
		this.decorator = new Decorator();
		this.position = new Position();
		this.wrapperDecorator = new Decorator();
		this.wrapperPosition = new Position();
	}
	
	public LinkedList<TextReplacer> getReplacers()
	{
		return replacers;
	}
	@XmlElement( name = "header")
	public boolean getHeader()
	{
		return isHeader;
	}
	public void setHeader(boolean isHeader)
	{
		this.isHeader = isHeader;
	}
	@XmlElement( name = "replacers")
	public void setReplacers(LinkedList<TextReplacer> replacers)
	{
		this.replacers = replacers;
	}
	public void setDecorator(Decorator decorator)
	{
		this.decorator = decorator;
	}
	public void setPosition(Position position)
	{
		this.position = position;
	}
	public void setFont(Font font)
	{
		this.font = font;
	}
	public void setWrapperDecorator(Decorator wrapperDecorator)
	{
		this.wrapperDecorator = wrapperDecorator;
	}
	public void setWrapperPosition(Position wrapperPosition)
	{
		this.wrapperPosition = wrapperPosition;
	}
	
	public void setTag(String tag)
	{
		this.tag = tag;
	}
	public void setDomTag(String domTag)
	{
		this.domTag = domTag;
	}
	@XmlAttribute( name = "dom_tag")
	public String getDomTag()
	{
		return domTag;
	}
	@XmlElement( name = "decorator")
	public Decorator getDecorator()
	{
		return decorator;
	}
	@XmlElement( name = "wrapper_decorator")
	public Decorator getWrapperDecorator()
	{
		return wrapperDecorator;
	}
	@XmlElement( name = "font")
	public Font getFont()
	{
		return this.font;
	}
	@XmlElement( name = "position")
	public Position getPosition()
	{
		return position;
	}
	@XmlElement( name = "wrapper_position")
	public Position getWrapperPosition()
	{
		return wrapperPosition;
	}
	@XmlAttribute( name = "tag")
	public String getTag()
	{
		return tag;
	}
	public void setID(String id)
	{
		this.id = id;
	}
	public String getID()
	{
		return id;
	}
	public String getWrapperID()
	{
		return "wrapper-" + id;
	}
	public void setReplaceOrder(TextReplacer replacer)
	{
		replacers.add(replacer);
	}
	@XmlAttribute( name = "hasChildren")
	public void setHasChildren(boolean bool)
	{
		hasChildren = bool;
	}
	public boolean getHasChildren()
	{
		return hasChildren;
	}
	@XmlElement( name = "preText")
	public void setPreText(String text)
	{
		this.preText = text;
	}
	public String getPreText()
	{
		return this.preText;
	}
	@XmlAttribute( name = "newLine")
	public void setNewLine(boolean bool)
	{
		newLine = bool;
	}
	public boolean getNewLine()
	{
		return newLine;
	}
	public String getPretext()
	{
		return this.preText;
	}
	public boolean getHidden()
	{
		return this.hidden;
	}
	@XmlAttribute( name = "hidden")
	public void setHidden(boolean bool)
	{
		this.hidden = bool;
	}
	@XmlAttribute( name = "center")
	public void setCenteredDom(boolean bool)
	{
		this.centeredDom = bool;
	}
	public boolean getCenteredDom()
	{
		return centeredDom;
	}
	public String getWrapperCSSClass()
	{
		StringBuilder builder = new StringBuilder();
		builder.append(".wrapper-");
		builder.append(String.valueOf(id));
		builder.append("\n{\n");
		
		if(hidden)
		{
			builder.append("    display : none;\n");
		}
		else
		{
				builder.append("    display : block;\n");
		}
		if(centeredDom)
		{
			builder.append("text-align : center;\n ");
			/*
			builder.append("    display : table;\n");
			builder.append("    margin : 0 auto;\n");
			*/
		}
		builder.append("    position : relative;\n");
		
		//Position
		Iterator<String> positionCSS = wrapperPosition.getCSS().iterator();
		while(positionCSS.hasNext())
		{
			String css = positionCSS.next();
			builder.append("    " + css + "\n");
		}
		
		//Decorator
		Iterator<String> decoratorCSS = wrapperDecorator.getCSS().iterator();
		while(decoratorCSS.hasNext())
		{
			String css = decoratorCSS.next();
			builder.append("    " + css + "\n");
		}
		builder.append("}\n");
		
		return builder.toString();
	}
	public String getCSSClass()
	{
		StringBuilder builder = new StringBuilder();
		builder.append(".");
		builder.append(String.valueOf(id));
		builder.append("\n{\n");
		
		builder.append("    tag : " + tag + ";\n");
		
		if(hidden)
		{
			builder.append("    position : none;\n");
		}
		else
		{
				builder.append("    display : inline-block;\n");
		}
		if(centeredDom)
		{
			builder.append("    text-align : center;\n");
		}
		builder.append("    position : relative;\n");
		//Position
		Iterator<String> positionCSS = position.getCSS().iterator();
		while(positionCSS.hasNext())
		{
			String css = positionCSS.next();
			builder.append("    " + css + "\n");
		}
		//Fonts
		Iterator<String> fontCSS = font.getCSS().iterator();
		while(fontCSS.hasNext())
		{
			String css = fontCSS.next();
			builder.append("    " + css + "\n");
		}
		//Decorator
		Iterator<String> decoratorCSS = decorator.getCSS().iterator();
		while(decoratorCSS.hasNext())
		{
			String css = decoratorCSS.next();
			builder.append("    " + css + "\n");
		}
		builder.append("}\n");
		return builder.toString();
	}
	public String getCSS()
	{
		StringBuilder returnVal = new StringBuilder();
		
		returnVal.append(getWrapperCSSClass());
		returnVal.append(getCSSClass());
		
		return returnVal.toString();
	}
	public String processText(String text)
	{
		String returnVal = this.preText + " ";
		
		String[] chunks = text.split(" ");
		
		Iterator<TextReplacer> replacersIterator = replacers.iterator();
		while(replacersIterator.hasNext())
		{
			TextReplacer key = replacersIterator.next();
			key.reset();
		}
		for(int i = 0 ; i < chunks.length ; i++)
		{
			replacersIterator = replacers.iterator();
			
			while(replacersIterator.hasNext())
			{
				TextReplacer key = replacersIterator.next();
				chunks[i] = key.replace(chunks[i], (i == chunks.length - 1));
					
			}
			returnVal += chunks[i] + " ";
		}
		
		return returnVal;
	}
}
