import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemyShip3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemyShip3 extends enemyShips
{
    static int score;
    private boolean damaged;
    score Score;
    public enemyShip3()
    {
        //declares health, classes, and other ship images
        damaged = false;
        goodShips GoodShips;
        score = 0;
    }

    /**
     * Act - do whatever the enemyShip3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.getRandomNumber(1499) + 1 <= 1 * DevOptions.attackMultiplier)
        {
            getWorld().addObject(new bullet7(), getX(), getY());
        }
        proximity();
    }    

    public void proximity()
    {
        Actor bullet = getOneObjectAtOffset(0, 0, bullet.class);
        if(bullet != null)
        {
            //blows up the ship
            getWorld().removeObject(bullet);
            if(!damaged)
            {
                setImage("ship5.png");
                damaged = true;
            }
            else if(damaged)
            {
                getWorld().removeObject(this);
                score = score + 500;
                Score.enemysKilled++;
            }
        }
    }
}
