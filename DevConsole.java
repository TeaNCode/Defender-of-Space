import javax.swing.JOptionPane;
import java.util.Scanner;
/**
 * class for hacks("Testing") and overall detection
 * 
 * @TeaNCode
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
    //Enemies more likely to drop powerups
    static int powerupMultiplier;
    //Makes enemies more likely to do their special
    static int specialMultiplier;
    static void showConsole()
    {
        String sInput = JOptionPane.showInputDialog("Enter a command: ");
        //prompts command
        try
        {
            Scanner input = new Scanner(sInput);
            //gets command
            if(input.hasNext())
            {
                String next = input.next();
                next = next.toLowerCase();
                switch(next)
                {
                    //checks what command was to execute it
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
                    case "powerup": powerupMultiplier(input); break;
                    case "powerupMultiplier": powerupMultiplier(input); break;
                    case "special": specialMultiplier(input); break;
                    case "specialMultiplier": specialMultiplier(input); break;
                    case "level": level(input); break;
                    case "money": money(input); break;
                    case "cash": money(input); break;
                }
            }
        }
        catch(NullPointerException e)
        {

        }
    }

    static void initialize()
    {
        //sets initial values
        invulnerable = false;
        attackMultiplier = 1;
        realism = true;
        hiding = false;
        minigun = false;
        powerupMultiplier = 1;
        specialMultiplier = 1;
    }

    /**
     * This is called by, and only by showConsole.
     */
    static void invulnerable(Scanner input)
    {
        //sets invulnerablity
        if(input.hasNextBoolean())
        {
            invulnerable = input.nextBoolean();
        }
        else
            JOptionPane.showMessageDialog(null,"Invulnerablility is " + String.valueOf(invulnerable) + ".");
    }

    static void attackMultiplier(Scanner input)
    {
        //sets attack speed multiplier
        if(input.hasNextInt())
        {
            attackMultiplier = input.nextInt();
        }
        else
            JOptionPane.showMessageDialog(null,"Enemies' attack multiplier is " + String.valueOf(attackMultiplier) + "x.");
    }

    static void realism(Scanner input)
    {
        //sets realism
        if(input.hasNextBoolean())
        {
            realism = input.nextBoolean();
        }
        else
            JOptionPane.showMessageDialog(null,"Realism is " + String.valueOf(realism) + ".");
    }

    static void hiding(Scanner input)
    {
        //sets boundaries
        if(input.hasNextBoolean())
        {
            hiding = input.nextBoolean();
        }
        else
            JOptionPane.showMessageDialog(null,"Hiding is " + String.valueOf(hiding) + ".");
    }

    static void minigun(Scanner input)
    {
        //sets minigun(no reload time)
        if(input.hasNextBoolean())
        {
            minigun = input.nextBoolean();
        }
        else
            JOptionPane.showMessageDialog(null,"Minigun is " + String.valueOf(minigun) + ".");
    }
    
    static void powerupMultiplier(Scanner input)
    {
        //sets power up spawn rate
        if(input.hasNextInt())
        {
            powerupMultiplier = input.nextInt();
        }
        else
            JOptionPane.showMessageDialog(null,"Powerup drop rate multiplier is " + String.valueOf(powerupMultiplier) + "x.");
    }
    
    static void specialMultiplier(Scanner input)
    {
        //multiplies specila chances
        if(input.hasNextInt())
        {
            specialMultiplier = input.nextInt();
        }
        else
            JOptionPane.showMessageDialog(null,"Enemies' special action rate multiplier is " + String.valueOf(specialMultiplier) + "x.");
    }
    
    static void level(Scanner input)
    {
        //sets level you are on
        if(input.hasNextInt())
        {
            Save.level = input.nextInt();
        }
        else
            JOptionPane.showMessageDialog(null,"Current level is " + String.valueOf(Save.level) + ".");
    }
    
    static void money(Scanner input)
    {
        //sets amount of money you have
        if(input.hasNextInt())
        {
            Save.money = input.nextInt();
        }
        else
            JOptionPane.showMessageDialog(null,"Player has $" + String.valueOf(Save.money) + ".");
    }
}
