import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shield here.
 * 
 * @Tea N' Code
 */
public class Shield extends Actor
{
    //The owner of the shield
    private Actor owner;
    private boolean delete;

    /**
     * Owner is the object this will follow, scale is the scale of it's image where 1.0 is full size
     */
    public Shield(Actor owner, double scale)
    {
        GreenfootImage temp = new GreenfootImage("shieldTravel.png");
        temp.scale((int)(temp.getWidth() * scale),(int)(temp.getHeight() * scale));
        setImage(temp);
        this.owner = owner;
    }

    /**
     * Follows the owner or safely deletes the Shield
     */
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

    /**
     * Sets the shield to be safely deleted
     */
    public void delete()
    {
        delete = true;
    }
}
