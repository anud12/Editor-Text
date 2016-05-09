package editor;

import java.util.Iterator;
import java.util.LinkedList;

public class Dom
{
	protected StringBuilder text;
	protected Format format;
	protected String id;
	protected LinkedList<Dom> parents;
	
	public Dom(String id)
	{
		text = new StringBuilder();
		this.id = id;
		parents = new LinkedList<>();
		
	}
	public String getID()
	{
		return id;
	}
	public void addParent(Dom div)
	{
		parents.add(div);
	}
	public void clearText()
	{
		text.setLength(0);
	}
	public void append(String text)
	{
		this.text.append(text);
	}
	public void setFormat(Format format)
	{
		this.format = format;
	}
	public Format getFormat()
	{
		return this.format;
	}
	public String getText()
	{
		return text.toString();
	}
	protected String createContainerDiv(String style)
	{
		String returnVal = "";
		returnVal += "<div ";
		
		returnVal += "id = 'wrapper-" + this.id + "' \n";
		returnVal += "format = '" + format.getTag() + "' \n";
		returnVal += "newLine = '" + format.getNewLine() + "' \n";
		
		returnVal += "style = '" + style + "' ";
		
		returnVal += "class = '";
		returnVal += format.getWrapperID() + " ";
		Iterator<Dom> divIterator = parents.iterator();
		
		while(divIterator.hasNext())
		{
			Dom div = divIterator.next();
			returnVal += "wrapper-childOf-" + div.getID() + " ";
		}
		returnVal += "' ";
		returnVal += ">\n";
		
		return returnVal;
	}
	public void replaceText()
	{
		String replacedText = format.processText(text.toString());
		text.setLength(0);
		text.append(replacedText);
	}
	public String getHml()
	{
		String returnVal = "";		
		
		/*
		if(format.getCenteredDom())
		{
			returnVal += createContainerDiv("");
		}
		else
		{
			if(format.getNewLine())
			{
				returnVal += createContainerDiv("display : block");
			}
		}
		*/
		if(format.getNewLine())
		{
			returnVal += createContainerDiv("display : block");
		}
		else
		{
			returnVal += createContainerDiv("");
		}
		returnVal += "<"+ format.getDomTag() + "\n";
		
		returnVal += "id = '" + this.id + "' \n";
		returnVal += "format = '" + format.getTag() + "' \n";
		returnVal += "newLine = '" + format.getNewLine() + "' \n";
		returnVal += "class = '";
		returnVal += format.getID() + " ";
		
		Iterator<Dom> divIterator = parents.iterator();
		
		while(divIterator.hasNext())
		{
			Dom div = divIterator.next();
			returnVal += "childOf-" + div.getID() + " ";
		}
		returnVal += "'";
		returnVal += "\n";
		
		returnVal += ">\n";
		returnVal += text.toString();
		
		returnVal += "</" + format.getDomTag() +">\n";
		/*
		if(format.getCenteredDom())
		{
			returnVal += "</div>\n";
		}
		else
		{
			if(format.getNewLine())
			{
				returnVal += "</div>\n";
			}
		}
		*/
		returnVal += "</div>\n";
		return returnVal;
	}
	
}
