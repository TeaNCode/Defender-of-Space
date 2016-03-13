import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class PlayerRocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerRocket extends Projectile
{
    public PlayerRocket(GoodShip owner)
    {
        super(-90,owner);
        setImage("playerRocket.png");
        delete = false;
    }

    /**
     * Act - do whatever the PlayerRocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        move(6);//flys
        if (getY() == 0)
        {
            delete = true;
            GoodShip goodOwner = (GoodShip)(owner);
            goodOwner.misses++;
        }
        
        if(DevConsole.realism && !delete)
        {
            EnemyRocket rocket = getOneIntersectingObject(EnemyRocket.class);
            if(rocket != null)
            {
                rocket.delete();
                delete();
            }
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
            if(hitee instanceof EnemyRocket || hitee instanceof Plasma)
            {
                delete();
            }
        }
    }
}
