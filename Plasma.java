import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Plasma here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plasma extends Projectile
{
    public Plasma(int rotation, Destroyable owner)
    {
        super(rotation, owner);
        this.penetrate = false;
        setImage("PlasmaBall.png");
    }
    
    public Plasma(int rotation, Destroyable owner, boolean penetrate)
    {
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
