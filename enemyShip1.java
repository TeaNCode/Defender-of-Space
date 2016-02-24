import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemyShip1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemyShip1 extends enemyShips
{
    public enemyShip1()
    {
        direction = 1;
    }

    /**
     * Act - do whatever the enemyShip1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        if(Greenfoot.getRandomNumber(1999) + 1 <= 1 * DevOptions.attackMultiplier)
        {
            //fires
            getWorld().addObject(new bullet7(), getX(), getY());
        }
        destroyed2();
    }    
    public void destroyed2()
    {
        //Blows up the ship
        bullet Bullet = getOneIntersectingObject(bullet.class);
        if( Bullet != null) 
        {
            getWorld().removeObject(Bullet);
            getWorld().removeObject(this);
            enemyShip3.score = enemyShip3.score + 200;
            score.enemysKilled++;
        }
    }
}
