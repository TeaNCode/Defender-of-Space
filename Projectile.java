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
    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Projectile projectile = getOneIntersectingObject(Projectile.class);
        Destroyable ship = getOneIntersectingObject(Destroyable.class);
        if(projectile != null)
            projectile.collision(this);
        if(ship != null)
            ship.hit(this);
    }    

    public Projectile(int rotation, Destroyable owner)
    {
        setRotation(rotation);
        this.owner = owner;
        delete = false;
    }

    public abstract void collision(Projectile hitee);

    public void delete()
    {
        delete = true;
    }
}
