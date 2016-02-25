import javax.swing.JOptionPane;
import java.util.Scanner;
/**
 * Write a description of class DevConsole here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DevConsole  
{
    //Makes the player invulnerable
    static boolean invulnerable;
    //More enemy attacks
    static int attackMultiplier;
    //Bullets collide with each other.
    static boolean realism;
    //Allows the player to go past where the enemies can shoot on the X axis
    static boolean hiding;
    //Allows the player to fire without reloading
    static boolean minigun;
    static void showConsole()
    {
        String sInput = JOptionPane.showInputDialog("Enter a command: ");
        Scanner input = new Scanner(sInput);
        if(input.hasNext())
        {
            String next = input.next();
            next = next.toLowerCase();
            switch(next)
            {
                case "invulnerable": invulnerable(input); break;
                case "god": invulnerable(input); break;
                case "attackmultiplier": attackMultiplier(input); break;
                case "attack": attackMultiplier(input); break;
                case "realism": realism(input); break;
                case "real": realism(input); break;
                case "realistic": realism(input); break;
                case "hiding": hiding(input); break;
                case "hide": hiding(input); break;
                case "hider": hiding(input); break;
                case "minigun": minigun(input); break;
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Error: Input expected.");
        }
    }

    static void initialize()
    {
        invulnerable = false;
        attackMultiplier = 1;
        realism = true;
        hiding = false;
        minigun = false;
    }

    /**
     * This is called by, and only by showConsole.
     */
    static void invulnerable(Scanner input)
    {
        if(input.hasNextBoolean())
        {
            invulnerable = input.nextBoolean();
        }
        else
            JOptionPane.showMessageDialog(null,"Invulnerable is " + String.valueOf(invulnerable));
    }

    static void attackMultiplier(Scanner input)
    {
        if(input.hasNextInt())
        {
            attackMultiplier = input.nextInt();
        }
        else
            JOptionPane.showMessageDialog(null,"Attack Multiplier is " + String.valueOf(attackMultiplier) + "x");
    }
    
    static void realism(Scanner input)
    {
        if(input.hasNextBoolean())
        {
            realism = input.nextBoolean();
        }
        else
            JOptionPane.showMessageDialog(null,"Realism is " + String.valueOf(realism));
    }
    
    static void hiding(Scanner input)
    {
        if(input.hasNextBoolean())
        {
            hiding = input.nextBoolean();
        }
        else
            JOptionPane.showMessageDialog(null,"Hiding is " + String.valueOf(hiding));
    }
    
    static void minigun(Scanner input)
    {
        if(input.hasNextBoolean())
        {
            minigun = input.nextBoolean();
        }
        else
            JOptionPane.showMessageDialog(null,"Minigun is " + String.valueOf(minigun));
    }
}
