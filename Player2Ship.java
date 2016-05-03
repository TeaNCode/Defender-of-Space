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
        this.world = world;
        reloadDelayCount = gunReloadTime;
        delete = false;
        spawnProtection = 50;
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
        if(spawnProtection > 0)
        {
            spawnProtection--;
        }

        if(!delete)
        {
            reloadDelayCount++;//keeps you from firing to often
            if (Greenfoot.isKeyDown("LEFT"))
            {
                //moves right
                if(getX() - 5 <= 160 && !DevConsole.hiding)
                    setLocation(160,getY());
                else
                    move(-speed);
            }
            else if (Greenfoot.isKeyDown("RIGHT"))
            {
                //moves left
                if(getX() + 5 >= 870 && !DevConsole.hiding)
                    setLocation(870,getY());
                else
                    move(speed);
            }
            if (Greenfoot.isKeyDown("UP"))
            {
                //shoots
                if(reloadDelayCount >= gunReloadTime || DevConsole.minigun) 
                {
                    //checks for diffrent kinds of shots
                    if(penetrate){
                        getWorld().addObject(new PlayerRocket(-90, this, true),getX(),getY());
                        reloadDelayCount = 0;
                        shots++;
                        penShots++;
                        if(penShots== 2)
                        {
                            penetrate = false;
                        }
                    }
                    else if(burst){
                        if(penetrate && penShots == 0)
                        {
                            penetrate = false;
                            getWorld().addObject(new PlayerRocket(-80, this,true),getX(),getY());
                            getWorld().addObject(new PlayerRocket(-90, this,true),getX(),getY());
                            getWorld().addObject(new PlayerRocket(-100, this,true),getX(),getY());
                            penShots = 3;
                        }
                        else
                        {
                            getWorld().addObject(new PlayerRocket(-80, this),getX(),getY());
                            getWorld().addObject(new PlayerRocket(-90, this),getX(),getY());
                            getWorld().addObject(new PlayerRocket(-100, this),getX(),getY());
                        }
                        reloadDelayCount = 0;
                        shots+= 3;
                        burstShots++;
                        if(burstShots==5){
                            burst = false;
                        }
                    }
                    else{
                        getWorld().addObject(new PlayerRocket(-90, this),getX(),getY());
                        reloadDelayCount = 0;
                        shots++;
                    }
                } 
            }
        }
        else
        {
            //removes if delete
            getWorld().removeObject(this);
        }

        if(attackSpeed){
            //timer for attack speed boost
            attackBoostedTime = 50;
            gunReloadTime = 35;
            if(attackBoostedTime != 0){
                attackBoostedTime--;
                gunReloadTime = 35;
            }
            else if(attackBoostedTime == 0){
                gunReloadTime = 65;
            }
        }

    }    

    public void hit(Projectile hitee)
    {
        //checks if hit by projectile
        if(hitee.owner instanceof EnemyShip)
        {
            //checks if invulnerable
            if(!DevConsole.invulnerable && spawnProtection == 0)
            {
                //checks if shielded
                if(!shielded)
                {
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
                    }
                    else
                        delete = true;
                }
                else
                {
                    //shielded = false;
                    getWorld().removeObject(shield);
                }
            }
            hitee.delete();
        }
    }  
}
