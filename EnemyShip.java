import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Scanner;
/**
 * Write a description of class EnemyShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class EnemyShip extends Destroyable
{
    public int direction;
    public boolean end;
    public void move()
    {
        //moves the ships from side to side
        int X = getX();
        if(direction == 1)
        {
            setLocation(X + 1, getY()); 
        }
        else
        {
            setLocation(X - 1, getY());
        }
    }  

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

    public void addPowerup()
    {
        if(Greenfoot.getRandomNumber(19) + 1 <= 1 * DevConsole.powerupMultiplier)
        {
            getWorld().addObject(new Powerups(), getX(), getY());
        }
    }

    public void downScript()
    {
        Scanner input = new Scanner(script);
        input.next();
        int i = input.nextInt();
        setLocation(getX(),getY() + 5);
        if(i == 1)
        {
            if(input.hasNext())
            {
                script = input.next() + " " + input.next();
                if(direction == 1)
                {
                    setLocation(getX() + 1, getY()); 
                }
                else
                {
                    setLocation(getX() - 1, getY());
                }
            }
            else
            {
                script = "normal";
                if(direction == 1)
                {
                    setLocation(getX() + 1, getY()); 
                }
                else
                {
                    setLocation(getX() - 1, getY());
                }
            }
        }

        else
            script = "down " + String.valueOf(i - 1);
    }
}
