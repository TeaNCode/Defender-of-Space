import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemyShip2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemyShip2 extends enemyShips
{
    /**
     * Act - do whatever the enemyShip2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
         if(Greenfoot.getRandomNumber(999) + 1 <= 1 * DevOptions.attackMultiplier)
        {
            //fires
            getWorld().addObject(new bullet7(), getX(), getY());
        }
        destroyed();
    }    
    public enemyShip2()
    {
        direction = 2;
    }
    public void destroyed()
    {
        bullet Bullet = getOneIntersectingObject(bullet.class);
        if( Bullet != null) 
        {
            getWorld().removeObject(Bullet);
            getWorld().removeObject(this);
            enemyShip3.score = enemyShip3.score + 100;
            score.enemysKilled++;
        }
    }
}
