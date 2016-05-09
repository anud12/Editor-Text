package javascript.header;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import editor.Dom;
import javascript.DomFunction;

public class Header implements DomFunction 
{
	protected InputStream file;
	protected String declaration;
	
	public Header()
	{
		file = getClass().getResourceAsStream("header.js");
		declaration = readDeclaration();		
	}
	
	protected String readDeclaration()
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(file));
		StringBuilder builder = new StringBuilder();
		String string;
		try
		{
			string = reader.readLine();	
			while(string != null)
			{
				builder.append(string);
				builder.append("\n");
				string = reader.readLine();
			}
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return builder.toString();
	}
	
	@Override
	public String getDeclaration()
	{
		return declaration;
	}

	@Override
	public String getFunctionCall(Dom dom)
	{
		String returnValue = new String();
		
		returnValue = "onScrollHeader(" + dom.getID() + ")";
		
		return returnValue;
		
	}

}
