import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerShip extends GoodShip
{
    private int reloadDelayCount;               // How long ago we fired the gun the last time.
    private SpaceWorld world;
    private boolean delete;
    private int spawnProtection;
    public PlayerShip(SpaceWorld world)
    {
        setImage("playerShip.png");
        this.world = world;
        reloadDelayCount = gunReloadTime;
        delete = false;
        spawnProtection = 50;
    }

    /**
     * Act - do whatever the ship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(spawnProtection > 0)
        {
            spawnProtection--;
        }

        if(!delete)
        {
            reloadDelayCount++;//keeps you from firing to often
            if (Greenfoot.isKeyDown("a"))
            {
                //moves right
                if(getX() - 5 <= 160 && !DevConsole.hiding)
                    setLocation(160,getY());
                else
                    move(-5);
            }
            else if (Greenfoot.isKeyDown("d"))
            {
                //moves left
                if(getX() + 5 >= 870 && !DevConsole.hiding)
                    setLocation(870,getY());
                else
                    move(5);
            }
            if (Greenfoot.isKeyDown("w"))
            {
                if(reloadDelayCount >= gunReloadTime || DevConsole.minigun) 
                {
                    getWorld().addObject(new PlayerRocket(this),getX(),getY());
                    reloadDelayCount = 0;
                    shots++;
                    //shoots
                } 
            }
        }
        else
        {
            getWorld().removeObject(this);
        }
    }    

    public void hit(Projectile hitee)
    {
        if(hitee.owner instanceof EnemyShip)
        {
            if(!DevConsole.invulnerable && spawnProtection == 0)
            {
                int lives = world.lives.toArray().length;
                getWorld().removeObject(world.lives.get(lives - 1));
                world.lives.remove(lives - 1);
                if(lives > 1)
                {
                    setLocation(500,750);
                    spawnProtection = 50;
                }
                else
                delete = true;
            }
        }
    }
}
