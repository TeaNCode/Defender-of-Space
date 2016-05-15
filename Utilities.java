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

    static String intToRomanNumerals(int source)
    {
        String output = "";

        while(source > 0)
        {
            if(source >= 1000)
            {
                source -= 1000;
                output += "M";
            }
            else if(source >= 500)
            {
                source -= 500;
                output += "D";
            }
            else if(source >= 100)
            {
                source -= 100;
                output += "C";
                if(output.endsWith("CCCC"))
                {
                    output = output.substring(0, output.length() - 4);
                    output += "CD";
                }
            }
            else if(source >= 50)
            {
                source -= 50;
                output += "L";
            }
            else if(source >= 10)
            {
                source -= 10;
                output += "X";
                if(output.endsWith("XXXX"))
                {
                    output = output.substring(0, output.length() - 4);
                    output += "XL";
                }
            }
            else if(source >= 5)
            {
                source -= 5;
                output += "V";
            }
            else
            {
                source -= 1;
                output += "I";
                if(output.endsWith("IIII"))
                {
                    output = output.substring(0, output.length() - 4);
                    output += "IV";
                }
            }
        }

        return output;
    }

    /**
     * Digits go from left to right, starting at 1
     * 
     * @param source
     *            The number to get the digit from
     * @param digit
     *            The digit to get
     * @return The number in the digit'th place in source
     */
    static int getNumberAtDigit(int source, int digit)
    {
        if(digit > getSize(source))
            throw new IndexOutOfBoundsException(
                "There aren't " + String.valueOf(digit) + " digits in " + String.valueOf(source) + ".");
        else
        {
            // Remove digits that come after what we want
            for(int i = getSize(source); i > digit; i--)
            {
                source = source / 10;
            }
            // Narrow it to only the last digit and return it
            return source % 10;
        }
    }

    static int getSize(long d)
    {
        String numberS = String.valueOf(d);
        return numberS.length();
    }

    static boolean arrayContains(String[] source, String query)
    {
        for(String test : source)
        {
            if(test != null)
            {
                if(test.equals(query))
                    return true;
            }
        }

        return false;
    }
}
