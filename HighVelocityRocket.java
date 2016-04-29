import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * faster version of the enemy rocket
 * 
 * @author TeaNCode
 */
public class HighVelocityRocket extends Projectile
{
    public HighVelocityRocket(int rotation, Destroyable owner)
    {
        //constructor for normal rocket
        super(rotation, owner);
        this.penetrate = false;
        setImage("highVelocityRocket.fw.png");
    }
    
    public HighVelocityRocket(int rotation, Destroyable owner, boolean penetrate)
    {
        //constructor for penetrate rocket
        super(rotation,owner,penetrate);
        this.penetrate = penetrate;
        setImage("highVelocityRocket.fw.png");
    }

    /**
     * Act - do whatever the Plasma wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        move(13);//flys(faster than others)
        
        if(getY() == 799)
        {
            //checks for at world edge
            delete();
        }
        deleteCheck();
    }    

    public void collision(Projectile hitee)
    {
        //delets if hits something
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
