import greenfoot.*;

/**
 * Write a description of class menuWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class menuWorld extends World
{

    /**
     * Constructor for objects of class menuWorld.
     * 
     */
    public menuWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(new button("start"), 500, 250);
        addObject(new button("title2"), 300, 150);
        addObject(new button("title"), 300, 200);
        Greenfoot.start();
    }
    public void act(){
        
    }
}
