import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyRocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyRocket extends Projectile
{
    public EnemyRocket()
    {
        super(90);
    }

    /**
     * Act - do whatever the EnemyRocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        move(10);
        if (getY() == 899)
        {
            getWorld().removeObject(this);
        }
    }    

    public void collision(Projectile hitee)
    {
        if(DevConsole.realism)
        {
            if(hitee instanceof PlayerRocket || hitee instanceof Plasma)
            {
                getWorld().removeObject(this);
            }
        }
    }
}
