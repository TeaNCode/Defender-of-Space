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
        //declares health, classes, and other ship images
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
                getWorld().addObject(new EnemyRocket(), getX(), getY());
            }
            hit();
        }
    }    

    public void hit()
    {
        PlayerRocket rocket = getOneIntersectingObject(PlayerRocket.class);
        if(rocket != null)
        {
            //blows up the ship
            getWorld().removeObject(rocket);
            if(!damaged)
            {
                setImage("ship5.png");
                damaged = true;
            }
            else if(damaged)
            {
                getWorld().removeObject(this);
                Score.score =+500;
                Score.enemysKilled++;
            }
        }
    }
}