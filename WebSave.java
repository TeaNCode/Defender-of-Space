import greenfoot.UserInfo;
import javax.swing.JOptionPane;
/**
 * Write a description of class WebSave here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WebSave  
{
    static void saveWarn()
    {
        int response = JOptionPane.showConfirmDialog(null,"Warning: Saving will overwrite the current save. Continue?");
        if(response == JOptionPane.OK_OPTION)
            writeSave();
    }

    private static void writeSave()
    {
        if(UserInfo.isStorageAvailable())
        {
            UserInfo user = UserInfo.getMyInfo();
            user.setScore(level);
            if(!user.store())
            JOptionPane.showMessageDialog(null,"Something went wrong. Saving failed.","Error occured",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Something went wrong. Saving failed.","Error occured",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    static void loadSave()
    {
        if(UserInfo.isStorageAvailable())
        {
            UserInfo user = UserInfo.getMyInfo();
            level = user.getScore();
            if(level == 0)
            level = 1;
        }
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
