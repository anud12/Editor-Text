package editor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Reader
{
	protected Library library;
	protected ArrayList<Dom> parentDom;
	
	public Reader(Library library)
	{
		this.library = library;
		parentDom = new ArrayList<>();
	}
	
	@SuppressWarnings("unused")
	protected LinkedList<Dom> buildDivs(String text)
	{
		library.setDefaultFormat("/p");
		LinkedList<Dom> returnDoms = new LinkedList<>();
		String[] chunks = text.split(" ");
		
		Dom currentDom = new Dom("first");
		Format currentFormat = library.getDefault();
		for(int i = 0; i < chunks.length ; i++)
		{
			String chunk = chunks[i];
			
			if(library.isTag(chunk))
			{
				Format format = (Format) library.getFormat(chunk);
				
				Dom tempDom = new Dom(String.valueOf(i));
				tempDom.setFormat(format);
				ListIterator<Dom> divIterator = parentDom.listIterator();
				while(divIterator.hasNext())
				{
					Dom div = divIterator.next();
					if(tempDom.getFormat().getTag() != div.getFormat().getTag())
					{
						tempDom.addParent(div);
					}
				}
				
				currentFormat = format;
				currentDom = tempDom;
				returnDoms.add(currentDom);
				
				if(format.getHasChildren())
				{
					divIterator = parentDom.listIterator();
					boolean delete = false;
					while(divIterator.hasNext())
					{
						Dom div = divIterator.next();
						if(currentDom.getFormat().getTag() == div.getFormat().getTag())
						{
							delete = true;
						}
						if(delete)
						{
							divIterator.remove();
						}
					}
					parentDom.add(currentDom);
				}
				
			}
			
			else
			{	
				if(chunk.length() > 0)
				{
					currentDom.append(chunk + " ");
				}
			}
		}
		
		return returnDoms;
	}
	
	public String process(String text)
	{
		LinkedList<Dom> divs = buildDivs(text);
		StringBuilder returnVal = new StringBuilder();
		
		returnVal.append("<head>\n");
		
		//Style
		
		returnVal.append("<style>\n");
		Iterator<Format> formatIterator = library.getUsedFormats().iterator();
		
		while(formatIterator.hasNext())
		{
			Format format = formatIterator.next();
			returnVal.append(format.getCSS());
		}
		
		returnVal.append("</style>\n");
		
		returnVal.append("</head>\n");
		
		//Divs
		
		returnVal.append("<body style = ' margin : 0 '>\n");
		Iterator<Dom> iterator = divs.iterator();
		
		while(iterator.hasNext())
		{
			Dom div = iterator.next();
			div.replaceText();
			returnVal.append(div.getHml());
		}
		
		//Javascript
		
		returnVal.append("<script>\n");
		returnVal.append(library.getJavascriptLibrary().getHeader().getDeclaration());
		
		iterator = divs.iterator();
		
		while(iterator.hasNext())
		{
			Dom div = iterator.next();
			if(div.getFormat().getHeader())
			{
				returnVal.append(library.getJavascriptLibrary().getHeader().getFunctionCall(div) + ";" + "\n");
			}
		}
		
		returnVal.append("</script>");
		returnVal.append("</body>\n");
		return returnVal.toString();
	}
}
