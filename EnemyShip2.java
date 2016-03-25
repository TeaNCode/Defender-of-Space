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
    private int cooldown;
    private PlaceHolder placeHolder1;
    private PlaceHolder placeHolder2;
    public String[] powers = {"Attack", "Score", "Shield", "Penetrate", "Mystery", "Burst", "Movement", "Life"};
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
                getWorld().addObject(new EnemyRocket(90,this), getX(), getY());
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
        else if(script.startsWith("run "))
        {
            Scanner input = new Scanner(script);
            input.next();
            int i = input.nextInt();
            if(i == 0)
            {
                boolean arrived = false;
                for(int n = 0; !arrived; n++)
                {
                    move(1);
                    if(getX() == placeHolder1.getX() && getY() == placeHolder1.getY())
                    {
                        arrived = true;
                        script = "run 1";
                    }
                    else if(n == 7)
                        arrived = true;
                }
            }
            else if(i == 1)
            {
                getWorld().addObject(new EnemyRocket(87,this), getX(), getY());
                getWorld().addObject(new EnemyRocket(90,this), getX(), getY());
                getWorld().addObject(new EnemyRocket(93,this), getX(), getY());
                script = "run 2";
            }
            else if(i == 2)
            {
                turnTowards(placeHolder2.getX(),placeHolder2.getY());
            }
        }

        if(end)
        {
            SpaceWorld temp = (SpaceWorld)(getWorld());
            temp.showSummary(false);
        }

        addPowers();
    }    

    public EnemyShip2()
    {
        setImage("enemyShip2.png");
        direction = 2;
        script = "normal";
        cooldown = 0;
        end = false;
    }

    public void hit(Projectile hitee)
    {
        if(hitee instanceof Plasma || hitee instanceof PlayerRocket)
        {
            hitee.delete();
            GoodShip killer = (GoodShip) (hitee.owner);
            getWorld().removeObject(this);
            killer.score = killer.score + 200;
            killer.enemiesKilled++;
        }
    }

    public void addPowers(){
        if(Greenfoot.getRandomNumber(5000) + 1 <= 1 * DevConsole.powerupMultiplier)
        {
            getWorld().addObject(new Powerups(powers[Greenfoot.getRandomNumber(7)]), getX(), getY());
        }
    }
}