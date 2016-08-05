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
        bossBonus = 0;
        penetrate = false;
        burst = false;
        movementCount = 0;

        //Apply the active items the user has
        applyItems();
    }

    /**
     * Act - do whatever the ship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!delete)
        {
            //Decrease spawn protection
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
                    gunReloadTime += 20;
                    attackSpeed = false;
                }
            }

            reloadDelayCount++;//keeps you from firing to often

            if (Greenfoot.isKeyDown("a"))
            {
                //moves right
                if(getX() - speed <= 160 && !DevConsole.hiding)
                    setLocation(160,getY());
                else
                    move(-speed);
            }
            if (Greenfoot.isKeyDown("d"))
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
        //Delete the player because delete
        else
        {
            getWorld().removeObject(this);
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
                    //checks if final death
                    if(lives > 1)
                    {
                        //Reset stats
                        setLocation(500,750);
                        spawnProtection = 50;
                        if(attackSpeed)
                            gunReloadTime += 20;
                        reloadDelayCount = gunReloadTime;
                        attackSpeed = false;
                        speed -= movementCount * 2;
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

    public void applyItems()
    {
        for(String active : Save.activeItems)
        {
            if(active != null)
            {
                if(active.startsWith("AttackSpeed"))
                    gunReloadTime -= 3;
                else if(active.startsWith("Movement"))
                    speed += 1;
                else if(active.startsWith("BossBonus"))
                    bossBonus += 2;
                else if(active.startsWith("HighCaliber"))
                {
                    bossBonus += 3;
                    gunReloadTime += 4;
                }
            }
        }
    }
}
