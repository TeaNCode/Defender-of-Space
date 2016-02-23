import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemyShip2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemyShip2 extends enemyShips
{
    //declares classes and int's
    bullet bullet;
    enemyShip3 ship3;
    score Score;
    /**
     * Act - do whatever the enemyShip2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
         if(Greenfoot.getRandomNumber(2000) == 1)
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
       //Actor enemyShip2 = getOneIntersectingObject(enemyShip2.class);
       //blows up the ship
        if(getOneIntersectingObject(bullet.class) != null) 
        {
            //return true;
            getWorld().removeObject(this);
           // getWorld().removeObject(bullet);
            edestroyed = true;
            ship3.score = ship3.score + 100;
            Score.enemysKilled++;
        }
    }
}
