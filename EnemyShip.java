import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class EnemyShip extends Destroyable
{
    public int direction;
    public boolean end;
    public void move()
    {
        //moves the ships from side to side
        int X = getX();
        if(direction == 1)
        {
            setLocation(X + 1, getY()); 
        }
        else
        {
            setLocation(X - 1, getY());
        }
    }  

    public void moveCheck()
    {
        if(script.equals("normal"))
        {
            if(getX() == 870)
            {
                script = "down 20";
                direction = 2;
            }
            else if(getX() == 160)
            {
                script = "down 20";
                direction = 1;
            }
            
            if(getY() >= 750)
            {
                end = true;
            }
        }
    }
}
