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
    boolean edestroyed;
    public GreenfootImage ship5;
    public GreenfootImage ship;
    /**
     * Constructor for objects of class spaceWorld.
     * 
     */
    public enemyShips()
    {    
       //declares classes
        goodShips GoodShips;
       ship5 = new GreenfootImage("ship5.png");
       ship = new GreenfootImage("enemy ship 3.png");
    }
    public void act()
    {
       //destroyed();
       //destroyed2();
       //destroyed3();
    }
    public void move()
    {
        //moves the ships from side to side and down
        X = getX();
        if(X == 870)
        {
            direction = 2;
            setLocation(getX(), getY() + 50);
        }
        else if(X == 160)
        {
            direction = 1;
            setLocation(getX(), getY() + 50);
        }
        if(direction == 1)
        {
           setLocation(getX() + 1, getY()); 
        }
        else
        {
            setLocation(getX() - 1, getY());
        }
    }
    
    
   
}