import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bullet extends goodShips
{
    boolean edestroyed;
    private GreenfootImage ship5;
    private GreenfootImage ship;
    public bullet()
    {
        turn(-90);
        enemyShip2 EnemyShip2;
        enemyShips EnemyShips;
        ship5 = new GreenfootImage("ship5.png");
        ship = new GreenfootImage("enemy ship 3.png");
    }

    /**
     * Act - do whatever the bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(6);//flys
        if (getY() == 0)
        {
            getWorld().removeObject(this);//removes at edge
        }
    }    
}
