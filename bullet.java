import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bullet extends goodShips
{
    public bullet()
    {
        turn(-90);
    }

    /**
     * Act - do whatever the bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(6);//flys
        boolean deleted = false;
        if (getY() == 0)
        {
            getWorld().removeObject(this);//removes at edge
            deleted = true;
        }
        
        if(DevOptions.realism && !deleted)
        {
            bullet7 bullet = getOneObjectAtOffset(0,0,bullet7.class);
            if(bullet != null)
            {
                getWorld().removeObject(bullet);
                getWorld().removeObject(this);
            }
        }
    }    
}
