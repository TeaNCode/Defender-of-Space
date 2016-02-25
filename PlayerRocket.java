import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class PlayerRocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerRocket extends Projectile
{
    public PlayerRocket()
    {
        super(-90);
    }

    /**
     * Act - do whatever the PlayerRocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        move(6);//flys
        boolean deleted = false;
        if (getY() == 0)
        {
            getWorld().removeObject(this);//removes at edge
            deleted = true;
        }
        
        if(DevConsole.realism && !deleted)
        {
            EnemyRocket rocket = getOneIntersectingObject(EnemyRocket.class);
            if(rocket != null)
            {
                getWorld().removeObject(rocket);
                getWorld().removeObject(this);
            }
        }
    }    
    
    public void collision(Projectile hitee)
    {
        if(DevConsole.realism)
        {
            if(hitee instanceof EnemyRocket || hitee instanceof Plasma)
            {
                getWorld().removeObject(this);
            }
        }
    }
}
