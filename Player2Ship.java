import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * second players ship
 * 
 * @author TeaNCode
 */
public class Player2Ship extends GoodShip
{
    //For variables see GoodShip
    public Player2Ship(SpaceWorld world)
    {
        setImage("player2Ship.png");
        reloadDelayCount = gunReloadTime;
        delete = false;
        spawnProtection = 50;
        reloadDelayCount = 65;
        gunReloadTime = 65;
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
        if(!delete)
        {
            if(spawnProtection > 0)
            {
                spawnProtection--;
            }

            if(attackSpeed){
                if(attackBoostedTime != 0)
                {
                    attackBoostedTime--;
                }
                else
                {
                    gunReloadTime += 30;
                    attackSpeed = false;
                }
            }

            reloadDelayCount++;//keeps you from firing to often
            if (Greenfoot.isKeyDown("LEFT"))
            {
                //moves right
                if(getX() - speed <= 160 && !DevConsole.hiding)
                    setLocation(160,getY());
                else
                    move(-speed);
            }
            if (Greenfoot.isKeyDown("RIGHT"))
            {
                //moves left
                if(getX() + speed >= 870 && !DevConsole.hiding)
                    setLocation(870,getY());
                else
                    move(speed);
            }
            if (Greenfoot.isKeyDown("UP"))
            {
                //shoots
                if(reloadDelayCount >= gunReloadTime || DevConsole.minigun) 
                {
                    reloadDelayCount = 0;
                    shots++;
                    //Shoot penetrative bullets
                    if(penetrate)
                    {
                        penShots--;  
                        if(burst)
                        {
                            penetrate = false;
                            getWorld().addObject(new PlayerRocket(-80, this,true),getX(),getY());
                            getWorld().addObject(new PlayerRocket(-90, this,true),getX(),getY());
                            getWorld().addObject(new PlayerRocket(-100, this,true),getX(),getY());
                            shots += 2;
                            penShots -= 2;
                            burstShots--;

                            //Checks if we should stop bursting
                            if(burstShots <= 0)
                                burst = false;
                        }
                        else
                        {
                            getWorld().addObject(new PlayerRocket(-90, this, true),getX(),getY());
                        }

                        //Check if we should end penetrating
                        if(penShots <= 0)
                            penetrate = false;
                    }
                    //Shoot a burst
                    else if(burst)
                    {
                        getWorld().addObject(new PlayerRocket(-80, this),getX(),getY());
                        getWorld().addObject(new PlayerRocket(-90, this),getX(),getY());
                        getWorld().addObject(new PlayerRocket(-100, this),getX(),getY());
                        shots += 2;
                        burstShots--;

                        //Checks if we should stop bursting
                        if(burstShots <= 0)
                            burst = false;
                    }
                    //Fire a standard shot
                    else
                    {
                        getWorld().addObject(new PlayerRocket(-90, this),getX(),getY());
                    }
                }
            }
        }
        else
        {
            //removes if delete
            getWorld().removeObject(this);
        }
    } 

    public void hit(Projectile hitee)
    {
        //checks if hit by projectile
        if(hitee.owner instanceof EnemyShip)
        {
            hitee.delete();
            //checks if invulnerable
            if(!DevConsole.invulnerable && spawnProtection == 0)
            {
                //checks if shielded
                if(!shielded)
                {
                    SpaceWorld world = (SpaceWorld)(getWorld());
                    int lives = world.lives2.toArray().length;
                    getWorld().removeObject(world.lives2.get(lives - 1));
                    world.lives2.remove(lives - 1);
                    if(lives > 1)
                    {
                        //checks if final death
                        setLocation(500,750);
                        spawnProtection = 50;
                        spawnProtection = 50;
                        gunReloadTime = 65;
                        reloadDelayCount = 65;
                        attackSpeed = false;
                        speed = 5;
                        penetrate = false;
                        burst = false;
                        penShots = 0;
                        burstShots = 0;
                        attackBoostedTime = 0;
                    }
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
