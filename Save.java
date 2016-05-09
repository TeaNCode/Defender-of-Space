import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.FileNotFoundException;
/**
 * class for saving the game
 * 
 * @TeaNCode
 */
public abstract class Save  
{
    static void saveWarn(String toWrite, String path)
    {
        //confirms save
        int response = JOptionPane.showConfirmDialog(null,"Warning: Saving will overwrite the current save. Continue?");
        if(response == JOptionPane.OK_OPTION)
            writeSave(toWrite,path);
    }

    private static void writeSave(String toWrite, String path)
    {
        try
        {
            //checks for saving error
            File save = new File(path);
            File saveBackup = new File(path + ".backup");
            if(save.isFile()) 
            {
                if(save.canRead() && save.canWrite()) save.renameTo(saveBackup);
                else JOptionPane.showMessageDialog(null,"Fatal error: Save.sav exists but cannot be read/writen."
                        +"\nPlease try running this project at a different file location");
            }
            writeToFile(toWrite, path);
            saveBackup.delete();
        }
        catch (IOException e)
        {
            //replaces backup
            System.out.println(e + "\nSave file will be replaced from backup");
            File saveBackup = new File(path + ".backup");
            File save = new File(path);
            saveBackup.renameTo(save);
        }
    }

    static void loadSave(String path)
    {
        //saves into file
        File saveFile = new File(path);
        if(saveFile.exists())
        {
            try
            {
                Scanner save = new Scanner(saveFile);
                level = save.nextInt();
                if(save.hasNextInt())
                    money = save.nextInt();
                if(save.hasNextInt())
                    endlessHighScore = save.nextInt();
            }
            catch(FileNotFoundException e)
            {

            }
        }
    }

    private static void writeToFile(String textLine, String path) throws IOException
    {
        //writes info to file
        FileWriter write = new FileWriter(path);
        PrintWriter print_line = new PrintWriter(write);
        print_line.printf("%s" + "%n",textLine);
        print_line.close();
    }

    static String prepareString()
    {
        //returns save
        String toReturn = String.valueOf(level) + " " + String.valueOf(money) + " " + String.valueOf(endlessHighScore);
        return toReturn;
    }

    static void initialize()
    {
        //sets starting amounts
        level = 1;
        money = 0;
        endlessHighScore = 0;
    }

    static boolean loaded;
    static int level;
    static int money;
    static int endlessHighScore;
}
