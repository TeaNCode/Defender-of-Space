import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bullet7 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bullet7 extends enemyShips
{
    public bullet7()
    {
        turn(90);
    }

    /**
     * Act - do whatever the bullet7 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(10);
        if (getY() == 899)
        {
            getWorld().removeObject(this);
        }
    }    
}
