import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bullet7 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bullet7 extends enemyShips
{
    public int var;
    private int currentLive;
    enemyShip3 ship3;
    public bullet7()
    {
        turn(90);
        goodShips GoodShips;
        var = 1;
        currentLive = 1;
    }
    /**
     * Act - do whatever the bullet7 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        die();
        move(10);
        if (getY() == 899)
           {
              getWorld().removeObject(this);
          }
        
    }    
    public void die()
    {
        Actor ship = getOneObjectAtOffset(0, 0, ship.class);
        if(ship != null) 
        {
            //blows up the players ship
            getWorld().removeObject(ship);
            //getWorld().removeObject(this);
            //getWorld().removeObject(lives(currentLive));
            ship3.score = ship3.score - 1000;
            if(3 >= currentLive)
            {
                //respawns other lives
                getWorld(). addObject(new ship(), 500, 800);
                currentLive++;
            }
            else if ( 3 < currentLive)
            {
                //game over
                getWorld().removeObject(ship);
            }
        }
    }
    public void getCurrentLive()
    {
        if (currentLive == 1)
        {
            currentLive = 2;
        }
        else if (currentLive == 2)
        {
            currentLive = 3;
        }
        else if (currentLive == 3)
        {
            currentLive = 4;
        }
    }
}
