package editor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import javascript.JavascriptLibrary;
import javascript.header.Header;

@XmlRootElement( name = "library")
public class Library
{
	protected HashMap <String, Format> formats;
	protected LinkedHashSet<Format> usedFormats;
	protected Format defaultFormat;
	protected int ids;
	protected String name;
	protected Reader reader;
	protected JavascriptLibrary javascriptLibrary;

	public Library()
	{
		formats = new HashMap<>();
		usedFormats = new LinkedHashSet<>();
		reader = new Reader(this);
		name = "Not stored on disk";
		javascriptLibrary = new JavascriptLibrary();
	}
	
	public JavascriptLibrary getJavascriptLibrary()
	{
		return javascriptLibrary;
	}

	public void setJavascriptLibrary(JavascriptLibrary javascriptLibrary)
	{
		this.javascriptLibrary = javascriptLibrary;
	}
	
	public Reader getReader()
	{
		return reader;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setDefaultFormat(String tag)
	{
		defaultFormat = formats.get(tag);
	}
	public Format getDefault()
	{
		return defaultFormat;
	}
	public Set<String> getFormatKeys()
	{
		return formats.keySet();
	}
	public void addFormat(Format format)
	{
		if(format.getClass() == Format.class)
		{
			format.setID("style-" + ids++);
			formats.put(format.getTag(), (Format) format);
		}
	}
	public void setFormatKeys()
	{
		ids = 0;
		Iterator<Entry<String, Format>> iterator = formats.entrySet().iterator();
		while(iterator.hasNext())
		{
			iterator.next().getValue().setID("style-" + ids++);
		}
	}
	public boolean isTag(String text)
	{
		if(formats.containsKey(text))
		{
			return true;
		}	
		return false;
	}
	public LinkedHashSet<Format> getUsedFormats()
	{
		return usedFormats;
	}
	@XmlElement( name = "formats")
	public HashMap<String, Format> getFormats ()
	{
		return this.formats;
	}
	public void setFormats(HashMap <String, Format> formats)
	{
		this.formats = formats; 
	}
	public void removeFormat(String key)
	{
		formats.remove(key);
	}
	public Format getFormat(String text)
	{
		if(formats.containsKey(text))
		{
			Format format = formats.get(text);
			
			usedFormats.add(format);
			return format;
		}
		return null;
	}
}
