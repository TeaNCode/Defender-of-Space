import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * overlord class for rockets and other projectiles
 * 
 * @author TeaNCode
 */
public abstract class Projectile extends Actor
{
    public boolean delete;
    public Destroyable owner;
    public boolean penetrate;

    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Projectile projectile = (Projectile)(this.getOneIntersectingObject(Projectile.class));
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
        //constructor for normal projectile class
        setRotation(rotation);
        this.owner = owner;
        delete = false;
        penetrate = false;
    }
    
    public Projectile(int rotation, Destroyable owner, boolean penetrate)
    {
        //constructor for penetrate projectile class
        this(rotation,owner);
        this.penetrate = penetrate;
    }

    public abstract void collision(Projectile hitee);//checks collison

    public void delete()
    {
        delete = true;
    }
    
    public void deleteCheck()
    {
        //checks to delete
        if(delete)
        {
            getWorld().removeObject(this);
        }
    }
}
