import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * normal enemy rocket class
 * 
 * @author TeaNCode
 */
public class EnemyRocket extends Projectile
{
    public EnemyRocket(int rotation, EnemyShip owner)
    {
        //normal constructor for enemy bullet
        super(rotation, owner);
        this.penetrate = false;
        setImage("enemyRocket.png");
    }
    
    public EnemyRocket(int rotation, EnemyShip owner, boolean penetrate)
    {
        //pemetration constructor for enemy bullet
        super(rotation,owner,penetrate);
        this.penetrate = penetrate;
        setImage("enemyRocket.png");
    }

    /**
     * Act - do whatever the EnemyRocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        move(9);//flys
        if(getY() == 799)
        {
            //delets at edge
            delete = true;
        }
        deleteCheck();
    }    

    public void collision(Projectile hitee)
    {
        //deletes if collides with something
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
