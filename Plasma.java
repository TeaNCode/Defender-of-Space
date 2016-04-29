import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * future rocket class for the palyer and enemy. <NOT DONE>
 * 
 * @author TeaNCOde
 */
public class Plasma extends Projectile
{
    public Plasma(int rotation, Destroyable owner)
    {
        //normal plasma shot constructor
        super(rotation, owner);
        this.penetrate = false;
        setImage("PlasmaBall.png");
    }
    
    public Plasma(int rotation, Destroyable owner, boolean penetrate)
    {
        //penetration plasma shot constructor
        super(rotation,owner,penetrate);
        this.penetrate = penetrate;
        setImage("PlasmaBall.png");
    }
    
    /**
     * Act - do whatever the Plasma wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }    
    
    public void collision(Projectile hitee)
    {
        
    }
}
