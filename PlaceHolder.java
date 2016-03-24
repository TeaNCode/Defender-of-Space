import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Scanner;
/**
 * Write a description of class PlaceHolder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlaceHolder extends ScriptedActor
{
    private int x;
    private int y;
    private int direction;
    public PlaceHolder(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public PlaceHolder(int x, int y, int direction)
    {
        this.x = x;
        this.y = y;
        this.direction = direction;
        script = "normal";
    }

    public void act()
    {
        if(script != null)
        {
            moveCheck();
            if(script.startsWith("down "))
            {
                Scanner input = new Scanner(script);
                input.next();
                int i = input.nextInt();
                setLocation(getX(),getY() + 5);
                if(i == 1)
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

                else
                    script = "down " + String.valueOf(i - 1);
            }
            else
            {
                move();
            }
        }
    }

    public void move()
    {
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
        }
    }
}
