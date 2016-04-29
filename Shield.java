import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shield here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shield extends Actor
{
    private Actor owner;
    private boolean delete;

    /**
     * owner is the object this will follow, scale is the scale of it's image where 1.0 is full size
     */
    public Shield(Actor owner, double scale)
    {
        GreenfootImage temp = new GreenfootImage("shieldTravel.png");
        temp.scale((int)(temp.getWidth() * scale),(int)(temp.getHeight() * scale));
        setImage(temp);
        this.owner = owner;
    }

    public void act() 
    {
        if(!delete)
        {
            setLocation(owner.getX(),owner.getY());
        }
        else
        {
            getWorld().removeObject(this);
        }
    }    

    public void delete()
    {
        delete = true;
    }
}
