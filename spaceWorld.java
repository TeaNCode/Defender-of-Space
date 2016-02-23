import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class spaceWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class spaceWorld extends World
{
    score Score;
    public boolean Once;
    /**
     * Constructor for objects of class spaceWorld.
     * 
     */
    public spaceWorld()
    {    
        // Create a new world with 1000x900 cells with a cell size of 1x1 pixels.
        super(1000, 900, 1); 
        //populate the world
        Once = false;//makes the score board invisible
        for( int Y = 1; Y < 3; Y++)
        {
           for( int X = 1; X < 11; X++)
            {
                addObject(new enemyShip2(),250 + (X * 50),150 + (Y * 50));
            }
        }
        for( int Y = 1; Y < 3; Y++)
        {
           for( int X = 1; X < 11; X++)
            {
                addObject(new enemyShip1(),250 + (X * 50),50 + (Y * 50));
            }
        }
        addObject(new enemyShip3(),500,50);
        addObject(new enemyShip3(),550,50);
        addObject(new enemyShip3(),600,50);
        addObject(new enemyShip3(),450,50);
        addObject(new ship(),500,800);
        addObject(new lives("1"),850,800);
        addObject(new lives("2"),950,800);
        addObject(new lives("3"),900,800);
        
    }
   
    public void levelUp()
    {
        //brings you to the next level
        if(Score.enemysKilled == 44)
        {
          //  Score.enemysKilled = 0;
            for( int Y = 1; Y < 3; Y++)
        {
           for( int X = 1; X < 11; X++)
            {
                addObject(new enemyShip2(),250 + (X * 50),150 + (Y * 50));
            }
        }
        for( int Y = 1; Y < 3; Y++)
        {
           for( int X = 1; X < 11; X++)
            {
                addObject(new enemyShip1(),250 + (X * 50),50 + (Y * 50));
            }
        }
        }
    }
    public void act()
    {
        //run the other levels
        once();
        levelUp();
        
    }
    public void once()
    {
        //makes score board invisible
        if(Once == false)
        {
            Once = true;
            addObject(new score(), 100, 60);
        }
    }
}
