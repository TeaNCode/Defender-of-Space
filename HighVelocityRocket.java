import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HighVelocityRocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HighVelocityRocket extends Projectile
{
    public HighVelocityRocket(int rotation, Destroyable owner)
    {
        super(rotation, owner);
        setImage("highVelocityRocket.fw.png");
    }

    /**
     * Act - do whatever the Plasma wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        move(13);
        
        if(getY() == 799)
        {
            delete();
        }
        deleteCheck();
    }    

    public void collision(Projectile hitee)
    {
        if(DevConsole.realism)
        {
            if((hitee.owner instanceof EnemyShip && owner instanceof GoodShip) ||
            (hitee.owner instanceof GoodShip && owner instanceof EnemyShip))
            {
                delete();
            }
        }
    }
}
