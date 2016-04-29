import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Scanner;
/**
 * A Framework for enemy ships
 * 
 * @author Tea N' Code
 */
public abstract class EnemyShip extends Destroyable
{
    public int direction;
    public boolean end;
    /**
     * Moves the ship, depending on it's direction
     */
    public void move()
    {
        int X = getX();
        if(direction == 1)
        {
            //Moves right
            setLocation(X + 1, getY()); 
        }
        else
        {
            //Moves left
            setLocation(X - 1, getY());
        }
    }  

    /**
     * Checks if we should go down
     */
    public void moveCheck()
    {
        if(script.equals("normal"))
        {
            if(getX() == 870)
            {
                script = "down 20";
                direction = 2;
            }
            else if(getX() == 160)
            {
                script = "down 20";
                direction = 1;
            }

            if(getY() >= 750)
            {
                end = true;
            }
        }
        else if(script.startsWith("burst"))
        {
            if(getX() == 870)
            {
                script = "down 20 " + script;
                direction = 2;
            }
            else if(getX() == 160)
            {
                script = "down 20 " + script;
                direction = 1;
            }
        }
    }

    /**
     * Spawns a powerup, according to a random change
     */
    public void addPowerup()
    {
        if(Greenfoot.getRandomNumber(19) + 1 <= 1 * DevConsole.powerupMultiplier)
        {
            getWorld().addObject(new Powerups(), getX(), getY());
        }
    }

    /**
     * Moves the ship down and then turns them
     */
    public void downScript()
    {
        Scanner input = new Scanner(script);
        input.next();
        int i = input.nextInt();
        setLocation(getX(),getY() + 5);
        if(i == 1)
        {
            if(direction == 1)
                {
                    setLocation(getX() + 1, getY()); 
                }
                else
                {
                    setLocation(getX() - 1, getY());
                }
            if(input.hasNext())
                script = input.next() + " " + input.next();
            else
                script = "normal";
        }
        else
            script = "down " + String.valueOf(i - 1);
    }
}
