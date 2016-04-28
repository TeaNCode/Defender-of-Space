import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Scanner;
/**
 * Yet another enemy that you will face. Doesn't move down towards you like others.
 * 
 * @Tea N' Code
 */
public class EnemyShip3 extends EnemyShip
{
    private boolean damaged;
    private int bias;
    //Constructs the ship
    public EnemyShip3()
    {
        setImage("enemyShip3.png");
        damaged = false;
        script = "normal";
        
        bias = 7 - Greenfoot.getRandomNumber(5);
    }

    /**
     * Act - do whatever the enemyShip3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(script.equals("normal"))
        {
            if(Greenfoot.getRandomNumber(2999) + 1 <= DevConsole.specialMultiplier)
            {
                getWorld().addObject(new HighVelocityRocket(90,this), getX(), getY());
            }
            else if(Greenfoot.getRandomNumber(1499) + 1 <= 1 * DevConsole.attackMultiplier)
            {
                getWorld().addObject(new EnemyRocket(90,this), getX(), getY());
            }
            else if(Greenfoot.getRandomNumber(199) + 1 <= 1 * DevConsole.specialMultiplier)
            {
                if(Greenfoot.getRandomNumber(9) + 1 <= bias)
                {
                    script = "right 4";
                }
                else
                {
                    script = "left 4";
                }
            }
        }
        else if(script.startsWith("right "))
        {
            Scanner input = new Scanner(script);
            input.next();
            int i = input.nextInt();
            if(getX() - 5 <= 160)
            {
                setLocation(160,getY());
                script = "normal";
            }
            else
                move(-5);
            if(i == 0)
                script = "normal";
            else
                script = "right " + String.valueOf(i - 1);
        }
        else if(script.startsWith("left "))
        {
            Scanner input = new Scanner(script);
            input.next();
            int i = input.nextInt();
            if(getX() + 5 >= 870)
            {
                setLocation(870,getY());
                script = "normal";
            }
            else
                move(5);
            if(i == 0)
                script = "normal";
            else
                script = "left " + String.valueOf(i - 1);
        }
    }    

    public void hit(Projectile hitee)
    {
        if(hitee.owner instanceof GoodShip)
        {
            if(!hitee.penetrate)hitee.delete();
            else hitee.penetrate = false;
            if(!damaged)
            {
                setImage("enemyShip3-2.png");
                damaged = true;
            }
            else
            {
                GoodShip killer = (GoodShip) (hitee.owner);
                addPowerup();
                getWorld().removeObject(this);
                killer.score += 500;
                Save.money += 50;
                killer.enemiesKilled++;
            }
        }
    }
}