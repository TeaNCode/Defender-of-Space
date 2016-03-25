import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemyShip3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyShip3 extends EnemyShip
{
    private boolean damaged;
    public EnemyShip3()
    {
        setImage("enemyShip3.png");
        damaged = false;
        script = "normal";
    }

    /**
     * Act - do whatever the enemyShip3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(script.equals("normal"))
        {
            if(Greenfoot.getRandomNumber(1499) + 1 <= 1 * DevConsole.attackMultiplier)
            {
                getWorld().addObject(new EnemyRocket(90,this), getX(), getY());
            }
        }
    }    

    public void hit(Projectile hitee)
    {
        if(hitee instanceof Plasma || hitee instanceof PlayerRocket)
        {
            hitee.delete();
            if(!damaged)
            {
                setImage("enemyShip3-2.png");
                damaged = true;
            }
            else if(damaged)
            {
                GoodShip killer = (GoodShip) (hitee.owner);
                getWorld().removeObject(this);
                killer.score = killer.score + 500;
                killer.enemiesKilled++;
            }
        }
    }
}