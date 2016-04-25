import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyBoss1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyBoss1 extends EnemyShip
{
    public int hits = 0;
    public EnemyBoss1(int direction)
    {
        setImage("Boss.png");
        this.direction = direction;
        script = "normal";
    }

    /**
     * Act - do whatever the EnemyBoss1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        if(getX() == 870)
        {
            direction = 2;
        }
        else if(getX() == 160)
        {
            direction = 1;
        }

        if(script.equals("normal"))
        {
            move();
            if(Greenfoot.getRandomNumber(250) + 1 <= 1 * DevConsole.attackMultiplier)
            {
                getWorld().addObject(new HighVelocityRocket(90,this), getX(), getY());
                getWorld().addObject(new EnemyShip4(1), getX(), getY() - 40);
                getWorld().addObject(new EnemyShip1(1), getX() + 20, getY()- 20);
                getWorld().addObject(new EnemyShip1(1), getX() - 20, getY()- 20);
            }
        }
        else if(script.startsWith("down "))
            downScript();
    }    

    public void hit(Projectile hitee)
    {
        if(hits == 10){
            if(hitee.owner instanceof GoodShip)
            {
                    if(!hitee.penetrate)hitee.delete();
                    else hitee.penetrate = false;
                    GoodShip killer = (GoodShip) (hitee.owner);
                    getWorld().removeObject(this);
                    killer.score = killer.score + 1500;
                    killer.enemiesKilled++;
            }
            else hits++;
        }
    }
}
