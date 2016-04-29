import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerShip extends GoodShip
{
    //For variables see GoodShip
    public PlayerShip(SpaceWorld world)
    {
        setImage("playerShip.png");
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
            if (Greenfoot.isKeyDown("a"))
            {
                //moves right
                if(getX() - 5 <= 160 && !DevConsole.hiding)
                    setLocation(160,getY());
                else
                    move(-speed);
            }
            else if (Greenfoot.isKeyDown("d"))
            {
                //moves left
                if(getX() + 5 >= 870 && !DevConsole.hiding)
                    setLocation(870,getY());
                else
                    move(speed);
            }
            if (Greenfoot.isKeyDown("w"))
            {
                if(reloadDelayCount >= gunReloadTime || DevConsole.minigun) 
                {
                    if(penetrate){
                        getWorld().addObject(new PlayerRocket(-90, this, true),getX(),getY());
                        reloadDelayCount = 0;
                        shots++;
                        penShots++;
                        if(penShots== 3)
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
                    //shoots
                } 
            }
        }
        else
        {
            getWorld().removeObject(this);
        }

        if(attackSpeed){
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
        if(hitee.owner instanceof EnemyShip)
        {
            if(!DevConsole.invulnerable && spawnProtection == 0)
            {
                if(!shielded)
                {
                    int lives = world.lives.toArray().length;
                    getWorld().removeObject(world.lives.get(lives - 1));
                    world.lives.remove(lives - 1);
                    if(lives > 1)
                    {
                        setLocation(500,750);
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
