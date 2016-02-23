import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ship extends goodShips
{
    bullet bullet;
    private int gunReloadTime;                  // The minimum delay between firing the gun.
    private int reloadDelayCount;               // How long ago we fired the gun the last time.
    public ship()
    {
        reloadDelayCount = 0;
        gunReloadTime = 50;
    }
    /**
     * Act - do whatever the ship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        reloadDelayCount++;//keeps you from firing to often
        if (Greenfoot.isKeyDown("a"))
        {
            move(-5);
            //moves right
        }
        if (Greenfoot.isKeyDown("d"))
        {
            move(5);
            //moves left
        }
        if (Greenfoot.isKeyDown("space"))
        {
            if(reloadDelayCount >= gunReloadTime) 
            {
                getWorld().addObject(new bullet(),getX(),getY());
                reloadDelayCount = 0;
                //shoots
            } 
        }
    }    
    
     /**
     * Set the time needed for re-loading the rocket's gun. The shorter this time is,
     * the faster the rocket can fire. The (initial) standard time is 20.
     */
    public void setGunReloadTime(int reloadTime)
    {
        gunReloadTime = reloadTime;
    }
}
