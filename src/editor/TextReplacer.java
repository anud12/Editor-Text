package editor;

import javax.xml.bind.annotation.XmlElement;

public class TextReplacer
{
	protected String replaced;
	protected String replacer;
	protected int maxOccurence;
	protected int currentOccurence;
	protected boolean ignoreFirst;
	protected boolean ignoreDuplicate;
	protected boolean firstReplace = true;
	protected boolean lastReplaced = false;
	
	public TextReplacer()
	{
		firstReplace = true;
	}
	
	public TextReplacer(String replaced, String replacer, boolean ignoreDuplicate, boolean ignoreFirst)
	{
		this.replaced = replaced;
		this.replacer = replacer;
		
		this.ignoreFirst = ignoreFirst;
		this.ignoreDuplicate = ignoreDuplicate;
		firstReplace = true;
	}
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		
		builder.append(replaced.replaceAll("\n", "[newLine]"));
		builder.append(" > ");
		
		builder.append(replacer.replaceAll("\n", "[newLine]"));
		
		return builder.toString();
	}
	@XmlElement( name = "replaced")
	public String getReplaced()
	{
		return replaced;
	}
	public void setReplaced(String replaced)
	{
		this.replaced = replaced;
	}
	@XmlElement( name = "replacer")
	public String getReplacer()
	{
		return replacer;
	}
	public void setReplacer(String replacer)
	{
		this.replacer = replacer;
	}
	@XmlElement( name = "maxOccurence")
	public int getMaxOccurence()
	{
		return maxOccurence;
	}
	public void setMaxOccurence(int maxOccurence)
	{
		this.maxOccurence = maxOccurence;
	}
	@XmlElement( name = "ignoreFirst")
	public boolean isIgnoreFirst()
	{
		return ignoreFirst;
	}
	public void setIgnoreFirst(boolean ignoreFirst)
	{
		this.ignoreFirst = ignoreFirst;
	}
	@XmlElement( name = "ignoreDuplicate")
	public boolean isIgnoreDuplicate()
	{
		return ignoreDuplicate;
	}
	public void setIgnoreDuplicate(boolean ignoreDuplicate)
	{
		this.ignoreDuplicate = ignoreDuplicate;
	}
	@XmlElement( name = "firstReplace")
	public boolean isFirstReplace()
	{
		return firstReplace;
	}
	public void setFirstReplace(boolean firstReplace)
	{
		this.firstReplace = firstReplace;
	}
	@XmlElement( name = "lastReplaced")
	public boolean isLastReplaced()
	{
		return lastReplaced;
	}
	public void setLastReplaced(boolean lastReplaced)
	{
		this.lastReplaced = lastReplaced;
	}
	
	public void reset()
	{
		firstReplace = true;
		lastReplaced = false;
	}
	public String replace(String chunk, boolean isLast)
	{
		if(chunk.equals(replaced))
		{
			if((ignoreFirst && firstReplace) || (lastReplaced && ignoreDuplicate))
			{
				return "";
			}
			lastReplaced = true;
			return replacer;
		}
		
		lastReplaced = false;
		
		firstReplace = false;
		return chunk;
	}
}
