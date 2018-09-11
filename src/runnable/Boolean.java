package runnable;

import java.util.ArrayList;
import java.util.List;

public class Boolean 
{
	private boolean bool;
	private static List<java.lang.Boolean> boollist = new ArrayList<java.lang.Boolean>();
	
	Boolean(boolean bool)
	{
		this.bool = bool;
		boollist.add(bool);
	}
	
	public static void boolIndex()
	{
		
	}
	
	public boolean booleanValue()
	{
		return bool;
	}
	
	public void setBoolean(boolean bool)
	{
		this.bool = bool;
	}
}
