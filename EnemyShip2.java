import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Scanner;
/**
 * Another enemy that you will face
 * 
 * @author Tea N' Code
 */
public class EnemyShip2 extends EnemyShip
{
    /**
     * Go inside for comments
     */
    public void act() 
    {
        moveCheck();
        if(script.equals("normal"))
        {
            move();
            //Shoot
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
        //Move down
        else if(script.startsWith("down "))
        {
            downScript();
        }

        //End the game safely
        if(end)
        {
            SpaceWorld temp = (SpaceWorld)(getWorld());
            temp.showSummary(false);
            temp.showingSummary = true;
        }
    }    

    /**
     * Constructs the ship and sets it's direction
     */
    public EnemyShip2(int direction)
    {
        setImage("enemyShip2.png");
        this.direction = direction;
        script = "normal";
        end = false;
    }

    /**
     * What happens when the ship gets hit
     */
    public void hit(Projectile hitee)
    {
        if(hitee.owner instanceof GoodShip)
        {
            if(!hitee.penetrate)hitee.delete();
            else hitee.penetrate = false;
            GoodShip killer = (GoodShip)(hitee.owner);
            addPowerup();
            getWorld().removeObject(this);
            killer.score += 200;
            Save.money += 20;
            killer.enemiesKilled++;
        }
    }
}