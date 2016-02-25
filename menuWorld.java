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
        super(600, 400, 1); 
        addObject(new Button("start"), 500, 250);
        addObject(new Button("title2"), 300, 150);
        addObject(new Button("title"), 300, 200);
        Greenfoot.start();
    }
}
