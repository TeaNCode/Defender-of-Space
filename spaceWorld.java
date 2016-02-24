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
        super(800, 575, 1); 
        //populate the world
        Once = false;//makes the score board invisible
        addObject(new ship(),400,540);
    }
   
    public void levelUp()
    {
        //probably need to create seperate worlds for diffrent levels
    }
    public void act()
    {
        //run the other levels
        once();
        //levelUp();
        
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
