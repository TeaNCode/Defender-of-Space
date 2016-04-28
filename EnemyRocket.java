import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyRocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyRocket extends Projectile
{
    public EnemyRocket(int rotation, EnemyShip owner)
    {
        super(rotation, owner);
        this.penetrate = false;
        setImage("enemyRocket.png");
    }
    
    public EnemyRocket(int rotation, EnemyShip owner, boolean penetrate)
    {
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
        move(9);
        if(getY() == 799 && !delete)
        {
            delete = true;
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
