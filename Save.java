import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.FileNotFoundException;
/**
 * Write a description of class Save here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Save  
{
    static void saveWarn(String toWrite, String path)
    {
        int response = JOptionPane.showConfirmDialog(null,"Warning: Saving will overwrite the current save. Continue?");
        if(response == JOptionPane.OK_OPTION)
            writeSave(toWrite,path);
    }

    private static void writeSave(String toWrite, String path)
    {
        try
        {
            File save = new File(path);
            File saveBackup = new File(path + ".backup");
            if(save.isFile()) 
            {
                if(save.canRead() && save.canWrite()) save.renameTo(saveBackup);
                else JOptionPane.showMessageDialog(null,"Fatal error: Save.txt exists but cannot be read/writen."
                        +"\nPlease try running this project at a different file location");
            }
            writeToFile(toWrite, path);
            saveBackup.delete();
        }
        catch (IOException e)
        {
            System.out.println(e + "\nSave file will be replaced from backup");
            File saveBackup = new File(path + ".backup");
            File save = new File(path);
            saveBackup.renameTo(save);
        }
    }

    static void loadSave(String path)
    {
        File saveFile = new File(path);
        if(saveFile.exists())
        {
            try
            {
                Scanner save = new Scanner(saveFile);
                level = save.nextInt();
            }
            catch(FileNotFoundException e)
            {
                initialize();
            }
        }
    }

    private static void writeToFile(String textLine, String path) throws IOException
    {
        FileWriter write = new FileWriter(path);
        PrintWriter print_line = new PrintWriter(write);
        print_line.printf("%s" + "%n",textLine);
        print_line.close();
    }

    static String prepareString()
    {
        String toReturn = String.valueOf(level);
        return toReturn;
    }

    static void initialize()
    {
        level = 1;
    }

    static boolean loaded;
    static int level;
}
