package javascript;

import java.util.LinkedList;

import javascript.header.Header;

public class JavascriptLibrary
{
	protected LinkedList<DomFunction> functions;
	
	protected Header header;
	
	public Header getHeader()
	{
		return header;
	}

	public JavascriptLibrary()
	{
		functions = new LinkedList<>();
		
		header = new Header();
	}
	
	public void addDomFunction(DomFunction function)
	{
		functions.add(function);
	}
}
