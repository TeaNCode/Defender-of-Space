import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * class for the rockete the player shoots
 * 
 * @author TeaNCode
 */
public class PlayerRocket extends Projectile
{
    public PlayerRocket(int rotation, GoodShip owner)
    {
        //constructor for normal player rocket
        super(rotation,owner);
        this.penetrate = false;
        setImage("playerRocket.png");
    }
    
    public PlayerRocket(int rotation, GoodShip owner, boolean penetrate)
    {
        //constructor for the penetrate rockets
        super(rotation,owner,penetrate);
        this.penetrate = penetrate;
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
            //checks for at world edge
            delete = true;
            GoodShip goodOwner = (GoodShip)(owner);
            goodOwner.misses++;
            goodOwner.penetrate = false;
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
