import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player2Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        
        if(attackSpeed){
            attackBoostedTime = 100;
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
                if(!shielded){
                    int lives = world.lives2.toArray().length;
                    getWorld().removeObject(world.lives2.get(lives - 1));
                    world.lives2.remove(lives - 1);
                    if(lives > 1)
                    {
                        setLocation(500,750);
                        spawnProtection = 50;
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
        }
    }  
}
