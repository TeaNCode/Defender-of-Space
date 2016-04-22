import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Projectile extends Actor
{
    public boolean delete;
    public Destroyable owner;
    public static boolean penetrate;
    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Projectile projectile = (Projectile)(getOneIntersectingObject(Projectile.class));
        Destroyable ship = (Destroyable)(getOneIntersectingObject(Destroyable.class));
        if(projectile != null)
        {
            projectile.collision(this);
            collision(projectile);
        }
        if(ship != null)
            ship.hit(this);
    }    

    public Projectile(int rotation, Destroyable owner)
    {
        setRotation(rotation);
        this.owner = owner;
        delete = false;
        penetrate = false;
    }

    public abstract void collision(Projectile hitee);

    public void delete()
    {
        if(!penetrate)delete = true;
    }
    
    public void deleteCheck()
    {
        if(delete && !penetrate)
        {
            getWorld().removeObject(this);
        }
    }
}
