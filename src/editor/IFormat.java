package editor;

public interface IFormat
{
	public String getCSSClass();
	public String getTag();
	public boolean getHasChildren();
	public String processText(String text);
	public void setID(String id);
	public String getID();
}
