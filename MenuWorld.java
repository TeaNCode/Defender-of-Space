import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuWorld extends World
{

    /**
     * Constructor for objects of class MenuWorld.
     * 
     */
    public MenuWorld()
    {    
        super(1000, 800, 1); 
        addObject(new Button("single"), getWidth() / 2, 450);
        addObject(new Button("multi"), getWidth() / 2, 550);
        addObject(new Button("title"), 301, 127);
        Greenfoot.start();
    }
}