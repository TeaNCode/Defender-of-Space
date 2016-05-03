import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyBoss1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyBoss1 extends EnemyShip
{
    public int hits = 0;
    int movement = 4;
    public EnemyBoss1()
    {
        setImage("Boss.png");
        script = "normal";
    }

    /**
     * Act - do whatever the EnemyBoss1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX() + (movement), getY());
        if(getX() >= 800)
        {
            movement = -2;
        }
        else if(getX() <= 230)
        {
            movement = +4;
        }

        if(script.equals("normal"))
        {
            move();
            if(Greenfoot.getRandomNumber(500) + 1 <= 1 * DevConsole.specialMultiplier)
            {
                getWorld().addObject(new HighVelocityRocket(90,this), getX(), getY());
                getWorld().addObject(new EnemyShip4(1), getX(), getY() + 140);
                getWorld().addObject(new EnemyShip1(1), getX() + 20, getY()+ 120);
                getWorld().addObject(new EnemyShip1(1), getX() - 20, getY()+ 120);
            }
            else if(Greenfoot.getRandomNumber(300) + 1 <= 1 * DevConsole.specialMultiplier)
            {
                getWorld().addObject(new HighVelocityRocket(80,this), getX(), getY());
                getWorld().addObject(new HighVelocityRocket(85,this), getX(), getY() + 10);
                getWorld().addObject(new HighVelocityRocket(95,this), getX(), getY() + 10);
                getWorld().addObject(new HighVelocityRocket(100,this), getX(), getY());
            }
        }
        else if(script.startsWith("down "))
            downScript();
    }    

    public void hit(Projectile hitee)
    {
            if(hitee.owner instanceof GoodShip)
            {
                if(hits == 10){
                    GoodShip killer = (GoodShip) (hitee.owner);
                    getWorld().removeObject(this);
                    killer.score = killer.score + 1500;
                    killer.enemiesKilled++;
                }
                else {
                    hits++;
                    hitee.delete();
                }
            }
        }
        }
