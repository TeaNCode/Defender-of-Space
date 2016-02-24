import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class spaceWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemyShips extends Actor
{
    public int direction;
    public int X;
    /**
     * Constructor for objects of class spaceWorld.
     * 
     */
    public enemyShips()
    {    
    }
    public void move()
    {
        //moves the ships from side to side and down
        X = getX();
        if(X == 870)
        {
            direction = 2;
            setLocation(X, getY() + 50);
        }
        else if(X == 160)
        {
            direction = 1;
            setLocation(X, getY() + 50);
        }
        if(direction == 1)
        {
           setLocation(X + 1, getY()); 
        }
        else
        {
            setLocation(X - 1, getY());
        }
    }
}