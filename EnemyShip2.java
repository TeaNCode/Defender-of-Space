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
            if(Greenfoot.getRandomNumber(2999) + 1 <= 1 * DevConsole.specialMultiplier)
            {
                getWorld().addObject(new EnemyRocket(84,this), getX(), getY());
                getWorld().addObject(new EnemyRocket(90,this), getX(), getY());
                getWorld().addObject(new EnemyRocket(96,this), getX(), getY());
            }
            else if(Greenfoot.getRandomNumber(999) + 1 <= 1 * DevConsole.attackMultiplier)
            {
                getWorld().addObject(new EnemyRocket(90,this), getX(), getY());
            }
        }
        else if(script.startsWith("down "))
        {
            downScript();
        }

        if(end)
        {
            SpaceWorld temp = (SpaceWorld)(getWorld());
            temp.showSummary(false);
            temp.showingSummary = true;
        }
    }    

    public EnemyShip2(int direction)
    {
        setImage("enemyShip2.png");
        this.direction = direction;
        script = "normal";
        end = false;
    }

    public void hit(Projectile hitee)
    {
        if(hitee.owner instanceof GoodShip)
        {
            if(!hitee.penetrate)hitee.delete();
            else hitee.penetrate = false;
            GoodShip killer = (GoodShip) (hitee.owner);
            addPowerup();
            getWorld().removeObject(this);
            killer.score += 200;
            Save.money += 20;
            killer.enemiesKilled++;
        }
    }
}