import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The first boss you face
 * 
 * @author Tea N' Code
 */
public class EnemyBoss1 extends EnemyShip
{
    public int hits = 0;
    public EnemyBoss1()
    {
        setImage("Boss.png");
    }

    public void act() 
    {
        if(direction == 1)
        {
            //Moves right
            setLocation(getX() + 4, getY());
        }
        else
        {
            //Moves left
            setLocation(getX() - 4, getY());
        }
        
        //Check if we need to change direction
        if(getX() >= 850)
        {
            direction = 2;
        }
        else if(getX() <= 180)
        {
            direction = 1;
        }

        //Shoot and spawn enemies
        if(Greenfoot.getRandomNumber(500) + 1 <= 1 * DevConsole.specialMultiplier)
        {
            getWorld().addObject(new HighVelocityRocket(90,this), getX(), getY());
            getWorld().addObject(new EnemyShip4(1), getX(), getY() + 140);
            getWorld().addObject(new EnemyShip1(1), getX() + 20, getY()+ 120);
            getWorld().addObject(new EnemyShip1(1), getX() - 20, getY()+ 120);
        }
    }    

    /**
     * What happens when it gets hit
     */
    public void hit(Projectile hitee)
    {
        if(hitee.owner instanceof GoodShip)
        {
            if(hits == 10){
                GoodShip killer = (GoodShip) (hitee.owner);
                getWorld().removeObject(this);
                killer.score = killer.score + 1500;
                killer.enemiesKilled++;
                addPowerup();
            }
            else {
                hits++;
                hitee.delete();
            }
        }
    }
}
