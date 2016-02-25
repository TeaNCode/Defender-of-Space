import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Scanner;
/**
 * Write a description of class enemyShip2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyShip2 extends EnemyShip
{
    /**
     * Act - do whatever the enemyShip2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveCheck();
        if(script.equals("normal"))
        {
            move();
            if(Greenfoot.getRandomNumber(999) + 1 <= 1 * DevConsole.attackMultiplier)
            {
                //fires
                getWorld().addObject(new EnemyRocket(), getX(), getY());
            }
            destroyed();
        }
        else if(script.startsWith("down "))
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
    }    

    public EnemyShip2()
    {
        direction = 2;
        script = "normal";
    }

    public void destroyed()
    {
        PlayerRocket rocket = getOneIntersectingObject(PlayerRocket.class);
        if(rocket != null) 
        {
            getWorld().removeObject(rocket);
            getWorld().removeObject(this);
            Score.score =+200;
            Score.enemysKilled++;
        }
    }
}