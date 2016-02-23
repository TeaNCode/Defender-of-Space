import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class lives here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class lives extends goodShips
{
    private String name;
    public lives(String parName)
    {
        name = parName;
        enemyShips EnemyShips;
    }
    /**
     * Act - do whatever the lives wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        die();
    }    
    public void die()
    {
        Actor bullet7 = getOneObjectAtOffset(0, 0, ship.class);
        if(bullet7 != getOneObjectAtOffset(0, 0, ship.class)) 
        {
            getWorld().removeObject(this);
        }
    }
}
