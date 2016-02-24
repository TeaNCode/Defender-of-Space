import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ship extends goodShips
{
    private final int gunReloadTime = 50;                  // The minimum delay between firing the gun.
    private int reloadDelayCount;               // How long ago we fired the gun the last time.
    private spaceWorld world;
    public ship(spaceWorld world)
    {
        this.world = world;
        reloadDelayCount = 0;
    }

    /**
     * Act - do whatever the ship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //Make sure we didn't die
        manDown();

        reloadDelayCount++;//keeps you from firing to often
        if (Greenfoot.isKeyDown("LEFT") || Greenfoot.isKeyDown("a"))
        {
            //moves right
            if(getX() - 5 <= 160 && !DevOptions.hiding)
                setLocation(160,getY());
            else
                move(-5);
        }
        else if (Greenfoot.isKeyDown("RIGHT") || Greenfoot.isKeyDown("d"))
        {
            //moves left
            if(getX() + 5 >= 870 && !DevOptions.hiding)
                setLocation(870,getY());
            else
                move(5);
        }
        if (Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("UP"))
        {
            if(reloadDelayCount >= gunReloadTime || DevOptions.minigun) 
            {
                getWorld().addObject(new bullet(),getX(),getY());
                reloadDelayCount = 0;
                //shoots
            } 
        }
    }    

    public void manDown()
    {
        bullet7 bullet = getOneObjectAtOffset(0,0,bullet7.class);
        if(bullet != null && !DevOptions.invulnerable)
        {
            getWorld().removeObject(bullet);
            int lives = world.lives.toArray().length;
            if(lives > 0)
            {
                getWorld().removeObject(world.lives.get(lives - 1));
                world.lives.remove(lives - 1);
                getWorld().addObject(new ship(world),500,800);
            }
            getWorld().removeObject(this);
        }
    }
}
