import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyShip4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyShip4 extends EnemyShip
{
    private int shieldInt;
    private boolean shielded;
    private Shield shield;
    public EnemyShip4(int direction)
    {
        setImage("enemyShip4.png");
        this.direction = direction;
        script = "normal";
        end = false;
        shielded = false;
        shieldInt = 99;
    }

    /**
     * Act - do whatever the EnemyShip4 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveCheck();

        //Manage shield
        if(shielded)
        {
            if(shieldInt == 50)
            {
                shielded = false;
                shieldInt = 0;
                getWorld().removeObject(shield);
            }
            else
                shieldInt++;
        }
        else
        {
            if(shieldInt == 100)
            {
                shielded = true;
                shieldInt = 0;
                shield = new Shield(this,1);
                getWorld().addObject(shield,getX(),getY());
            }
            else
                shieldInt++;
        }

        if(script.equals("normal"))
        {
            move();
            if(Greenfoot.getRandomNumber(1499) + 1 <= 1 * DevConsole.attackMultiplier)
            {
                getWorld().addObject(new EnemyRocket(90,this), getX(), getY());
            }
        }
        else if(script.startsWith("down "))
            downScript();
    }    

    public void hit(Projectile hitee)
    {
        if(hitee.owner instanceof GoodShip)
        {
            if(!Projectile.penetrate)hitee.delete();
            if(!shielded)
            {
                GoodShip killer = (GoodShip) (hitee.owner);
                addPowerup();
                getWorld().removeObject(this);
                killer.score = killer.score + 500;
                killer.enemiesKilled++;
            }
            else if(Projectile.penetrate){
                GoodShip killer = (GoodShip) (hitee.owner);
                addPowerup();
                getWorld().removeObject(this);
                killer.score = killer.score + 500;
                killer.enemiesKilled++;
            }
        }
    }
}
