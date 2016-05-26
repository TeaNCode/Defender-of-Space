import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The first boss you face
 * 
 * @author Tea N' Code
 */
public class EnemyBoss1 extends EnemyBoss
{
    public int hits = 0;
    public int rand1 = 500;
    public int rand2 = 500;
    public EnemyBoss1()
    {
        setImage("Boss.png");
    }

    public void act() 
    {
        if(direction == 1)
        {
            //Moves right
            if(getX() + 3 >= 849)
                setLocation(849,getY());
            else
                setLocation(getX() + 3, getY());
        }
        else
        {
            //Moves left
            if(getX() - 3 <= 229)
                setLocation(229,getY());
            else
                setLocation(getX() - 3, getY());
        }

        //Check if we need to change direction
        if(getX() >= 849)
        {
            direction = 2;
        }
        else if(getX() <= 229)
        {
            direction = 1;
        }

        //Shoot and spawn enemies
        if(Greenfoot.getRandomNumber(rand1) + 1 <= 1 * DevConsole.specialMultiplier)
        {
            getWorld().addObject(new HighVelocityRocket(90,this), getX(), getY());
            getWorld().addObject(new EnemyShip4(1), getX(), getY() + 140);
            //getWorld().addObject(new EnemyShip1(1), getX() + 20, getY()+ 120);
            //getWorld().addObject(new EnemyShip1(1), getX() - 20, getY()+ 120);
            rand1 = 500;
        }
        else rand1--;
        if(Greenfoot.getRandomNumber(rand2) + 1 <= 1 * DevConsole.specialMultiplier)
        {
            getWorld().addObject(new HighVelocityRocket(80,this), getX(), getY());
            getWorld().addObject(new HighVelocityRocket(85,this), getX(), getY() + 10);
            getWorld().addObject(new HighVelocityRocket(95,this), getX(), getY() + 10);
            getWorld().addObject(new HighVelocityRocket(100,this), getX(), getY());
            rand2 = 300;
        }
        else rand2--;
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
                GoodShip hiter = (GoodShip) hitee.owner;
                if(Greenfoot.getRandomNumber(100) + 1 >= hiter.bossBonus)
                hits++;
                hits++;
                hitee.delete();
            }
        }
    }
}
