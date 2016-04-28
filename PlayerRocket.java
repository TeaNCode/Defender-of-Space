import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class PlayerRocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerRocket extends Projectile
{
    public PlayerRocket(int rotation, GoodShip owner)
    {
        super(rotation,owner);
        setImage("playerRocket.png");
    }
    
    public PlayerRocket(GoodShip owner)
    {
        super(-90,owner);
        setImage("playerRocket.png");
    }
    
    public PlayerRocket(int rotation, GoodShip owner, boolean penetrate)
    {
        super(rotation,owner,penetrate);
        setImage("playerRocket.png");
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
            goodOwner.penetrate = false;
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
