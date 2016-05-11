import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An enemy you face that shields itself
 * 
 * @author Tea N' Code
 */
public class EnemyShip4 extends EnemyShip
{
    //Shield's timer
    private int shieldInt;
    //If we're shielded
    private boolean shielded;
    //Stores the shield
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

        //Move and shoot and stuff
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

        //Safely end the game
        if(end)
        {
            SpaceWorld temp = (SpaceWorld)(getWorld());
            temp.showSummary(false);
            temp.showingSummary = true;
        }
    }    

    /**
     * What happens when the ship gets hit
     */
    public void hit(Projectile hitee)
    {
        if(hitee.owner instanceof GoodShip)
        {
            if(!hitee.penetrate)hitee.delete();
                else hitee.penetrate = false;
            if(!shielded)
            {
                GoodShip killer = (GoodShip) (hitee.owner);
                addPowerup();
                getWorld().removeObject(this);
                killer.score += 500;
                Save.money += 50;
                killer.enemiesKilled++;
            }
        }
    }
}
