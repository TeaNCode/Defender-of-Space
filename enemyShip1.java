import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemyShip1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemyShip1 extends enemyShips
{
    enemyShip3 ship3;
    score Score;
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
        if(Greenfoot.getRandomNumber(1000) == 1)
        {
            //fires
            getWorld().addObject(new bullet7(), getX(), getY());
        }
        destroyed2();
    }    
    //blows up the ship
    public void destroyed2()
    {
       Actor bullet = getOneIntersectingObject(bullet.class);
        if(getOneIntersectingObject(bullet.class) != null) 
        {
            //return true;
            getWorld().removeObject(this);
            //getWorld().removeObject(bullet);
            edestroyed = true;
            ship3.score = ship3.score + 200;
            Score.enemysKilled++;
        }
       // else 
        //{
       //     return false;
       // }
    }
}
