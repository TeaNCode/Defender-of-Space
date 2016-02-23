import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemyShip3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemyShip3 extends enemyShips
{
    public int health;
    private GreenfootImage ship5;
    private GreenfootImage ship;
    static int score;
    score Score;
    public enemyShip3()
    {
        //declares health, classes, and other ship images
        health = 2;
        goodShips GoodShips;
        ship5 = new GreenfootImage("ship5.png");
        ship = new GreenfootImage("enemy ship 3.png");
        score = 0;
    }
    /**
     * Act - do whatever the enemyShip3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.getRandomNumber(1500) == 1)
        {
            getWorld().addObject(new bullet7(), getX(), getY());
        }
        proximity();
        //destroyed3();
    }    
    public void proximity()
    {
         Actor bullet = getOneObjectAtOffset(0, 0, bullet.class);
         if(bullet != null)
         {
             //blows up the ship
             if (health == 2)
             {
               setImage(ship5);
               health--;
            }
            else if (health == 1)
            {
                getWorld().removeObject(bullet);
                getWorld().removeObject(this);
                health = 2;
                score = score + 500;
                Score.enemysKilled++;
            }
        }
    }
    public void destroyed3()
    {
       Actor bullet = getOneIntersectingObject(bullet.class);
        if(getOneIntersectingObject(bullet.class) != null) 
        {
            //blows up the ship
            getWorld().removeObject(bullet);
            if (getImage() == ship)
            {
                setImage(ship5);
            }
              else if (getImage() == ship5)
            {
                getWorld().removeObject(this);
            }
        }
        
    }
}
