import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player2Ship extends GoodShip
{
    private final int gunReloadTime = 50;                  // The minimum delay between firing the gun.
    private int reloadDelayCount;               // How long ago we fired the gun the last time.
    private SpaceWorldMulti world;
    private boolean delete;
    private int spawnProtection;
    private int PlayerNum;
    public Player2Ship(SpaceWorldMulti world, int plyrNum )
    {
        this.world = world;
        plyrNum = PlayerNum;
        reloadDelayCount = 50;
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
            if (Greenfoot.isKeyDown("LEFT") && PlayerNum == 1)
            {
                //moves right
                if(getX() - 5 <= 160 && !DevConsole.hiding)
                    setLocation(160,getY());
                else
                    move(-5);
            }
            else if (Greenfoot.isKeyDown("RIGHT") && PlayerNum == 1)
            {
                //moves left
                if(getX() + 5 >= 870 && !DevConsole.hiding)
                    setLocation(870,getY());
                else
                    move(5);
            }
            if (Greenfoot.isKeyDown("d") && PlayerNum == 2)
            {
                //moves left
                if(getX() + 5 >= 870 && !DevConsole.hiding)
                    setLocation(870,getY());
                else
                    move(5);
            }
            else if (Greenfoot.isKeyDown("a") && PlayerNum == 2)
            {
                //moves right
                if(getX() - 5 <= 160 && !DevConsole.hiding)
                    setLocation(160,getY());
                else
                    move(-5);
            }
            if (Greenfoot.isKeyDown("UP") && PlayerNum == 1)
            {
                if(reloadDelayCount >= gunReloadTime || DevConsole.minigun) 
                {
                    getWorld().addObject(new PlayerRocket(),getX(),getY());
                    reloadDelayCount = 0;
                    //shoots
                } 
            }
            else if (Greenfoot.isKeyDown("SPACE") && PlayerNum == 2)
            {
                if(reloadDelayCount >= gunReloadTime || DevConsole.minigun) 
                {
                    getWorld().addObject(new PlayerRocket(),getX(),getY());
                    reloadDelayCount = 0;
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
        if(hitee instanceof Plasma || hitee instanceof EnemyRocket)
        {
            if(!DevConsole.invulnerable && spawnProtection == 0)
            {
                int lives = world.lives.toArray().length;
                if(lives > 0)
                {
                    getWorld().removeObject(world.lives.get(lives - 1));
                    world.lives.remove(lives - 1);
                    if(PlayerNum == 1)getWorld().addObject(new Player2Ship(world, 1),500,800);
                    else if(PlayerNum == 2)getWorld().addObject(new Player2Ship(world, 2),500,800);
                }
                delete = true;
            }
        }
    }
}
