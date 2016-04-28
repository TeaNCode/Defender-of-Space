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
    public EnemyShip1(int direction)
    {
        setImage("enemyShip1.png");
        this.direction = direction;
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
            if(Greenfoot.getRandomNumber(3999) + 1 <= 1  * DevConsole.specialMultiplier)
            {
                script = "burst 0";
            }
            else if(Greenfoot.getRandomNumber(1999) + 1 <= 1 * DevConsole.attackMultiplier)
            {
                getWorld().addObject(new EnemyRocket(90,this), getX(), getY());
            }
        }
        else if(script.startsWith("down "))
        {
            downScript();
        }
        else if(script.startsWith("burst "))
        {
            move();
            Scanner input = new Scanner(script);
            input.next();
            int i = input.nextInt();
            if(i % 3 == 1)
            {
                getWorld().addObject(new EnemyRocket(90,this), getX(), getY());
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
            temp.showingSummary = true;
        }
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
            killer.score += 100;
            Save.money += 10;
            killer.enemiesKilled++;
        }
    }
}