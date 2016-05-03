import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ship here.
 * 
 * @author Tea N' Code
 */
public class PlayerShip extends GoodShip
{
    //For variables see GoodShip
    public PlayerShip(SpaceWorld world)
    {
        setImage("playerShip.png");
        delete = false;
        //Protects player from being hit
        spawnProtection = 50;
        gunReloadTime = 65;
        //Player can fire instantly
        reloadDelayCount = gunReloadTime;
        speed = 5;
        penetrate = false;
        burst = false;
    }

    /**
     * Act - do whatever the ship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //Decrease spawn protection
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
                if(getX() - speed <= 160 && !DevConsole.hiding)
                    setLocation(160,getY());
                else
                    move(-speed);
            }
            else if (Greenfoot.isKeyDown("d"))
            {
                //moves left
                if(getX() + speed >= 870 && !DevConsole.hiding)
                    setLocation(870,getY());
                else
                    move(speed);
            }
            if (Greenfoot.isKeyDown("w"))
            {
                //shoots
                if(reloadDelayCount >= gunReloadTime || DevConsole.minigun) 
                {
                    reloadDelayCount = 0;
                    shots++;
                    //Shoot penetrative bullets
                    if(penetrate)
                    {
                        getWorld().addObject(new PlayerRocket(-90, this, true),getX(),getY());
                        penShots--;
                        if(penShots <= 0)
                            penetrate = false;
                    }
                    else if(burst)
                    {
                        getWorld().addObject(new PlayerRocket(-80, this),getX(),getY());
                        getWorld().addObject(new PlayerRocket(-90, this),getX(),getY());
                        getWorld().addObject(new PlayerRocket(-100, this),getX(),getY());
                        shots+= 3;
                        burstShots--;
                        if(burstShots <= 0)
                            burst = false;
                    }
                    else
                    {
                        getWorld().addObject(new PlayerRocket(-90, this),getX(),getY());
                    }
                } 
            }
        }
        //Delete the player because delete
        else
        {
            getWorld().removeObject(this);
        }

        if(attackSpeed){
            if(attackBoostedTime != 0)
            {
                attackBoostedTime--;
            }
            else
            {
                gunReloadTime = 65;
                attackSpeed = false;
            }
        }
    }    

    public void hit(Projectile hitee)
    {
        if(hitee.owner instanceof EnemyShip)
        {
            hitee.delete();
            if(!DevConsole.invulnerable && spawnProtection == 0)
            {
                if(!shielded)
                {
                    SpaceWorld world = (SpaceWorld)(getWorld());
                    int lives = world.lives.toArray().length;
                    getWorld().removeObject(world.lives.get(lives - 1));
                    world.lives.remove(lives - 1);
                    if(lives > 1)
                    {
                        //Reset stats
                        setLocation(500,750);
                        spawnProtection = 50;
                        gunReloadTime = 65;
                        reloadDelayCount = 65;
                        attackSpeed = false;
                        speed = 5;
                        penetrate = false;
                        burst = false;
                    }
                    //No more players
                    else
                        delete = true;
                }
                else
                {
                    shielded = false;
                    shield.delete();
                }
            }
        }
    }
}
