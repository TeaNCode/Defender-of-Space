import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyRocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyRocket extends Projectile
{
    public EnemyRocket(EnemyShip owner)
    {
        super(90, owner);
        setImage("enemyRocket.png");
    }

    /**
     * Act - do whatever the EnemyRocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        move(9);
        if(getY() == 799 && !delete)
        {
            delete = true;
        }
        
        if(delete)
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
                delete();
            }
        }
    }
}
