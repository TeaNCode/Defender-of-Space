import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Scanner;
/**
 * Write a description of class enemyShip1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyShip1 extends EnemyShip
{
    private int cooldown;
    public EnemyShip1()
    {
        setImage("enemyShip1.png");
        direction = 1;
        script = "normal";
        end = false;
    }

    /**
     * Act - do whatever the enemyShip1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveCheck();
        if(script.equals("normal"))
        {
            move();
            if(Greenfoot.getRandomNumber(3999) + 1 <= 1 && cooldown <= 0)
            {
                script = "burst 0";
            }
            else if(Greenfoot.getRandomNumber(1999) + 1 <= 1 * DevConsole.attackMultiplier)
            {
                cooldown--;
                getWorld().addObject(new EnemyRocket(this), getX(), getY());
            }
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
        else if(script.startsWith("burst "))
        {
            move();
            Scanner input = new Scanner(script);
            input.next();
            int i = input.nextInt();
            if(i % 3 == 1)
            {
                getWorld().addObject(new EnemyRocket(this), getX(), getY());
            }
            if(i == 7)
                script = "normal";
            else
                script = "burst " + String.valueOf(i + 1);
        }

        if(end)
        {
            SpaceWorld temp = (SpaceWorld)(getWorld());
            temp.showSummary(false);
        }
    }    

    public void hit(Projectile hitee)
    {
        if(hitee instanceof Plasma || hitee instanceof PlayerRocket)
        {
            hitee.delete();
            GoodShip killer = (GoodShip) (hitee.owner);
            getWorld().removeObject(this);
            killer.score = killer.score + 100;
            killer.enemiesKilled++;
        }
    }
}