import java.util.ArrayList;
/**
 * Just some utility methods
 * 
 * @author Tea N' Code
 */
public abstract class Utilities  
{
    static String arrayToString(String[] source)
	{
		String output = "";
		for(String temp : source)
		{
			output = output + " " + temp;
		}
		
		return output.substring(1, output.length());
	}
	
	static String arrayListToString(ArrayList<String> source)
	{
	    String[] blahArray = {"bkah"};
	    return arrayToString(source.toArray(blahArray));
	}
}
